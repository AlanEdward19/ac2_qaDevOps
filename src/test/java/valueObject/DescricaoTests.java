package valueObject;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DescricaoTests {

    @Test
    public void GetDescricao_DeveRetornarADescricao() {
        Descricao descricao = new Descricao("Teste de descrição");
        assertEquals("Teste de descrição", descricao.getdescricao());
    }

    @Test
    public void GetDescricao_DeveRetornarADescricaoSemValor() {
        Descricao descricao = new Descricao();
        assertEquals(null, descricao.getdescricao());
    }

    @Test
    public void Equals_DeveRetornarTrueParaOMesmoObjeto() {
        Descricao descricao1 = new Descricao("Teste de descrição");
        assertTrue(descricao1.equals(descricao1));
    }

    @Test
    public void Equals_testEquals_DeveRetornarTrueQuandoObjetosDiferentesPossuiremOMesmoValor() {
        Descricao descricao1 = new Descricao("Teste de descrição");
        Descricao descricao2 = new Descricao("Teste de descrição");
        assertTrue(descricao1.equals(descricao2));
    }

    @Test
    public void Equals_DeveRetornarFalseQuandoDoisObjetosPossuiremValoresDiferentes() {
        Descricao descricao1 = new Descricao("Teste de descrição 1");
        Descricao descricao2 = new Descricao("Teste de descrição 2");
        assertFalse(descricao1.equals(descricao2));
    }

    @Test
    public void Equals_DeveRetornarFalseQuandoObjetoForDiferente() {
        Descricao descricao1 = new Descricao("Teste de descrição 1");
        String descricao2 = "Teste de descrição 2";
        assertFalse(descricao1.equals(descricao2));
    }

    @Test
    public void Equals_DeveRetornarFalseSegunboObjetoForNulo() {
        Descricao descricao1 = new Descricao("Teste de descrição 1");
        Descricao descricao2 = null;
        assertFalse(descricao1.equals(descricao2));
    }


    @Test
    public void Equals_DeveRetornarFalseQuandoObjetoForNulo() {
        Descricao descricao1 = new Descricao("Teste de descrição");
        assertFalse(descricao1.equals(null));
    }

    @Test
    public void HashCode_DeveRetornarValorDoHashQuandoObjetoPossuirValorDefinido() {
        Descricao descricao = new Descricao("Teste de descrição");
        assertNotNull(descricao.hashCode());
    }
}
