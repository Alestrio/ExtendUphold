package com.alestrio.extenduphold.views.profile;

import com.alestrio.extenduphold.NoLoggedUserException;
import com.alestrio.extenduphold.data.entity.User;
import com.alestrio.extenduphold.data.service.UserService;
import com.alestrio.extenduphold.views.main.MainView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Route(value = "profile", layout = MainView.class)
public class ProfileView extends VerticalLayout {

    public ProfileView() throws NoLoggedUserException {

        UI.getCurrent().getPage().setTitle(getTranslation("drawer.profile"));
        UserService service = new UserService();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = service.findByUsername(auth.getName());

        if(!user.getUsername().isEmpty()){
            AccountDetailLayout layout = new AccountDetailLayout(user);
            add(new H1(getTranslation("profile.title")), layout);
        }else{
            throw new NoLoggedUserException();
        }
    }
}
