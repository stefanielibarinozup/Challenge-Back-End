package br.com.zup.challenge.integracao.model;

public class Data {
        private String id;
        private String field;

    public Data(String id, String field){
        this.id = id;
        this.field = field;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

}
