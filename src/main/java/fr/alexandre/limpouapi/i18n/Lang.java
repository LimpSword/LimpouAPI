package fr.alexandre.limpouapi.i18n;

import lombok.Getter;

@Getter
public enum Lang {

    fr_FR("fr_FR"),
    en_US("en_US");

    private final String lang;

    Lang(String lang) {
        this.lang = lang;
    }
}
