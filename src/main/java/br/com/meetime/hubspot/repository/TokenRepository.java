package br.com.meetime.hubspot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.meetime.hubspot.model.Token;

public interface TokenRepository extends JpaRepository<Token, String> {
    
}
