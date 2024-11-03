class Protocolo {
    private int id;
    private String problema;
    private String resposta;
    private String status;

    Protocolo(int id, String problema) {
        this.id = id;
        this.problema = problema;
        this.status = "Aberto"; 
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public String getProblema() {
        return problema;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public String getResposta() {
        return resposta;
    }

    public String getStatus() {
        return status;
    }

    public void trocaStatus(int protocolo) {
        if(protocolo == 0) {
            this.status = "Aberto";
        } else if(protocolo == 1) {
            this.status = "Pendente";
        } else if(protocolo == 2) {
            this.status = "Fechado";
        }
    }
}