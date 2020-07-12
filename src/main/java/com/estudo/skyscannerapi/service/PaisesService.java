package com.estudo.skyscannerapi.service;

import com.estudo.skyscannerapi.configuracao.ConectaApiSkyscanner;
import com.estudo.skyscannerapi.entidades.Paises;
import com.estudo.skyscannerapi.repository.PaisesRepository;
import lombok.AllArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class PaisesService {

    private PaisesRepository paisesRepository;
    private ConectaApiSkyscanner conectaApiSkyscanner;

    public void carregarPaisesDaApi() {

        String jsonApi = conectaApiSkyscanner.buscarPaises();

        JSONObject objetoJson = new JSONObject(jsonApi);
        JSONArray arrayObjetoJson = objetoJson.getJSONArray("Countries");

        List<Paises> listaPaises = new ArrayList<>();
        for (int i = 0; i < arrayObjetoJson.length(); i++) {

            Paises pais = new Paises();
            pais.setSigla(arrayObjetoJson.getJSONObject(i).getString("Code"));
            pais.setNome(arrayObjetoJson.getJSONObject(i).getString("Name"));
            if (!verificarSePaisJaExiste(pais)) {
                listaPaises.add(pais);
                paisesRepository.save(pais);
            }
        }

    }

    private boolean verificarSePaisJaExiste(Paises pais) {
        boolean paisJaExiste = listarPaises().stream().map(Paises::getSigla).anyMatch(pais.getSigla()::equals);
        return paisJaExiste;
    }

    public List<Paises> listarPaises() {
        return paisesRepository.findAll();
    }

}
