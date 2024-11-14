package repository;

import com.example.ac2.ac2.Ac2Application;
import entity.Curso;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import valueObject.Descricao;
import valueObject.Nome;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ContextConfiguration(classes = Ac2Application.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ComponentScan(basePackages = {"repository", "entity", "valueObject"})
class CursoRepositoryJPATestIntegrationTests {

    @Autowired
    private CursoRepository cursoRepository;

    @Test
    void SaveCurso_DeveSalvarOCurso() {
        Curso curso = new Curso();
        curso.setNome(new Nome("Curso de Java"));
        curso.setDescricao(new Descricao("Curso completo de Java para iniciantes."));

        Curso savedCurso = cursoRepository.save(curso);

        assertNotNull(savedCurso.getId());
        assertEquals("Curso de Java", savedCurso.getNome());
        assertEquals("Curso completo de Java para iniciantes.", savedCurso.getDescricao());
    }

    @Test
    void FindById_DeveEncontrarOCursoPeloId() {
        Curso curso = new Curso();
        curso.setNome(new Nome("Curso de Spring Boot"));
        curso.setDescricao(new Descricao("Curso sobre Spring Boot e JPA."));

        Curso savedCurso = cursoRepository.save(curso);

        Optional<Curso> foundCurso = cursoRepository.findById(savedCurso.getId());

        assertTrue(foundCurso.isPresent());
        assertEquals("Curso de Spring Boot", foundCurso.get().getNome());
        assertEquals("Curso sobre Spring Boot e JPA.", foundCurso.get().getDescricao());
    }

    @Test
    void DeleteCurso_DeveDeletarOCursoPelo() {
        Curso curso = new Curso();
        curso.setNome(new Nome("Curso de Hibernate"));
        curso.setDescricao(new Descricao("Curso avançado de Hibernate."));

        Curso savedCurso = cursoRepository.save(curso);
        Long id = savedCurso.getId();

        cursoRepository.deleteById(id);

        Optional<Curso> foundCurso = cursoRepository.findById(id);
        assertFalse(foundCurso.isPresent());
    }
}

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Ac2Application.class) // Substitua "Application" pelo nome correto da sua classe principal
class CursoRepositorySpringBootTests {

    @Autowired
    private CursoRepository cursoRepository;

    @Test
    void SaveCurso_DeveSalvarOCurso() {
        Curso curso = new Curso();
        curso.setNome(new Nome("Curso de Java"));
        curso.setDescricao(new Descricao("Curso completo de Java para iniciantes."));

        Curso savedCurso = cursoRepository.save(curso);

        assertNotNull(savedCurso.getId());
        assertEquals("Curso de Java", savedCurso.getNome());
        assertEquals("Curso completo de Java para iniciantes.", savedCurso.getDescricao());
    }

    @Test
    void FindById_DeveEncontrarOCursoPeloId() {
        Curso curso = new Curso();
        curso.setNome(new Nome("Curso de Spring Boot"));
        curso.setDescricao(new Descricao("Curso sobre Spring Boot e JPA."));

        Curso savedCurso = cursoRepository.save(curso);

        Optional<Curso> foundCurso = cursoRepository.findById(savedCurso.getId());

        assertTrue(foundCurso.isPresent());
        assertEquals("Curso de Spring Boot", foundCurso.get().getNome());
        assertEquals("Curso sobre Spring Boot e JPA.", foundCurso.get().getDescricao());
    }

    @Test
    void DeleteCurso_DeveDeletarOCursoPelo() {
        Curso curso = new Curso();
        curso.setNome(new Nome("Curso de Hibernate"));
        curso.setDescricao(new Descricao("Curso avançado de Hibernate."));

        Curso savedCurso = cursoRepository.save(curso);
        Long id = savedCurso.getId();

        cursoRepository.deleteById(id);

        Optional<Curso> foundCurso = cursoRepository.findById(id);
        assertFalse(foundCurso.isPresent());
    }
}