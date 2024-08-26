package VO;

public class NotasOBJ {
    private String title;
    private String content;

    public NotasOBJ() {
        // Construtor vazio necessário para o Firebase
    }

    public NotasOBJ(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
