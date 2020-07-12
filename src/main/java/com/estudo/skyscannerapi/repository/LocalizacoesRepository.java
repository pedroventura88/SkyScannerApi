package com.estudo.skyscannerapi.repository;

import com.estudo.skyscannerapi.entidades.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalizacoesRepository extends JpaRepository<Local, Long> {

}
