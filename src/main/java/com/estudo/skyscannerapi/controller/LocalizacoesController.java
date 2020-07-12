package com.estudo.skyscannerapi.controller;

import com.estudo.skyscannerapi.entidades.Local;
import com.estudo.skyscannerapi.service.LocalizacoesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("skyscanner/api/localizacoes")
public class LocalizacoesController {

    private LocalizacoesService localizacoesService;

    @GetMapping(value = "carregarLocalizacoes")
    public void carregarLocalizacoes() {
        localizacoesService.carregarLocalizacoesDaApi();
    }

    @GetMapping(value = "listarLocalizacoes")
    public List<Local> listarLocalizacoes() {
        return localizacoesService.listarLocalizacoes();
    }

}
