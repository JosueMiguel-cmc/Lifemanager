package VO;

public class NotasOBJ {
    private String Titulo;
    private String conteudo;
    private String id_nota;  // campo extra
    private String id_user;  // campo extra

    public NotasOBJ() {

    }

    public NotasOBJ(String titulo, String conteudo) {
        this.Titulo = titulo;
        this.conteudo = conteudo;
    }

    // Getters e Setters
    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        this.Titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getId_nota() {
        return id_nota;
    }

    public void setId_nota(String id_nota) {
        this.id_nota = id_nota;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }
}
