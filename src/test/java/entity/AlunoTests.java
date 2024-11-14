package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import valueObject.EmailAluno;
import valueObject.Nome;

class AlunoTests {

    private Aluno aluno;
    private Nome nomeValido;
    private EmailAluno emailValido;

    @BeforeEach
    void setUp() {
        nomeValido = new Nome("João Silva");
        emailValido = new EmailAluno("joao.silva@example.com");
        aluno = new Aluno();
    }

    @Test
    void SetId_DeveDefinirOIdDoAluno() {
        Long id = 1L;
        aluno.setId(id);
        assertEquals(id, aluno.getId(), "O ID do aluno deve ser igual ao valor definido.");
    }

    @Test
    void GetId_DeveRetornarOIdDoAluno() {
        Long id = 1L;
        aluno.setId(id);
        assertEquals(id, aluno.getId(), "O ID do aluno deve ser igual ao valor retornado pelo getter.");
    }

    @Test
    void SetNome_DeveDefinirONomeDoAluno() {
        aluno.setNome(nomeValido);
        assertEquals(nomeValido.getnome(), aluno.getNome(), "O nome do aluno deve ser igual ao valor definido.");
    }

    @Test
    void GetNome_DeveRetornarONomeDoAluno() {
        aluno.setNome(nomeValido);
        assertEquals(nomeValido.getnome(), aluno.getNome(), "O nome do aluno deve ser igual ao valor retornado pelo getter.");
    }

    @Test
    void SetEmail_DeveDefinirOEmailDoAluno() {
        aluno.setEmail(emailValido);
        assertEquals(emailValido.getEmailAddress(), aluno.getEmail(), "O email do aluno deve ser igual ao valor definido.");
    }

    @Test
    void GetEmail_DeveRetornarOEmailDoAluno() {
        aluno.setEmail(emailValido);
        assertEquals(emailValido.getEmailAddress(), aluno.getEmail(), "O email do aluno deve ser igual ao valor retornado pelo getter.");
    }
}
