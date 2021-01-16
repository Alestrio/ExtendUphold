package com.alestrio.extenduphold.views.usercreator;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("register")
public class UserCreationView extends VerticalLayout {

    private final TextField pseudo = new TextField(getTranslation("register.pseudo"));
    private final TextField email = new TextField(getTranslation("register.email"));
    private final PasswordField password = new PasswordField(getTranslation("register.password"));
    private final PasswordField confirmPassword = new PasswordField(getTranslation("register.confirmPassword"));
    private final Button save = new Button(getTranslation("register.submit"));


    public UserCreationView() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(new H1(getTranslation("register.h1")), pseudo, email, password, confirmPassword, save);
        save.addClickListener(e -> submit());
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        setSizeFull();

    }

    private void submit(){
        /* TODO submit user creation */
    }
}
