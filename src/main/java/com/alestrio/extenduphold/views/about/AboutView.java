package com.alestrio.extenduphold.views.about;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.details.DetailsVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.alestrio.extenduphold.views.main.MainView;

@Route(value = "about", layout = MainView.class)
@PageTitle("About")
public class AboutView extends Div {
    /**
     * This is the view who contains every legal informations needed.
     */
    public AboutView() {

        setId("about-view");
        Accordion aboutAccordion = new Accordion();

        aboutAccordion.add(getTranslation("about.titles.confidentiality"), new Span(getTranslation("about.text.confidentiality"))).addThemeVariants(DetailsVariant.FILLED); /* TODO to multiline on config file*/
        aboutAccordion.add(getTranslation("about.titles.disclaimer"), new Span(getTranslation("about.text.disclaimer"))).addThemeVariants(DetailsVariant.FILLED);
        aboutAccordion.add(getTranslation("about.titles.volatilityWarning"), new Span(getTranslation("about.text.volatilityWarning"))).addThemeVariants(DetailsVariant.FILLED);
        aboutAccordion.add(getTranslation("about.titles.fees"), new Span(getTranslation("about.text.fees"))).addThemeVariants(DetailsVariant.FILLED);
        add(aboutAccordion);
    }

}
