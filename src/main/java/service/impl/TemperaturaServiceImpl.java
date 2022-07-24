package service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Temperatura;
import model.TemperaturaRepository;
import model.Clima;
import model.ClimaRepository;
import service.TemperaturaService;
import service.ViaCidadeService;

@Service
public class TemperaturaServiceImpl implements TemperaturaService {

    @Autowired
    private TemperaturaRepository temperaturaRepository;
    @Autowired
    private ClimaRepository climaRepository;
    @Autowired
    private ViaCidadeService viaCidadeService;

    @Override
    public Iterable<Temperatura> buscarTodos() {
        return temperaturaRepository.findAll();
    }

    @Override
    public Temperatura buscarPorId(String id) {
        Optional<Temperatura> temperatura = temperaturaRepository.findById(id);
        return temperatura.get();
    }

    @Override
    public void inserir(Temperatura temperatura) {
        salvarTemperaturaComCidade(temperatura);
    }

    @Override
    public void atualizar(String id, Temperatura temperatura) {
        Optional<Temperatura> temperaturaBd = temperaturaRepository.findById(id);
        if (temperaturaBd.isPresent()) {
            salvarTemperaturaComCidade(temperatura);
        }
    }

    @Override
    public void deletar(String id) {
        temperaturaRepository.deleteById(id);
    }

    private void salvarTemperaturaComCidade(Temperatura temperatura) {
        // Verificar se o Clima do Temperatura já existe (pela Cidade).
        String cep = temperatura.getDescription().getCity();
        Clima clima = climaRepository.findById(cep).orElseGet(() -> {
            // Caso não exista, integrar com o ViaCidade e persistir o retorno.
            Clima novoClima = viaCidadeService.consultarCidade(cep);
            climaRepository.save(novoClima);
            return novoClima;
        });
        temperatura.setDescription(clima);
        // Inserir Temperatura, vinculando o Clima (novo ou existente).
        temperaturaRepository.save(temperatura);
    }

}
