package valueObject;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmailAlunoTests {

    @Test
    public void Construtor_Valido() {
        String email = "teste@exemplo.com";
        EmailAluno emailAluno = new EmailAluno(email);
        assertEquals(email, emailAluno.getEmailAddress());
    }

    @Test
    public void Construtor_SemValorValido() {
        EmailAluno emailAluno = new EmailAluno();
        assertNull(emailAluno.getEmailAddress());
    }

    @Test
    public void Construtor_DeveRetornarIllegalArgumentExceptionParaEmailInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new EmailAluno("email_invalido"));
        assertThrows(IllegalArgumentException.class, () -> new EmailAluno(null));
    }

    @Test
    public void GetEmailAddress_DeveRetornarEmail() {
        EmailAluno emailAluno = new EmailAluno("teste@exemplo.com");
        assertEquals("teste@exemplo.com", emailAluno.getEmailAddress());
    }

    @Test
    public void Equals_DeveRetornarTrueQuandoObjetosForemIguais() {
        EmailAluno emailAluno = new EmailAluno("teste@exemplo.com");
        assertTrue(emailAluno.equals(emailAluno));
    }

    @Test
    public void Equals_DeveRetornarTrueQuandoObjetosDiferentesPossuiremOMesmoValor() {
        EmailAluno email1 = new EmailAluno("teste@exemplo.com");
        EmailAluno email2 = new EmailAluno("teste@exemplo.com");
        assertTrue(email1.equals(email2));
    }

    @Test
    public void Equals_DeveRetornarFalseQuandoObjetosDiferentesDevemPossuiremValoresDiferentes() {
        EmailAluno email1 = new EmailAluno("teste1@exemplo.com");
        EmailAluno email2 = new EmailAluno("teste2@exemplo.com");
        assertFalse(email1.equals(email2));
    }

    @Test
    public void Equals_DeveRetornarFalseQuandoObjetoForNulo() {
        EmailAluno emailAluno = new EmailAluno("teste@exemplo.com");
        assertFalse(emailAluno.equals(null));
    }

    @Test
    public void Equals_DeveRetornarFalseQuandoObjetosNaoForemDoMesmoTipo() {
        EmailAluno emailAluno = new EmailAluno("teste@exemplo.com");
        String stringEmail = "teste@exemplo.com";
        assertFalse(emailAluno.equals(stringEmail));
    }

    @Test
    public void HashCode_DeveRetornarHash() {
        EmailAluno email = new EmailAluno("teste@exemplo.com");
        assertNotNull(email.hashCode());
    }
}
