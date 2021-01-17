package com.alestrio.extenduphold.views.strategy;

import com.alestrio.extenduphold.views.main.MainView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "strategy", layout = MainView.class)
public class StrategyView extends VerticalLayout {
    public StrategyView(){
        UI.getCurrent().getPage().setTitle(getTranslation("drawer.strategy"));

    }
}
