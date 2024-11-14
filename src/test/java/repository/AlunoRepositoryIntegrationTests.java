package repository;

import com.example.ac2.ac2.Ac2Application;
import entity.Aluno;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import repository.AlunoRepository;
import valueObject.EmailAluno;
import valueObject.Nome;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Ac2Application.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

class AlunoRepositorySpringBootIntegrationTests {

    @Autowired
    private AlunoRepository alunoRepository;

    @Test
    void SaveAluno_DeveSalvarAluno() {
        Aluno aluno = new Aluno();
        aluno.setNome(new Nome("João Silva"));
        aluno.setEmail(new EmailAluno("joao.silva@example.com"));

        Aluno savedAluno = alunoRepository.save(aluno);

        assertNotNull(savedAluno.getId());
        assertEquals("João Silva", savedAluno.getNome());
        assertEquals("joao.silva@example.com", savedAluno.getEmail());
    }

    @Test
    void FindById_DeveEncontrarAlunoPeloId() {
        Aluno aluno = new Aluno();
        aluno.setNome(new Nome("Maria Oliveira"));
        aluno.setEmail(new EmailAluno("maria.oliveira@example.com"));

        Aluno savedAluno = alunoRepository.save(aluno);

        Optional<Aluno> foundAluno = alunoRepository.findById(savedAluno.getId());

        assertTrue(foundAluno.isPresent());
        assertEquals("Maria Oliveira", foundAluno.get().getNome());
        assertEquals("maria.oliveira@example.com", foundAluno.get().getEmail());
    }

    @Test
    void DeleteAluno_DeveDeletarAluno() {
        Aluno aluno = new Aluno();
        aluno.setNome(new Nome("Pedro Souza"));
        aluno.setEmail(new EmailAluno("pedro.souza@example.com"));

        Aluno savedAluno = alunoRepository.save(aluno);
        Long id = savedAluno.getId();

        alunoRepository.deleteById(id);

        Optional<Aluno> foundAluno = alunoRepository.findById(id);
        assertFalse(foundAluno.isPresent());
    }
}

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ContextConfiguration(classes = Ac2Application.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ComponentScan(basePackages = {"repository", "entity", "valueObject"})
class AlunoRepositoryJPATestIntegrationTests {

    @Autowired
    private AlunoRepository alunoRepository;

    @Test
    void SaveAluno_DeveSalvarAluno() {
        Aluno aluno = new Aluno();
        aluno.setNome(new Nome("João Silva"));
        aluno.setEmail(new EmailAluno("joao.silva@example.com"));

        Aluno savedAluno = alunoRepository.save(aluno);

        assertNotNull(savedAluno.getId());
        assertEquals("João Silva", savedAluno.getNome());
        assertEquals("joao.silva@example.com", savedAluno.getEmail());
    }

    @Test
    void FindById_DeveEncontrarAlunoPeloId() {
        Aluno aluno = new Aluno();
        aluno.setNome(new Nome("Maria Oliveira"));
        aluno.setEmail(new EmailAluno("maria.oliveira@example.com"));

        Aluno savedAluno = alunoRepository.save(aluno);

        Optional<Aluno> foundAluno = alunoRepository.findById(savedAluno.getId());

        assertTrue(foundAluno.isPresent());
        assertEquals("Maria Oliveira", foundAluno.get().getNome());
        assertEquals("maria.oliveira@example.com", foundAluno.get().getEmail());
    }

    @Test
    void DeleteAluno_DeveDeletarAluno() {
        Aluno aluno = new Aluno();
        aluno.setNome(new Nome("Pedro Souza"));
        aluno.setEmail(new EmailAluno("pedro.souza@example.com"));

        Aluno savedAluno = alunoRepository.save(aluno);
        Long id = savedAluno.getId();

        alunoRepository.deleteById(id);

        Optional<Aluno> foundAluno = alunoRepository.findById(id);
        assertFalse(foundAluno.isPresent());
    }
}
