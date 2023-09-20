package transferencia;

public class Cliente {
    private String nome;
    private String cpf;
    private String rg;
    private Conta proprietario;

    public Cliente(String nome, String cpf, String rg) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
    }
}
