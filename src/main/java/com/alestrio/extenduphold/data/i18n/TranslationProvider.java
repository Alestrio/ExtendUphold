package com.alestrio.extenduphold.data.i18n;

import com.vaadin.flow.i18n.I18NProvider;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.*;

@Component
/**
 * This is the class responsible for supplying needed strings to the views
 */
public class TranslationProvider implements I18NProvider {

    private static final String BUNDLE_BASE_NAME = "strings";

    @Override
    public List<Locale> getProvidedLocales() {
        return Collections
                .unmodifiableList(Arrays.asList(new Locale("en"), new Locale("fr")));
    }

    @Override
    public String getTranslation(String key, Locale locale, Object... params) {
        final ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_BASE_NAME, locale);

        String value = bundle.getString(key);
        if(params.length > 0){
            value =  MessageFormat.format(value, params);
        }
        return value;

    }
}