package com.alestrio.extenduphold.views.strategy;

import com.alestrio.extenduphold.data.api.assets.*;
import com.vaadin.flow.component.ItemLabelGenerator;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class AddPairLayout extends VerticalLayout {
    public AddPairLayout(){
        setSizeFull();

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

        Label label1 = new Label(getTranslation("strategy.label1"));
        Label label2 = new Label(getTranslation("strategy.label2"));

        HorizontalLayout firstRow = new HorizontalLayout(label1, assetType1, secondary1);
        HorizontalLayout secondRow = new HorizontalLayout(label2, assetType2, secondary2);
        firstRow.setSizeFull();
        secondRow.setSizeFull();
        firstRow.setAlignItems(Alignment.CENTER);
        secondRow.setAlignItems(Alignment.CENTER);
        firstRow.expand(assetType1, secondary1);
        secondRow.expand(assetType2, secondary2);
        label1.setWidth("12em");
        label2.setWidth("12em");

        Button validate = new Button(getTranslation("strategy.validate"));
        validate.addClickListener(e -> btnValidate(secondary1, secondary2));
        HorizontalLayout btnLayout = new HorizontalLayout(validate);
        btnLayout.setSizeFull();
        btnLayout.setAlignItems(Alignment.CENTER);
        btnLayout.expand(validate);

        setAlignSelf(Alignment.STRETCH);

        add(new H2(getTranslation("strategy.createpair")), firstRow, secondRow, btnLayout);
    }

    private void btnValidate(ComboBox<AbstractAsset> secondary1, ComboBox<AbstractAsset> secondary2) {

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
