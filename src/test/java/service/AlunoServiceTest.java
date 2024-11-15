package service;

import dto.AlunoDto;
import entity.Aluno;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.AlunoRepository;
import valueObject.EmailAluno;
import valueObject.Nome;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class AlunoServiceTest {

    @Mock
    private AlunoRepository alunoRepository;

    @InjectMocks
    private AlunoService alunoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listarAlunos_deveRetornarListaDeAlunoDto() {
        Aluno aluno1 = new Aluno();
        aluno1.setNome(new Nome("João"));
        aluno1.setEmail(new EmailAluno("joao@example.com"));

        Aluno aluno2 = new Aluno();
        aluno2.setNome(new Nome("Maria"));
        aluno2.setEmail(new EmailAluno("maria@example.com"));

        when(alunoRepository.findAll()).thenReturn(Arrays.asList(aluno1, aluno2));

        List<AlunoDto> alunosDto = alunoService.listarAlunos();

        assertEquals(2, alunosDto.size());
        assertEquals("João", alunosDto.get(0).getNome());
        assertEquals("joao@example.com", alunosDto.get(0).getEmail());
        verify(alunoRepository, times(1)).findAll();
    }

    @Test
    void salvarAluno_deveChamarSaveNoRepository() {
        AlunoDto alunoDto = new AlunoDto("Carlos", "carlos@example.com");

        alunoService.salvarAluno(alunoDto);

        verify(alunoRepository, times(1)).save(any(Aluno.class));
    }

    @Test
    void deletarAluno_deveChamarDeleteByIdNoRepository() {
        Long id = 1L;

        alunoService.deletarAluno(id);

        verify(alunoRepository, times(1)).deleteById(id);
    }

    @Test
    void atualizarAluno_deveAtualizarNomeEEmail() {
        Long id = 1L;
        Aluno alunoExistente = new Aluno();
        alunoExistente.setNome(new Nome("Antigo Nome"));
        alunoExistente.setEmail(new EmailAluno("antigo@example.com"));

        when(alunoRepository.findById(id)).thenReturn(Optional.of(alunoExistente));

        AlunoDto novoAlunoDto = new AlunoDto("Novo Nome", "novo@example.com");

        alunoService.atualizarAluno(id, novoAlunoDto);

        assertEquals("Novo Nome", alunoExistente.getNome());
        assertEquals("novo@example.com", alunoExistente.getEmail());
        verify(alunoRepository, times(1)).save(alunoExistente);
    }

    @Test
    void atualizarAluno_quandoIdNaoExistente_deveLancarExcecao() {
        Long idInvalido = 999L;
        AlunoDto alunoDto = new AlunoDto("Nome", "email@example.com");
        when(alunoRepository.findById(idInvalido)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> alunoService.atualizarAluno(idInvalido, alunoDto));

        verify(alunoRepository, times(1)).findById(idInvalido);
        verify(alunoRepository, never()).save(any(Aluno.class));
    }
}
