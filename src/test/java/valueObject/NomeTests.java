package valueObject;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NomeTests {

    @Test
    public void Construtor_Valido() {
        Nome nome = new Nome("Teste de nome");
        assertEquals("Teste de nome", nome.getnome());
    }

    @Test
    public void Construtor_ValidoComValorNulo() {
        Nome nome = new Nome();
        assertNull(nome.getnome());
    }

    @Test
    public void GetNome_DeveRetornarONome() {
        String expectedValue = "Teste de nome";
        Nome nome = new Nome(expectedValue);
        assertEquals(expectedValue, nome.getnome());
    }

    @Test
    public void Equals_DeveRetornarTrueQuandoObjetosforemIguais() {
        Nome nome = new Nome("Teste de nome");
        assertTrue(nome.equals(nome));
    }

    @Test
    public void Equals_DeveRetornarTrueQuandoObjetosDiferentesPossuiremOMesmoValor() {
        Nome nome1 = new Nome("Teste de nome");
        Nome nome2 = new Nome("Teste de nome");
        assertTrue(nome1.equals(nome2));
    }

    @Test
    public void Equals_DeveRetornarFalseQuandoObjetosDiferentesDevemPossuiremValoresDiferentes() {
        Nome nome1 = new Nome("Teste de nome 1");
        Nome nome2 = new Nome("Teste de nome 2");
        assertFalse(nome1.equals(nome2));
    }

    @Test
    public void Equals_DeveRetornarFalseQuandoObjetoForNulo() {
        Nome nome = new Nome("Teste de nome");
        assertFalse(nome.equals(null));
    }

    @Test
    public void Equals_DeveRetornarFalseQuandoObjetosNaoForemDoMesmoTipo() {
        Nome nome = new Nome("Teste de nome");
        String stringNome = "nome";
        assertFalse(nome.equals(stringNome));
    }

    @Test
    public void HashCode_DeveRetornarHash() {
        Nome nome = new Nome("Teste de nome");
        assertNotNull(nome.hashCode());
    }
}
