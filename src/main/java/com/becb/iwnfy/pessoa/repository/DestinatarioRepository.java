package com.becb.iwnfy.pessoa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.becb.iwnfy.pessoa.model.Destinatario;

@Repository
public interface DestinatarioRepository extends JpaRepository<Destinatario, Long> {
	

	Optional<Destinatario> findByEmail(String email);
	
	List<Destinatario> findTodasByNameContaining(String nome);

}
