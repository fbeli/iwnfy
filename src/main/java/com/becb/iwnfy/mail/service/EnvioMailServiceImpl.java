package com.becb.iwnfy.mail.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.becb.iwnfy.core.mail.EmailProperties;
import com.becb.iwnfy.exceptions.MailException;

@Service
public class EnvioMailServiceImpl implements EnvioMailService {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private EmailProperties emailProperties;

	@Override
	public void enviar(MensagemEmail mensagem) {
		// TODO Auto-generated method stub
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");
			helper.setSubject(mensagem.getAssunto());
			helper.setText(mensagem.getCorpo(), true);
			helper.setFrom(emailProperties.getRemetente());
			helper.setTo(mensagem.getDestinatarios().toArray(new String[0]));

			mailSender.send(mimeMessage);
		} catch (Exception e) {
			throw new MailException("Não foi possível enviar a mensagem", e);
		}
	}
}
