package entity;

import jakarta.persistence.*;
import valueObject.EmailAluno;
import valueObject.Nome;

@Entity
@Table(name = "tb_aluno")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Nome nome;

    @Embedded
    private EmailAluno email;

    //Getters and Setters

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email.getEmailAddress();
    }

    public void setEmail(EmailAluno email) {
        this.email = email;
    }

    public String getNome() {
        return nome.getnome();
    }

    public void setNome(Nome nome) {
        this.nome = nome;
    }
}
