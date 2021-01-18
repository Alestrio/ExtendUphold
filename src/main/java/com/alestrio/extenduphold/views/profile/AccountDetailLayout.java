package com.alestrio.extenduphold.views.profile;

import com.alestrio.extenduphold.data.entity.User;
import com.alestrio.extenduphold.data.service.TransactionService;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

/**
 * This is the class creating the profile layout based on user information
 */
public class AccountDetailLayout extends VerticalLayout {

    public AccountDetailLayout(User user){
        HorizontalLayout ppname = new HorizontalLayout();
        Image pp = new Image(user.getPhoto_url(), "profile photo");
        ppname.add(pp, new Label(user.getUsername()));
        ppname.setSizeFull();

        Label email = new Label(user.getEmail());
        Label txCount = new Label(getTranslation("profile.txCount") + " " + TransactionService.findAll().size());
        Label copytoken = new Label(getTranslation("profile.copytoken") + " " + user.getCopy_token());


        add(
                ppname,
                email,
                txCount,
                copytoken
        );
    }

    public VerticalLayout get(){
        return this;
    }

}
