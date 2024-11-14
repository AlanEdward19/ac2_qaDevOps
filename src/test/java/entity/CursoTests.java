package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import valueObject.Descricao;
import valueObject.Nome;

class CursoTests {

    private Curso curso;
    private Nome nomeValido;
    private Descricao descricaoValida;

    @BeforeEach
    void setUp() {
        nomeValido = new Nome("João da Silva");
        descricaoValida = new Descricao("Curso completo de Java para iniciantes");
        curso = new Curso();
    }

    @Test
    void SetId_DeveDefinirOIdDoCurso() {
        Long id = 1L;
        curso.setId(id);
        assertEquals(id, curso.getId(), "O ID do curso deve ser igual ao valor definido.");
    }

    @Test
    void GetId_DeveRetornarOIdDoCurso() {
        Long id = 1L;
        curso.setId(id);
        assertEquals(id, curso.getId(), "O ID do curso deve ser igual ao valor retornado pelo getter.");
    }

    @Test
    void SetNome_DeveDefinirONomeDoCurso() {
        curso.setNome(nomeValido);
        assertEquals(nomeValido.getnome(), curso.getNome(), "O nome do curso deve ser igual ao valor definido.");
    }

    @Test
    void GetNome_DeveRetornarONomeDoCurso() {
        curso.setNome(nomeValido);
        assertEquals(nomeValido.getnome(), curso.getNome(), "O nome do curso deve ser igual ao valor retornado pelo getter.");
    }

    @Test
    void SetDescricao_DeveDefinirADescricaoDoCurso() {
        curso.setDescricao(descricaoValida);
        assertEquals(descricaoValida.getdescricao(), curso.getDescricao(), "A descrição do curso deve ser igual ao valor definido.");
    }

    @Test
    void GetDescricao_DeveRetornarADescricaoDoCurso() {
        curso.setDescricao(descricaoValida);
        assertEquals(descricaoValida.getdescricao(), curso.getDescricao(), "A descrição do curso deve ser igual ao valor retornado pelo getter.");
    }
}
