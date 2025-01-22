package forumhub.controller;

import forumhub.model.Topico;
import forumhub.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @GetMapping
    public List<Topico> listarTopicos() {
        return topicoService.listarTopicos();
    }

    @PostMapping
    public Topico criarTopico(@RequestBody Topico topico) {
        return topicoService.criarTopico(topico);
    }

    @GetMapping("/{id}")
    public Topico buscarTopico(@PathVariable Long id) {
        return topicoService.buscarTopico(id);
    }

    @PutMapping("/{id}")
    public Topico atualizarTopico(@PathVariable Long id, @RequestBody Topico topico) {
        return topicoService.atualizarTopico(id, topico);
    }

    @DeleteMapping("/{id}")
    public void deletarTopico(@PathVariable Long id) {
        topicoService.deletarTopico(id);
    }
}
