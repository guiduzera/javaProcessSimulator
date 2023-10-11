package services;

import interfaces.IProcessoSeletivo;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo implements IProcessoSeletivo {

  private final String[] _candidatos = {"João", "Maria", "José", "Fernanda", "Pedro", "Felipe", "Carla", "Mariana", "Paulo", "Lucas"};

  public ProcessoSeletivo() {
    System.out.println("Processo Seletivo Iniciado!");

    analisarCandidato(2000.00);
    selecaoCandidatos();
    imprimirCandidatos();
    entrandoEmContato("João");
    entrandoEmContato("Maria");
  }

  private static void entrandoEmContato(String candidato) {
    int tentativas = 1;
    boolean continuarTentando = true;
    boolean atendeu = false;

    do {
      System.out.println("Tentativa " + tentativas);
      atendeu = atender();
      continuarTentando = !atendeu;
      if (continuarTentando) {
        tentativas++;
      } else {
        System.out.println("Candidato atendeu a ligação!");
      }
    } while (tentativas <= 3 && continuarTentando);

    if (!atendeu) {
      System.out.println("O candidato: " + candidato + " não atendeu a ligação!");
    } else {
      System.out.println("O candidato: " + candidato + " atendeu a ligação! Na tentativa: " + tentativas);
    }
  }

  private static boolean atender() {
    return new Random().nextInt(3) == 1;
  }

  public void imprimirCandidatos() {
    for (String candidato : this._candidatos) {
      System.out.println("Candidato: " + candidato);
    }
  }

  public void selecaoCandidatos() {
    String[] candidatos = this._candidatos;
    int cadidatosAprovados = 0;
    int indice = 0;
    double salarioBase = 2000.00;

    while(cadidatosAprovados < 5 && indice < candidatos.length) {
      String candidato = candidatos[indice];
      double salarioPretendido = valorSalarioPretendido();

      System.out.println("Candidato: " + candidato + " | Salário Pretendido: " + salarioPretendido);

      if (salarioBase >= salarioPretendido) {
        System.out.println("Candidato " + candidato +  " foi aprovado para a vaga!");
        cadidatosAprovados++;
      }
      indice++;
    }
  }

  private static double valorSalarioPretendido() {
    return ThreadLocalRandom.current().nextDouble(1800.00, 2200.00);
  }

  public static void analisarCandidato(double salarioPretendido) {
    double salarioBase = 2000.00;
    if(salarioPretendido < salarioBase) {
      System.out.println("LIGAR PARA O CANDIDATO!");
    } else if (salarioPretendido == salarioBase) {
      System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA!");
    } else {
      System.out.println("AGUARDANDO O RESULTADO DOS OUTROS CANDIDATOS!");
    }
  }
}
