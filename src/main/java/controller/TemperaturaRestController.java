package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Temperatura;
import service.TemperaturaService;

@RestController
@RequestMapping("temperatura")
public class TemperaturaRestController {

    @Autowired
    private TemperaturaService temperaturaService;

    @GetMapping
    public ResponseEntity<Iterable<Temperatura>> buscarTodos() {
        return ResponseEntity.ok(temperaturaService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Temperatura> buscarPorId(@PathVariable String id) {
        return ResponseEntity.ok(temperaturaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Temperatura> inserir(@RequestBody Temperatura temperatura) {
        temperaturaService.inserir(temperatura);
        return ResponseEntity.ok(temperatura);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Temperatura> atualizar(@PathVariable String id, @RequestBody Temperatura temperatura) {
        temperaturaService.atualizar(id, temperatura);
        return ResponseEntity.ok(temperatura);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        temperaturaService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
