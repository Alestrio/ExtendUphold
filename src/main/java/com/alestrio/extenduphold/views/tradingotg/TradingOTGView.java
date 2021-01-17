package com.alestrio.extenduphold.views.tradingotg;

import com.alestrio.extenduphold.views.main.MainView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "otg", layout = MainView.class)
public class TradingOTGView extends VerticalLayout {
    public TradingOTGView(){
        UI.getCurrent().getPage().setTitle(getTranslation("drawer.trading_otg"));

    }
}
