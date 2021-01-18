package com.alestrio.extenduphold.views.strategy;

import com.alestrio.extenduphold.data.api.assets.Crypto;
import com.vaadin.flow.component.ItemLabelGenerator;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;

import java.util.ArrayList;
import java.util.Arrays;

public class AddPairLayout extends FormLayout {
    public AddPairLayout(){
        /*ComboBox<String> assetType = new ComboBox<>();
        ArrayList<String> itemsAssets = new ArrayList<String>(Arrays.asList(
                getTranslation("strategy.assettype." + AssetType.CRYPTO.getSuffix()),
                getTranslation("strategy.assettype." + AssetType.ENVIRONMENTAL.getSuffix()),
                getTranslation("strategy.assettype." + AssetType.EQUITIES.getSuffix()),
                getTranslation("strategy.assettype." + AssetType.FIAT.getSuffix()),
                getTranslation("strategy.assettype." + AssetType.METALS.getSuffix()),
                getTranslation("strategy.assettype." + AssetType.MISC.getSuffix()),
                getTranslation("strategy.assettype." + AssetType.STABLECOINS.getSuffix())
        ));
        assetType.setItems(itemsAssets);*/
        ComboBox<AssetType> assetType = new ComboBox<>();
        ComboBox<Crypto> cryptos = new ComboBox<>();

        assetType.setItems(AssetType.values());
        assetType.setItemLabelGenerator(new ItemLabelGenerator<AssetType>() {
            @Override
            public String apply(AssetType item) {
                return getTranslation("strategy.assettype."+item.getSuffix());
            }
        });

        add(/*new H2(getTranslation("strategy.assettype"))*/ assetType, cryptos);
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
