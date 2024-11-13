package entity;

import jakarta.persistence.*;
import valueObject.Descricao;
import valueObject.Nome;

@Entity
@Table(name = "tb_curso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Nome nome;

    @Embedded
    private Descricao descricao;

    public String getNome() {
        return nome.getnome();
    }

    public void setNome(Nome nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao.getdescricao();
    }

    public void setDescricao(Descricao descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
