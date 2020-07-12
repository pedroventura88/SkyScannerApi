package com.estudo.skyscannerapi.repository;

import com.estudo.skyscannerapi.entidades.Paises;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisesRepository extends JpaRepository<Paises, Long> {

}
