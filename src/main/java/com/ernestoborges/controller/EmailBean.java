package com.ernestoborges.controller;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.apache.commons.mail.EmailException;

import com.ernestoborges.model.EmailSender;
import com.ernestoborges.util.EmailUtils;


/**
 * 
 * @author
 *
 */

@Named
@ViewScoped
public class EmailBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private EmailSender mensagemSender = new EmailSender();

	public EmailSender getEmailSender() {
		return mensagemSender;
	}

	public void setEmailSender(EmailSender mensagemSender) {
		this.mensagemSender = mensagemSender;
	}

	public void enviaEmail() {
		try {
			EmailUtils.enviaEmail(mensagemSender);
		} catch (EmailException ex) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erro! Occoreu um erro ao enviar a mensagem.", "Erro"));
			Logger.getLogger(EmailBean.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void limpaCampos() {
		mensagemSender = new EmailSender();

	}
	
	
	
}
