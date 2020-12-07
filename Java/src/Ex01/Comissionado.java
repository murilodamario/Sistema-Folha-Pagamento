package Ex01;

import java.util.Date;

public class Comissionado extends Empregado{
    private double vendasMensal;
    private double percComissao;

    public Comissionado(String nome, String sobrenome, String cpf, Date dataNasc) {
        super(nome, sobrenome, cpf, dataNasc);
    }

    public Comissionado() {};

    @Override
    public String toString() {
        return ("\nEmpregado: Comissionado\n" +
                "Nome: " + getNome() + " " + getSobrenome() + "\n" +
                "CPF: " + getCpf() + "\n" +
                "Salario: R$" + ganhos() + "\n");
    }


    @Override
    public double ganhos() {
        return vendasMensal * percComissao / 100;
    }

    @Override
    public double getValorPagto() {
        return this.ganhos();
    }

    public double getVendasMensal() { return vendasMensal; }

    public void setVendasMensal(double vendasMensal) { this.vendasMensal = vendasMensal; }

    public double getPercComissao() { return percComissao; }

    public void setPercComissao(double percComissao) { this.percComissao = percComissao; }
}