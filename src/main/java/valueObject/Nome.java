package valueObject;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class Nome {

    private String nome;

    // Construtor padrão necessário para o JPA
    protected Nome() {}

    public Nome(String nome) {
        this.nome = nome;
    }

    public String getnome() {
        return nome;
    }

    // Sobrescreva equals e hashCode para garantir comparação por valor
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nome nome = (Nome) o;
        return Objects.equals(this.nome, nome.nome);
    }
    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
