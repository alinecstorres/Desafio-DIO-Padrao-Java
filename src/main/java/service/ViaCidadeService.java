package service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import model.Clima;
@FeignClient(name = "hhbrasil", url = "https://api.hgbrasil.com/weather")
public interface ViaCidadeService {

    @GetMapping("/{city}/json/")
    Clima consultarCidade(@PathVariable("city") String city);
}
