package com.alestrio.extenduphold.views.txhistory;

import com.alestrio.extenduphold.views.main.MainView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "tx", layout = MainView.class)
public class TxHistoryView extends VerticalLayout {
    public TxHistoryView(){
        UI.getCurrent().getPage().setTitle(getTranslation("drawer.txhistory"));

    }
}
