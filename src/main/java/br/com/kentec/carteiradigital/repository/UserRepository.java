package br.com.kentec.carteiradigital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.kentec.carteiradigital.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
