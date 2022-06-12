package me.eisp.first.common.edm.service;

import lombok.AllArgsConstructor;
import me.eisp.first.common.edm.dto.Edm1;
import me.eisp.first.common.edm.dto.Edm1Info;
import me.eisp.first.common.edm.repository.EdmRepository;
import org.apache.ibatis.annotations.Param;
import org.apache.logging.log4j.message.SimpleMessage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;

@Service
@AllArgsConstructor
public class EdmService {

    EdmRepository edmRepository;
    JavaMailSender javaMailSender;

    public String sendEdm1(@Param("edm1") Edm1 edm1) {

        File html = new File(getClass().getClassLoader().getResource("edm/edm1.html").getFile());

        Edm1Info edm1Info = edmRepository.getEdm1Info(edm1.getText());

        Document doc;
        try {
            doc = Jsoup.parse(html, "UTF-8");
            doc.getElementById("name").text(edm1Info.getName());
            doc.getElementById("phone").text(edm1Info.getEmpId());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setTo(edm1.getTo());
            helper.setSubject(edm1.getSubject());
            helper.setText(doc.toString());
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

        javaMailSender.send(message);

        return doc.toString();
    }

}
