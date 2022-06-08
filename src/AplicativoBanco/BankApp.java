package AplicativoBanco;

import java.util.Scanner;

public class BankApp {

  public static void main(String[] args) {

    ContaBancaria conta = new ContaBancaria("Hene Chen", "0001");
    conta.mostrarMenu();

  }

  // =============================================================

  static class ContaBancaria
  {
    String nomeCliente;

    String clienteId;

    int balanco;

    int transacaoAnterior;

    ContaBancaria(String nCliente, String cid)
    {
      nomeCliente = nCliente;
      clienteId = cid;
    }

    // =============================================================

    void deposito (int quantidade)
    {
      if (quantidade > 0)
      {
        balanco += quantidade;
        transacaoAnterior = quantidade;
      }
    }

    // =============================================================

    void saque(int quantidade)
    {
      if (quantidade > 0)
      {
        balanco -= quantidade;
        transacaoAnterior = -quantidade;
      }
    }

    // =============================================================

    void obterTransacaoAnterior()
    {
      if (transacaoAnterior > 0)
      {
        System.out.println("Depositado: " + transacaoAnterior);
      }
      else if (transacaoAnterior < 0)
      {
        System.out.println("Saque de: " + Math.abs(transacaoAnterior));
      }
      else
      {
        System.out.println("Nenhuma transação ocorrida.");
      }
    }

    // =============================================================

    void mostrarMenu()
    {
      char opcao = '\0';
      Scanner input = new Scanner(System.in);

      System.out.println("Bem-vindo(a) " + nomeCliente);
      System.out.println("Seu ID é: " + clienteId);
      System.out.println();
      System.out.println("1. Verificar saldo");
      System.out.println("2. Depósito");
      System.out.println("3. Saque");
      System.out.println("4. Transação anterior");
      System.out.println("5. Sair da conta.");

      do
      {
        System.out.println("===============");
        System.out.println("Selecione uma opção");
        System.out.println("===============");
        opcao = input.next().charAt(0);
        System.out.println();

        switch(opcao)
        {
          case '1':
            System.out.println("===============");
            System.out.println("Balanço: " + balanco);
            System.out.println("===============");
            System.out.println();
            break;

          case '2':
            System.out.println("===============");
            System.out.println("Informe a quantidade a ser depositada: ");
            System.out.println("===============");
            int valorDeposito = input.nextInt();
            deposito(valorDeposito);
            System.out.println();
            break;

          case '3':
            System.out.println("===============");
            System.out.println("Informe a quantidade a ser sacada: ");
            System.out.println("===============");
            int valorSaque = input.nextInt();
            saque(valorSaque);
            System.out.println();
            break;

          case '4':
            System.out.println("===============");
            obterTransacaoAnterior();
            System.out.println("===============");
            System.out.println();
            break;

          case '5':
            System.out.println("===============");
            break;

          default:
            System.out.println("Opção inválida, por favor informe uma opção válida para continuar.");
            break;
        }
      }
      while (opcao != '5');

      // =============================================================

      System.out.println("Obrigado por utilizar os serviços do nosso banco.");

      // =============================================================

      input.close();
    }
  }
}

