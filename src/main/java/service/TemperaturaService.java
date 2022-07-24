package service;

import model.Temperatura;

public interface TemperaturaService {

    Iterable<Temperatura> buscarTodos();

    Temperatura buscarPorId(String id);

    void inserir(Temperatura temperatura);

    void atualizar(String id, Temperatura temperatura);

    void deletar(String id);
}
