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
package org.lastaflute.mayaa;

import org.lastaflute.web.response.HtmlResponse;
import org.lastaflute.web.ruts.NextJourney;
import org.lastaflute.web.ruts.process.ActionRuntime;
import org.lastaflute.web.ruts.renderer.HtmlRenderer;
import org.lastaflute.web.ruts.renderer.HtmlRenderingProvider;

/**
 * Mayaa rendering provider of Lastaflute.
 * @author jflute
 */
public class MayaaRenderingProvider implements HtmlRenderingProvider {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected boolean development; // #thinkg: can we use?

    // ===================================================================================
    //                                                                              Option
    //                                                                              ======
    public MayaaRenderingProvider asDevelopment(boolean development) {
        this.development = development;
        return this;
    }

    // ===================================================================================
    //                                                                             Provide
    //                                                                             =======
    /**
     * @param runtime The runtime of current requested action. (NotNull)
     * @param journey The journey to next stage. (NotNull)
     * @return The renderer to render HTML. (NotNull)
     */
    @Override
    public HtmlRenderer provideRenderer(ActionRuntime runtime, NextJourney journey) {
        return DEFAULT_RENDERER; // #thinking: mayaa can be treated as JSP
    }

    @Override
    public HtmlResponse provideShowErrorsResponse(ActionRuntime runtime) {
        return HtmlResponse.fromForwardPath("/error/show_errors.xhtml");
    }
}