package com.estudo.skyscannerapi.service;

import com.estudo.skyscannerapi.configuracao.ConectaApiSkyscanner;
import com.estudo.skyscannerapi.entidades.Local;
import com.estudo.skyscannerapi.repository.LocalizacoesRepository;
import lombok.AllArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class LocalizacoesService {

    private ConectaApiSkyscanner conectaApiSkyscanner;
    private LocalizacoesRepository localizacoesRepository;

    public void carregarLocalizacoesDaApi() {

        String jsonApi = conectaApiSkyscanner.buscarLocalizacoes();
        JSONObject objetoJson = new JSONObject(jsonApi);
        JSONArray arrayObjetoJson = objetoJson.getJSONArray("Places");

        List<Local> listaLocais = new ArrayList<>();
        for (int i = 0; i < arrayObjetoJson.length(); i++) {
            Local local = new Local();
            local.setCodigoCidade(arrayObjetoJson.getJSONObject(i).getString("CityId"));
            local.setCodigoLocal(arrayObjetoJson.getJSONObject(i).getString("PlaceId"));
            local.setCodigoPais(arrayObjetoJson.getJSONObject(i).getString("CountryId"));
            local.setNomeLocal(arrayObjetoJson.getJSONObject(i).getString("PlaceName"));
            local.setNomePais(arrayObjetoJson.getJSONObject(i).getString("CountryName"));
            local.setRegiao(arrayObjetoJson.getJSONObject(i).getString("RegionId"));

            if (!verificaSeLocalJaExiste(local)) {
                listaLocais.add(local);
                localizacoesRepository.save(local);
            }
        }
    }

    private boolean verificaSeLocalJaExiste(Local locais) {
        boolean localJaExiste = listarLocalizacoes().stream().map(Local::getCodigoLocal)
                .anyMatch(locais.getCodigoLocal()::equals);
        return localJaExiste;
    }

    public List<Local> listarLocalizacoes() {
        return localizacoesRepository.findAll();
    }
}
