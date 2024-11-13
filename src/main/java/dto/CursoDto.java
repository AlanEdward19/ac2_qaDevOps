package dto;

public class CursoDto {
    private String nome;
    private String descricao;

    public CursoDto(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
