package VO;

import java.util.Date;

public class NotasOBJ {
    private String idNote;
    private String NomeNote;
    private String Conteudo;
    private Date datadecriaçao;

    public NotasOBJ(String idNote, String nomeNote, String conteudo, Date datadecriaçao){
        this.idNote = idNote;
        this.NomeNote = nomeNote;
        this.Conteudo = conteudo;
        this.datadecriaçao = datadecriaçao;
    }

    public String getIdNote() {
        return idNote;
    }

    public void setIdNote(String idNote) {
        this.idNote = idNote;
    }

    public String getNomeNote() {
        return NomeNote;
    }

    public void setNomeNote(String nomeNote) {
        NomeNote = nomeNote;
    }

    public String getConteudo() {
        return Conteudo;
    }

    public void setConteudo(String conteudo) {
        Conteudo = conteudo;
    }

    public Date getDatadecriaçao() {
        return datadecriaçao;
    }

    public void setDatadecriaçao(Date datadecriaçao) {
        this.datadecriaçao = datadecriaçao;
    }
}
