package com.estudo.skyscannerapi.controller;

import com.estudo.skyscannerapi.entidades.Paises;
import com.estudo.skyscannerapi.service.PaisesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("skyscanner/api")
public class PaisesController {

    private PaisesService paisesService;

    @GetMapping(value = "carregarPaises")
    public void carregarPaisesDaApi(){
        paisesService.carregarPaisesDaApi();
    }

    @GetMapping(value = "listarPaises")
    public List<Paises> listarPaisesDaApi(){
        return paisesService.listarPaises();
    }

}
