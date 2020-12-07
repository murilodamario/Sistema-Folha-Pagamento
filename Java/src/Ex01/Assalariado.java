package Ex01;

import java.util.Date;

public class Assalariado extends Empregado{

    public Assalariado(String nome, String sobrenome, String cpf, Date dataNAsc) {
        super(nome, sobrenome, cpf, dataNAsc);
    }

    public Assalariado(){};
    private double salarioMensal;

    @Override
    public String toString() {
        return ("\nEmpregado: Assalariado\n" +
                "Nome: " + getNome() + " " + getSobrenome() + "\n" +
                "CPF: " + getCpf() + "\n" + "Salário mensal: R$" + this.salarioMensal + "\n");
    }

    @Override
    public double ganhos() {
        return this.salarioMensal;
    }

    @Override
    public double getValorPagto() {
        return this.ganhos();
    }

    public double getSalarioMensal() {
        return salarioMensal;
    }

    public void setSalarioMensal(double salarioMensal) {
        this.salarioMensal = salarioMensal;
    }

}
