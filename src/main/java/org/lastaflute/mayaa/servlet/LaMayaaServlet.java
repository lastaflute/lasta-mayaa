/*
 * Copyright 2015-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.lastaflute.mayaa.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.seasar.mayaa.impl.MayaaServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jflute
 * @since 0.2.0 (2016/01/03 Sunday)
 */
public class LaMayaaServlet extends MayaaServlet {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(LaMayaaServlet.class);

    // ===================================================================================
    //                                                                       Core Override
    //                                                                       =============
    @Override
    public void init() {
        logger.info("...Initializing LastaFlute Mayaa Servlet: {}", this);
        super.init();
    }

    @Override
    protected void doService(HttpServletRequest request, HttpServletResponse response) {
        // #thiking: want to except plain HTML
        //if (policy.isMayaaTemplate(request.getServletPath())) {
        logger.debug("#flow ...Routing as #mayaa template: {}", request.getRequestURI());
        super.doService(request, response);
    }
}
