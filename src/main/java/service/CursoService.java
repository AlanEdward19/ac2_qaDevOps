package service;

import dto.CursoDto;
import entity.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CursoRepository;
import valueObject.Descricao;
import valueObject.Nome;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<CursoDto> listarCursos() {
        return cursoRepository.findAll().stream()
                .map(curso -> new CursoDto(curso.getNome(), curso.getDescricao()))
                .collect(Collectors.toList());
    }

    public void salvarCurso(CursoDto cursoDto) {
        Curso curso = new Curso();

        curso.setNome(new Nome(cursoDto.getNome()));
        curso.setDescricao(new Descricao(cursoDto.getDescricao()));

        cursoRepository.save(curso);
    }

    public void deletarCurso(Long id) {
        cursoRepository.deleteById(id);
    }

    public void atualizarCurso(Long id, CursoDto cursoDto) {
        Curso curso = cursoRepository.findById(id).orElseThrow();

        curso.setNome(new Nome(cursoDto.getNome()));
        curso.setDescricao(new Descricao(cursoDto.getDescricao()));

        cursoRepository.save(curso);
    }
}
