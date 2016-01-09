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
package org.lastaflute.mayaa.policy;

import org.dbflute.util.Srl;
import org.lastaflute.web.util.LaServletContextUtil;

/**
 * @author jflute
 * @since 0.2.0 (2016/01/03 Sunday)
 */
public class LaMayaaPolicy { // DI component

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    public static final String HTML_EXT = ".html";
    public static final String MAYAA_EXT = ".mayaa";
    public static final String MAYAALIKE_HTML_EXT = HTML_EXT; // #thiking: url-pattern .html OK?
    public static final String SHOW_ERRORS_PATH = "/error/show_errors" + HTML_EXT;

    // ===================================================================================
    //                                                                      Mayaa Template
    //                                                                      ==============
    public boolean isMayaaTemplate(String routingPath) { // #thiking: want to cache
        final String mayaaPath = getMayaaViewPrefix() + convertToMayaaPath(routingPath);
        return LaServletContextUtil.getServletContext().getResourceAsStream(mayaaPath) != null;
    }

    public String getMayaaViewPrefix() {
        return LaServletContextUtil.getHtmlViewPrefix(); // same as lastaflute's policy
    }

    public String prepareMayaalikeHtmlPath(String routingPath) {
        if (routingPath.contains(MAYAALIKE_HTML_EXT)) { // already mayaa-like
            return routingPath;
        } else {
            return Srl.replace(routingPath, HTML_EXT, MAYAALIKE_HTML_EXT);
        }
    }

    public String removeMayaalikeMark(String routingPath) {
        return Srl.replace(routingPath, MAYAALIKE_HTML_EXT, HTML_EXT);
    }

    public String convertToMayaaPath(String routingPath) {
        return Srl.substringLastFront(removeMayaalikeMark(routingPath), HTML_EXT) + MAYAA_EXT;
    }

    // ===================================================================================
    //                                                                         Show Errors
    //                                                                         ===========
    public String provideShowErrorsPath() {
        return SHOW_ERRORS_PATH;
    }
}
