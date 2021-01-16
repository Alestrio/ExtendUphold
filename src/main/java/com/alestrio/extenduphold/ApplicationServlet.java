package com.alestrio.extenduphold;

import com.vaadin.flow.server.InitParameters;
import com.vaadin.flow.server.VaadinServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * This is the servlet needed to provide I18N class informations to the applet
 */
@WebServlet(urlPatterns = "/*", name = "slot", asyncSupported = true, initParams = {
        @WebInitParam(name = InitParameters.I18N_PROVIDER, value = "com.alestrio.extenduphold.data.i18n.TranslationProvider") })
public class ApplicationServlet extends VaadinServlet {
}
