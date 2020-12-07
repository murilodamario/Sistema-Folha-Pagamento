package Ex01;

/****************************************
<<<<<<< HEAD
 * Grupo                                 *
 * Nome: Murilo Gomes da Costa Damario   *
 * Nome: Giovanni Rafael Mota            *
 * **************************************/
=======
* Grupo                                 *
* Nome: Murilo Gomes da Costa Damario   *
* Nome: Giovanni Rafael Mota            *
* **************************************/
>>>>>>> 911ecf585fe90d6452f15d74d8384e775448d150

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

public class Menu {

    private static double salarioMensal = 2500;
    private static double valorHora = 17.5;
    private static double percComissao = 15;
    private static double percBaseComissao = 10;

    private static int FUNCIONARIOS = 4; //Com 4 podemos testar cada tipo de empregado
    private static int MESES = 12;
    private static int FATURAS = 3;

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);

        Empregado[][] folhaDePagamento = new Empregado[MESES][FUNCIONARIOS];
        Fatura[][] faturas = new Fatura[MESES][FATURAS];
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        for (int mes = 0; mes < MESES; mes++) {

            Date dataDeNascimento = formato.parse("1/1/1970");
            folhaDePagamento[mes][0] = new Assalariado("Tony", "Stark", "345.453.233-11",dataDeNascimento);
            ((Assalariado)folhaDePagamento[mes][0]).setSalarioMensal(salarioMensal);

            dataDeNascimento = formato.parse("2/2/1918");
            folhaDePagamento[mes][1] = new Horista("Steve", "Rogers", "¨542.654.783-10",dataDeNascimento);
            ((Horista)folhaDePagamento[mes][1]).setValorHora(valorHora);
            System.out.println("----------Horista----------");
            System.out.print("Número de horas trabalhadas do funcionário " + folhaDePagamento[mes][1].getNome() + " no mês de " + mesAtual(mes) + ": ");
            ((Horista)folhaDePagamento[mes][1]).setHorasTrab(sc.nextDouble());
            clearBuffer(sc);
            System.out.println();

            dataDeNascimento = formato.parse("3/3/1969");
            folhaDePagamento[mes][2] = new Comissionado("Bruce", "Benner", "541.433.786-59",dataDeNascimento);
            ((Comissionado)folhaDePagamento[mes][2]).setPercComissao(percComissao);
            System.out.println("\n----------Comissionado----------");
            System.out.print("Valor das vendas do funcionário " + folhaDePagamento[mes][2].getNome() + " no mês de " + mesAtual(mes) + ": ");
            ((Comissionado)folhaDePagamento[mes][2]).setVendasMensal(sc.nextDouble());
            clearBuffer(sc);
            System.out.println();


            dataDeNascimento = formato.parse("4/4/1984");
            folhaDePagamento[mes][3] = new BaseComissionado("Natasha", "Romanoff", "343.654.122.89", dataDeNascimento);
            ((BaseComissionado)folhaDePagamento[mes][3]).setSalarioBase(salarioMensal);
            ((BaseComissionado)folhaDePagamento[mes][3]).setPercComissao(percBaseComissao);
            System.out.println("\n-----------Base Comissionado----------");
            System.out.print("Valor das vendas do funcionário " + folhaDePagamento[mes][3].getNome() + " no mês de " + mesAtual(mes) + ": ");
            ((BaseComissionado)folhaDePagamento[mes][3]).setVendasMensal(sc.nextDouble());
            clearBuffer(sc);
            System.out.println();

            System.out.print("\nNúmero de faturas que serão adicionadas no mês de " + mesAtual(mes) + " (máximo: " + FATURAS + "): ");
            int numero_faturas  = sc.nextInt();
            clearBuffer(sc);

            for(int idFatura = 0; idFatura < numero_faturas; idFatura++) {
                faturas[mes][idFatura] = new Fatura();
                System.out.print("\n*********** Preechimento de informações da fatura ************\n");
                System.out.println("Mês - " + mesAtual(mes));
                System.out.println("ID Fatura - #F0" + (idFatura+1));
                System.out.print("Descrição: ");
                faturas[mes][idFatura].setDescricao(sc.nextLine());
                System.out.print("Número da fatura: ");
                faturas[mes][idFatura].setNumero(sc.nextLine());
                System.out.print("Quantidade: ");
                faturas[mes][idFatura].setQuantidade(sc.nextInt());
                clearBuffer(sc);
                System.out.print("Preço: ");
                faturas[mes][idFatura].setPreco(sc.nextDouble());
                clearBuffer(sc);
                System.out.println();
            }
        }
        sc.close();

        exibirFolhaDePagamento(folhaDePagamento, faturas);

    }

    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }

    public static String mesAtual(int mes){

        if(mes == 0){
            return "Janeiro";
        }else if(mes == 1){
            return "Fevereiro";
        }else if(mes == 2){
            return "Março";
        }else if(mes == 3){
            return "Abril";
        }else if(mes == 4){
            return "Maio";
        }else if(mes == 5){
            return "Junho";
        }else if(mes == 6){
            return "Julho";
        }else if(mes == 7){
            return "Agosto";
        }else if(mes == 8){
            return "Setembro";
        }else if(mes == 9){
            return "Outubro";
        }else if(mes == 10){
            return "Novembro";
        }else{
            return "Dezembro";
        }
    }

    public static void exibirFolhaDePagamento(Empregado[][] folhaDePagamento, Fatura[][] faturas){

        for(int mes = 0; mes < MESES; mes++){
            System.out.println("\n********** " + mesAtual(mes) + " **********");
            for(int funionario = 0; funionario < folhaDePagamento[mes].length; funionario++){

                //Converte Date em LocalDate, assim pegando os meses e transformando em números
                LocalDate localDate = folhaDePagamento[mes][funionario].getDataNasc().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                if(localDate.getMonth().getValue() == (mes+1)) {
                    System.out.print(folhaDePagamento[mes][funionario].toString());
                    System.out.println("Pagamento extra pelo mês de aniversário: R$200");
                }else{
                    System.out.println(folhaDePagamento[mes][funionario].toString());
                }
            }

            System.out.println("*************** Informações das faturas do mês de " + mesAtual(mes) + " ***************");

            for(int idFatura = 0; idFatura < faturas[mes].length; idFatura++){
                if(faturas[mes][idFatura] != null) {
                    System.out.println("Número da fatura: " + faturas[mes][idFatura].getNumero());
                    System.out.println("Descrição: " + faturas[mes][idFatura].getDescricao());
                    System.out.println("Valor da fatura: " + faturas[mes][idFatura].getValorPagto());
                }
            }
        }
    }

}