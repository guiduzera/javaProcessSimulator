package services;

import interfaces.IProcessoSeletivo;

public class ProcessoSeletivo implements IProcessoSeletivo {
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
