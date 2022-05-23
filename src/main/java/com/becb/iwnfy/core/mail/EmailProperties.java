package com.becb.iwnfy.core.mail;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ConfigurationProperties("iwnfy.email")
public class EmailProperties {

	private String remetente;
}
