package com.flyhigh.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.flyhigh.model.BookingDetails;

@Service
public class KafkaBookingListener {
	
	@KafkaListener(topics = "booking_details", groupId="group_id", containerFactory = "userKafkaListenerFactory")
	public void consumeJson(BookingDetails book) {
	    System.out.println("The booking is confirmed for the PNR " + book.getPnr());

	     
		/*
		 * String host = "localhost"; Properties properties = System.getProperties();
		 * properties.setProperty("mail.smtp.host", host); Session session =
		 * Session.getDefaultInstance(properties); try { MimeMessage message = new
		 * MimeMessage(session); message.setFrom(new
		 * InternetAddress(book.getEmailId()));
		 * message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		 * message.setSubject("The booking is confirmed for the pnr "+book.getPnr());
		 * Transport.send(message); System.out.println("Sent message successfully....");
		 * } catch (MessagingException mex) { mex.printStackTrace(); }
		 */
	}

}
