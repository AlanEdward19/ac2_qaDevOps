package valueObject;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class Descricao {

    private String descricao;

    // Construtor padrão necessário para o JPA
    protected Descricao() {}

    public Descricao(String descricao) {
        this.descricao = descricao;
    }

    public String getdescricao() {
        return descricao;
    }

    // Sobrescreva equals e hashCode para garantir comparação por valor
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Descricao descricao = (Descricao) o;
        return Objects.equals(this.descricao, descricao.descricao);
    }
    @Override
    public int hashCode() {
        return Objects.hash(descricao);
    }
}
