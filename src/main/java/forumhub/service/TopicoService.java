package forumhub.service;

import forumhub.model.Topico;
import forumhub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    public List<Topico> listarTopicos() {
        return topicoRepository.findAll();
    }

    public Topico criarTopico(Topico topico) {
        return topicoRepository.save(topico);
    }

    public Topico buscarTopico(Long id) {
        Optional<Topico> topico = topicoRepository.findById(id);
        return topico.orElseThrow(() -> new RuntimeException("Tópico não encontrado"));
    }

    public Topico atualizarTopico(Long id, Topico topico) {
        if (!topicoRepository.existsById(id)) {
            throw new RuntimeException("Tópico não encontrado");
        }
        topico.setId(id);
        return topicoRepository.save(topico);
    }

    public void deletarTopico(Long id) {
        if (!topicoRepository.existsById(id)) {
            throw new RuntimeException("Tópico não encontrado");
        }
        topicoRepository.deleteById(id);
    }
}
