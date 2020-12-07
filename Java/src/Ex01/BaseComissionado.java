package Ex01;

import java.util.Date;

public class BaseComissionado extends Comissionado{
    private double  salarioBase;

    public BaseComissionado(String nome, String sobrenome, String cpf, Date dataNasc) {
        super(nome, sobrenome, cpf, dataNasc);
    }

    public BaseComissionado() {};

    @Override
    public String toString() {
        return ("\nEmpregado: Assalariado Comissionado\n" +
                "Nome: " + getNome() + " " + getSobrenome() + "\n" +
                "CPF: " + getCpf() + "\n" +
                "Salário: R$" + ganhos() + "\n");
    }

    @Override
    public double ganhos() {
        return (salarioBase + (getVendasMensal() * getPercComissao())/100);
    }

    @Override
    public double getValorPagto() {
        return this.salarioBase;
    }

    public double getSalarioBase() { return salarioBase; }

    public void setSalarioBase(double salarioBase) { this.salarioBase = salarioBase; }
}
