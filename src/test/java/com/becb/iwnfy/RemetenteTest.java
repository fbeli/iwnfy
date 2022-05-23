package com.becb.iwnfy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.becb.iwnfy.DTO.RemetenteDTO;
import com.becb.iwnfy.pessoa.model.Remetente;
import com.becb.iwnfy.service.RemetenteService;


@SpringBootTest
public class RemetenteTest {

	
	@Autowired
	RemetenteService rs;
	
	
	
	@Test
	void testDtoToRemetente(){
		RemetenteDTO dto = new RemetenteDTO();
		String telNum = "966966966";
		dto.setTelefone(telNum);
		dto.setEmail("emailDTO@gmail.com");
		dto.setName("Frederico");
		dto.setUserInstagram("@fredbelisario");
		Remetente remetente = rs.translateRemetenteDTOToRemetente(dto);
		System.out.println(remetente.toString());
		Assert.isTrue(remetente.getTelefone().equals(telNum), "Número de telefone  tem que  ser igual");
	}
	
	
	@Test
	void testRemetenteToDTO(){
		Remetente rem = new Remetente();
		String telNum = "966966966";
		rem.setTelefone(telNum);
		rem.setEmail("emailDTO@gmail.com");
		rem.setName("Frederico");
		rem.setUserInstagram("@fredbelisario");
		RemetenteDTO remetente = rs.translateRemetenteToRemetenteDTO(rem);
		System.out.println(remetente.toString());
		Assert.isTrue(remetente.getTelefone().equals(telNum), "Número de telefone  tem que  ser igual");
	}

}
