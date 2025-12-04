public class Professor {

    private int id, numero;
    private String nome, email, rua, bairro, cidade, estado_civil;
    private String estado;
    private String senha;
    private double salario;

    public Professor(
        String nome,
        String rua,
        String bairro,
        String cidade,
        String estado_civil,
        String estado,
        double salario,
        String email,
        int numero
    ) {
        this.nome = nome;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado_civil = estado_civil;
        this.estado = estado;
        this.salario = salario;
        this.email = email;
        this.numero = numero;
    }

    public Professor(
        int id,
        String nome,
        String rua,
        String bairro,
        String cidade,
        String estado_civil,
        String estado,
        double salario,
        String email,
        int numero
    ) {
        this.id = id;
        this.nome = nome;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado_civil = estado_civil;
        this.estado = estado;
        this.salario = salario;
        this.email = email;
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public String getRua() {
        return rua;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstadoCivil() {
        return estado_civil;
    }

    public String getEstado() {
        return estado;
    }

    public double getSalario() {
        return salario;
    }

    public String getSenha() {
        return senha;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstadoCivil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
