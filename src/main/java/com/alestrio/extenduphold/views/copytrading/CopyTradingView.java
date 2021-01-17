package com.alestrio.extenduphold.views.copytrading;

import com.alestrio.extenduphold.views.main.MainView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "copytrading", layout = MainView.class)
public class CopyTradingView extends VerticalLayout {
    public CopyTradingView(){
        UI.getCurrent().getPage().setTitle(getTranslation("drawer.copytrading"));

    }
}
