/*
 * Copyright 2014-2015 the original author or authors.
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

import org.dbflute.util.Srl;
import org.lastaflute.web.util.LaServletContextUtil;
import org.seasar.mayaa.impl.MayaaServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jflute
 */
public class LastaMayaaServlet extends MayaaServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(LastaMayaaServlet.class);
    public static final String MAYAALIKE_SUFFIX = ".mayaalike.html";

    @Override
    public void init() {
        logger.info("...Initializing Mayaa Servlet: {}", this);
        super.init();
    }

    @Override
    protected void doService(HttpServletRequest request, HttpServletResponse response) {
        logger.debug("#flow ...Routing as #mayaa template: {}", request.getRequestURI());
        super.doService(request, response);
    }

    // ===================================================================================
    //                                                             Mayaa Template Handling
    //                                                             =======================
    public static boolean isMayaaTemplate(String routingPath) {
        final String mayaaPath = getMayaaViewPrefix() + convertToMayaaPath(routingPath);
        return LaServletContextUtil.getServletContext().getResourceAsStream(mayaaPath) != null;
    }

    public static String getMayaaViewPrefix() {
        return LaServletContextUtil.getHtmlViewPrefix(); // same as lastaflute's policy
    }

    public static String prepareMayaalikeHtmlPath(String routingPath) {
        final String mayaalikeSuffix = MAYAALIKE_SUFFIX;
        if (routingPath.contains(mayaalikeSuffix)) { // already mayaa-like
            return routingPath;
        } else {
            return Srl.replace(routingPath, mayaalikeSuffix, ".html");
        }
    }

    public static String removeMayaalikeMark(String routingPath) {
        return Srl.replace(routingPath, MAYAALIKE_SUFFIX, ".html");
    }

    public static String convertToMayaaPath(String routingPath) {
        return Srl.substringLastFront(removeMayaalikeMark(routingPath), ".html") + ".mayaa";
    }
}
