package com.becb.iwnfy.model;

public enum TipoNotificacaoEnum {

    SMS, EMAIL,INSTAGRAM, FACEBOOK;

    public String value() {
        return name();
    }

}
