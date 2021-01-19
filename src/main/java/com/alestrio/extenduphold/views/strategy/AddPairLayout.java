package com.alestrio.extenduphold.views.strategy;

import com.alestrio.extenduphold.data.api.assets.*;
import com.vaadin.flow.component.ItemLabelGenerator;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class AddPairLayout extends VerticalLayout {
    public AddPairLayout(){
        ComboBox<AssetType> assetType1 = new ComboBox<>();
        ComboBox<AbstractAsset> secondary1 = new ComboBox<>();

        assetType1.setItems(AssetType.values());
        assetType1.setItemLabelGenerator((ItemLabelGenerator<AssetType>) item -> getTranslation("strategy.assettype."+item.getSuffix()));
        assetType1.addValueChangeListener(event ->{
            switch (event.getValue()){
                case FIAT:
                    secondary1.setItems(Fiat.values());
                    break;
                case MISC:
                    secondary1.setItems(Misc.values());
                    break;
                case ENVIRONMENTAL:
                    secondary1.setItems(Environmental.values());
                    break;
                case STABLECOINS:
                    secondary1.setItems(Stablecoins.values());
                    break;
                case METALS:
                    secondary1.setItems(Metals.values());
                    break;
                case CRYPTO:
                    secondary1.setItems(Crypto.values());
                    break;
                case EQUITIES:
                    secondary1.setItems(Equities.values());
                    break;
            }
            secondary1.setItemLabelGenerator( e -> getTranslation("strategy.asset."+e.getSymbol().toLowerCase()));
        });

        ComboBox<AssetType> assetType2 = new ComboBox<>();
        ComboBox<AbstractAsset> secondary2 = new ComboBox<>();

        assetType2.setItems(AssetType.values());
        assetType2.setItemLabelGenerator((ItemLabelGenerator<AssetType>) item -> getTranslation("strategy.assettype."+item.getSuffix()));
        assetType2.addValueChangeListener(event ->{
            switch (event.getValue()){
                case FIAT:
                    secondary2.setItems(Fiat.values());
                    break;
                case MISC:
                    secondary2.setItems(Misc.values());
                    break;
                case ENVIRONMENTAL:
                    secondary2.setItems(Environmental.values());
                    break;
                case STABLECOINS:
                    secondary2.setItems(Stablecoins.values());
                    break;
                case METALS:
                    secondary2.setItems(Metals.values());
                    break;
                case CRYPTO:
                    secondary2.setItems(Crypto.values());
                    break;
                case EQUITIES:
                    secondary2.setItems(Equities.values());
                    break;
            }
            secondary2.setItemLabelGenerator( e -> getTranslation("strategy.asset."+e.getSymbol().toLowerCase()));
        });


        add(new H2(getTranslation("strategy.createpair")), new HorizontalLayout(assetType1, secondary1), new HorizontalLayout(assetType2, secondary2));
    }
}

enum AssetType{
    CRYPTO("crypto"),
    ENVIRONMENTAL("envt"),
    EQUITIES("equt"),
    FIAT("fiat"),
    METALS("metals"),
    MISC("misc"),
    STABLECOINS("stable");

    private final String suffix;

    AssetType(String suffix) {
        this.suffix = suffix;
    }

    public String getSuffix() {
        return suffix;
    }
}
