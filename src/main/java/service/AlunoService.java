package service;

import dto.AlunoDto;
import entity.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AlunoRepository;
import valueObject.EmailAluno;
import valueObject.Nome;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<AlunoDto> listarAlunos() {
        return alunoRepository.findAll().stream()
                .map(aluno -> new AlunoDto(aluno.getNome(), aluno.getEmail()))
                .collect(Collectors.toList());
    }

    public void salvarAluno(AlunoDto alunoDto) {
        Aluno aluno = new Aluno();

        aluno.setNome(new Nome(alunoDto.getNome()));
        aluno.setEmail(new EmailAluno(alunoDto.getEmail()));

        alunoRepository.save(aluno);
    }

    public void deletarAluno(Long id) {
        alunoRepository.deleteById(id);
    }

    public void atualizarAluno(Long id, AlunoDto alunoDto) {
        Aluno aluno = alunoRepository.findById(id).orElseThrow();

        aluno.setNome(new Nome(alunoDto.getNome()));
        aluno.setEmail(new EmailAluno(alunoDto.getEmail()));

        alunoRepository.save(aluno);
    }
}
