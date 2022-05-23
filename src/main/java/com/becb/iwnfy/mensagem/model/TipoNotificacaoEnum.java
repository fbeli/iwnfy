package com.becb.iwnfy.mensagem.model;

public enum TipoNotificacaoEnum {

    SMS, EMAIL,INSTAGRAM, FACEBOOK;

    public String value() {
        return name();
    }

}
