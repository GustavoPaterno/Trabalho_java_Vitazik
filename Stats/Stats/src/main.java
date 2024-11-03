import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ent, opcao;
        String resp;
        int nId = 1;

        ArrayList<Protocolo> protocolos = new ArrayList<>(); 

        do { 
            System.out.println("==== MENU ====");
            System.out.println("1 - Entrada Funcionario");
            System.out.println("2 - Entrada Cliente");
            System.out.println("0 - Sair");
            ent = sc.nextInt();
            sc.nextLine();

            if(ent == 1) {
                do {  
                    System.out.println("1 - Responder chamados");
                    System.out.println("0 - Sair");
                    System.out.print("Escolha uma opção: ");
                    opcao = sc.nextInt();
                    sc.nextLine();

                    switch(opcao) {
                        case 1: 
                        System.out.print("Digite o número do protocolo para responder: ");
                        int idProtocolo = sc.nextInt();
                        sc.nextLine();
                        Protocolo protocolo = buscarProtocolo(protocolos, idProtocolo);
                        if (protocolo != null) {
                            System.out.println("Protocolo ID: " + protocolo.getId());
                            System.out.println("Pedido: " + protocolo.getProblema());
                            System.out.println("Status: " + protocolo.getStatus());

                          
                            System.out.println("Digite a Resposta do Problema: ");
                            String resposta = sc.nextLine();
                            protocolo.setResposta(resposta);
                            protocolo.trocaStatus(2); 
                            System.out.println("Resposta registrada com sucesso.");
                        } else {
                            System.out.println("Protocolo não encontrado.");
                        }
                        break;
                        
                        case 0:
                            break;
                    }
                } while(opcao != 0);
            }

            if(ent == 2) {
                do {  
                    System.out.println("==== MENU ====");
                    System.out.println("1 - Fazer chamado");
                    System.out.println("2 - Consultar chamado");
                    System.out.println("0 - Sair");
                    System.out.print("Escolha uma opção: ");
                    opcao = sc.nextInt();
                    sc.nextLine();

                    switch(opcao) {
                        case 1: 
                            System.out.println("Digite o problema: ");
                            resp = sc.nextLine();
                            Protocolo novoProtocolo = new Protocolo(nId++, resp); 
                            protocolos.add(novoProtocolo); 
                            System.out.println("Seu numero de protocolo eh: " + (nId - 1));
                            System.out.println("Problema registrado: " + resp);
                            System.out.println("Pressione Enter para continuar...");
                            sc.nextLine();
                            break;


                        case 2:
                            System.out.print("Digite o número de protocolo: ");
                            int numProtocolo = sc.nextInt();
                            sc.nextLine();
                            Protocolo consultado = buscarProtocolo(protocolos, numProtocolo);
                            if (consultado != null) {
                                System.out.println("Protocolo ID: " + consultado.getId());
                                System.out.println("Problema: " + consultado.getProblema());
                                System.out.println("Resposta: " + consultado.getResposta());
                                System.out.println("Status: " + consultado.getStatus());
                                System.out.println("Pressione Enter para continuar...");
                                sc.nextLine();
                            } else {
                                System.out.println("Protocolo não encontrado.");
                            }
                            break;

                        case 0: 
                            break;
                    }
                } while(opcao != 0);
            }

            if(ent == 0) {
                break;
            }
        } while (ent != 0);

        sc.close(); 
    }

    private static Protocolo buscarProtocolo(ArrayList<Protocolo> protocolos, int id) {
        for (Protocolo protocolo : protocolos) {
            if (protocolo.getId() == id) {
                return protocolo;
            }
        }
        return null; 
    }
}
