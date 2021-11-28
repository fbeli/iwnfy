package com.becb.iwnfy.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.becb.iwnfy.model.Remetente;

@Repository
public interface RemetenteRepository extends JpaRepository<Remetente, Long> {
	

	Optional<Remetente> findByEmail(String email);
	
	List<Remetente> findTodasByNameContaining(String nome);

}
