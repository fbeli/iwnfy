package com.becb.iwnfy.mail.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.becb.iwnfy.core.mail.EmailProperties;
import com.becb.iwnfy.exceptions.MailException;

import freemarker.template.Configuration;
import freemarker.template.Template;

@Service
public class EnvioMailServiceImpl implements EnvioMailService {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private EmailProperties emailProperties;
	

	@Autowired
	private Configuration freemarkerConfig;

	@Override
	public void enviar(MensagemEmail mensagem) {
		
		try {
			
			String corpo = processarTemplate(mensagem);
			
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");
			helper.setSubject(mensagem.getAssunto());
			helper.setFrom(emailProperties.getRemetente());
			helper.setTo(mensagem.getDestinatarios().toArray(new String[0]));
			helper.setText(corpo, true);

			mailSender.send(mimeMessage);
		} catch (Exception e) {
			throw new MailException("Não foi possível enviar a mensagem", e);
		}
	}
	
	private String processarTemplate(MensagemEmail mensagem) {
		try {
			Template template = freemarkerConfig.getTemplate(mensagem.getCorpoHtml());
			
			return FreeMarkerTemplateUtils.processTemplateIntoString(
					template, mensagem.getVariaveis());
		} catch (Exception e) {
			throw new MailException("Não foi possível montar o template do e-mail", e);
		}
	}
	
}
