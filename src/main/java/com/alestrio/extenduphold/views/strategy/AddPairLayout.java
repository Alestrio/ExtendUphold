package com.alestrio.extenduphold.views.strategy;

import com.alestrio.extenduphold.data.api.assets.*;
import com.vaadin.flow.component.ItemLabelGenerator;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;

public class AddPairLayout extends FormLayout {
    public AddPairLayout(){
        ComboBox<AssetType> assetType = new ComboBox<>();
        ComboBox<AbstractAsset> secondary = new ComboBox<>();

        assetType.setItems(AssetType.values());
        assetType.setItemLabelGenerator((ItemLabelGenerator<AssetType>) item -> getTranslation("strategy.assettype."+item.getSuffix()));
        assetType.addValueChangeListener(event ->{
            switch (event.getValue()){
                case FIAT:
                    secondary.setItems(Fiat.values());
                    break;
                case MISC:
                    secondary.setItems(Misc.values());
                    break;
                case ENVIRONMENTAL:
                    secondary.setItems(Environmental.values());
                    break;
                case STABLECOINS:
                    secondary.setItems(Stablecoins.values());
                    break;
                case METALS:
                    secondary.setItems(Metals.values());
                    break;
                case CRYPTO:
                    secondary.setItems(Crypto.values());
                    break;
                case EQUITIES:
                    secondary.setItems(Equities.values());
                    break;
            }
            secondary.setItemLabelGenerator( e -> getTranslation("strategy.asset."+e.getSymbol()));
        });

        add(/*new H2(getTranslation("strategy.assettype"))*/ assetType, secondary);
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
