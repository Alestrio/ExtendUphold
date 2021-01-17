package com.alestrio.extenduphold.views.usercreator;

import com.alestrio.extenduphold.data.entity.User;
import com.alestrio.extenduphold.data.service.UserService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
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
        if(password.getValue().equals(confirmPassword.getValue())){
            User user = new User();
            Binder<User> binder = new Binder<>();
            binder.forField(pseudo).bind(User::getUsername, User::setUsername);
            binder.forField(email).bind(User::getEmail, User::setUsername);
            binder.forField(password).bind(User::getPassword, User::setPassword);
            try {
                binder.writeBean(user);
                UserService service = new UserService();
                service.addUser(user);
                UI.getCurrent().navigate("login");
            } catch (ValidationException e) {
                e.printStackTrace();
            }
        }

    }
}
