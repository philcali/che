package org.eclipse.che.api.system.server;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Collections;
import java.util.Set;
import org.eclipse.che.commons.schedule.executor.ThreadPullLauncher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Terminates {@link ThreadPullLauncher}.
 *
 * @author Anton Korneta
 */
@Singleton
public class CronThreadPullTermination implements ServiceTermination {
  private static final Logger LOG = LoggerFactory.getLogger(CronThreadPullTermination.class);

  public static final String SERVICE_NAME = "CronJobService";

  private final ThreadPullLauncher launcher;

  @Inject
  public CronThreadPullTermination(ThreadPullLauncher launcher) {
    this.launcher = launcher;
  }

  @Override
  public void terminate() throws InterruptedException {
    suspend();
  }

  @Override
  public void suspend() throws InterruptedException, UnsupportedOperationException {
    try {
      launcher.shutdown();
    } catch (RuntimeException ex) {
      LOG.error("Failed to stop cron job thread pool. Cause: " + ex.getMessage());
    }
  }

  @Override
  public String getServiceName() {
    return SERVICE_NAME;
  }

  @Override
  public Set<String> getDependencies() {
    return Collections.emptySet();
  }
}
