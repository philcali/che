/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Red Hat, Inc. - initial API and implementation
 */
package org.eclipse.che.ide.ext.java.client;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

/** @author Evgen Vidolob */
public interface Resources extends ClientBundle {

  @Source({"Semantic.css"})
  SemanticCss css();

  interface SemanticCss extends CssResource {

    String field();

    String typeParameter();

    String deprecatedMember();

    String staticField();

    String staticFinalField();

    String staticMethodInvocation();

    String methodDeclaration();
  }
}
