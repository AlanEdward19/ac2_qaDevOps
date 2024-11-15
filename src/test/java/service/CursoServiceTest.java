package service;

import dto.CursoDto;
import entity.Curso;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.CursoRepository;
import valueObject.Descricao;
import valueObject.Nome;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class CursoServiceTest {

    @Mock
    private CursoRepository cursoRepository;

    @InjectMocks
    private CursoService cursoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listarCursos_deveRetornarListaDeCursoDto() {
        Curso curso1 = new Curso();
        curso1.setNome(new Nome("Matemática"));
        curso1.setDescricao(new Descricao("Curso básico de Matemática"));

        Curso curso2 = new Curso();
        curso2.setNome(new Nome("Física"));
        curso2.setDescricao(new Descricao("Curso avançado de Física"));

        when(cursoRepository.findAll()).thenReturn(Arrays.asList(curso1, curso2));

        List<CursoDto> cursosDto = cursoService.listarCursos();

        assertEquals(2, cursosDto.size());
        assertEquals("Matemática", cursosDto.get(0).getNome());
        assertEquals("Curso básico de Matemática", cursosDto.get(0).getDescricao());
        assertEquals("Física", cursosDto.get(1).getNome());
        assertEquals("Curso avançado de Física", cursosDto.get(1).getDescricao());
        verify(cursoRepository, times(1)).findAll();
    }

    @Test
    void salvarCurso_deveChamarSaveNoRepository() {
        CursoDto cursoDto = new CursoDto("Biologia", "Curso de introdução à Biologia");

        cursoService.salvarCurso(cursoDto);

        verify(cursoRepository, times(1)).save(any(Curso.class));
    }

    @Test
    void deletarCurso_deveChamarDeleteByIdNoRepository() {
        Long id = 1L;

        cursoService.deletarCurso(id);

        verify(cursoRepository, times(1)).deleteById(id);
    }

    @Test
    void atualizarCurso_deveAtualizarNomeEDescricao() {
        Long id = 1L;
        Curso cursoExistente = new Curso();
        cursoExistente.setNome(new Nome("Química"));
        cursoExistente.setDescricao(new Descricao("Curso inicial de Química"));

        when(cursoRepository.findById(id)).thenReturn(Optional.of(cursoExistente));

        CursoDto novoCursoDto = new CursoDto("Astronomia", "Curso introdutório de Astronomia");

        cursoService.atualizarCurso(id, novoCursoDto);

        assertEquals("Astronomia", cursoExistente.getNome());
        assertEquals("Curso introdutório de Astronomia", cursoExistente.getDescricao());
        verify(cursoRepository, times(1)).save(cursoExistente);
    }

    @Test
    void atualizarCurso_quandoIdNaoExistente_deveLancarExcecao() {
        Long idInvalido = 999L;
        CursoDto cursoDto = new CursoDto("Nome do Curso", "Descrição do Curso");
        when(cursoRepository.findById(idInvalido)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> cursoService.atualizarCurso(idInvalido, cursoDto));

        verify(cursoRepository, times(1)).findById(idInvalido);
        verify(cursoRepository, never()).save(any(Curso.class));
    }
}
