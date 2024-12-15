package paisContinente;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao sistema de Continentes e Países!");

        System.out.print("Digite o nome do continente: ");
        String nomeContinente = scanner.nextLine();
        Continente continente = new Continente(nomeContinente);

        System.out.print("Quantos países deseja adicionar ao continente? ");
        int qtdPaises = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < qtdPaises; i++) {
            System.out.println("Adicionando o país " + (i + 1) + ":");

            System.out.print("Código ISO do país: ");
            String codigoISO = scanner.nextLine();

            System.out.print("Nome do país: ");
            String nome = scanner.nextLine();

            System.out.print("Dimensão do país (em km²): ");
            double dimensao = scanner.nextDouble();

            System.out.print("População do país: ");
            double populacao = scanner.nextDouble();
            scanner.nextLine();

            Pais pais = new Pais(codigoISO, nome, dimensao);
            pais.setPopulacao(populacao);

            continente.adicionarPais(pais);
        }

        System.out.println("Agora vamos adicionar as fronteiras entre os países.");
        for (Pais pais : continente.getPaises()) {
            System.out.println("Adicionando fronteiras para o país: " + pais.getNome());

            for (Pais outroPais : continente.getPaises()) {
                if (!pais.equals(outroPais)) {
                    System.out.print("O país " + outroPais.getNome() + " é limítrofe de " + pais.getNome() + "? (s/n): ");
                    String resposta = scanner.nextLine();

                    if (resposta.equalsIgnoreCase("s")) {
                        pais.adicionarFronteira(outroPais);
                    }
                }
            }
        }

        System.out.println("\nResumo do continente " + nomeContinente + ":");
        System.out.println("Dimensão total: " + continente.getDimensaoTotal() + " km²");
        System.out.println("População total: " + continente.getPopulacaoTotal() + " habitantes");
        System.out.println("Densidade populacional: " + continente.getDensidadePopulacional() + " hab/km²");

        Pais maiorPopulacao = continente.getPaisMaiorPopulacao();
        Pais menorPopulacao = continente.getPaisMenorPopulacao();
        Pais maiorDimensao = continente.getPaisMaiorDimensao();
        Pais menorDimensao = continente.getPaisMenorDimensao();

        System.out.println("País com maior população: " + maiorPopulacao.getNome() + " (" + maiorPopulacao.getPopulacao() + " habitantes)");
        System.out.println("País com menor população: " + menorPopulacao.getNome() + " (" + menorPopulacao.getPopulacao() + " habitantes)");
        System.out.println("País com maior dimensão: " + maiorDimensao.getNome() + " (" + maiorDimensao.getDimensao() + " km²)");
        System.out.println("País com menor dimensão: " + menorDimensao.getNome() + " (" + menorDimensao.getDimensao() + " km²)");
        System.out.println("Razão territorial do maior país para o menor: " + continente.getRazaoTerritorial());

        System.out.print("\nDeseja verificar os vizinhos comuns entre dois países? (s/n): ");
        String verificarVizinhos = scanner.nextLine();

        if (verificarVizinhos.equalsIgnoreCase("s")) {
            System.out.print("Digite o código ISO do primeiro país: ");
            String isoPais1 = scanner.nextLine();

            System.out.print("Digite o código ISO do segundo país: ");
            String isoPais2 = scanner.nextLine();

            Pais pais1 = null, pais2 = null;

            for (Pais pais : continente.getPaises()) {
                if (pais.getCodigoISO().equalsIgnoreCase(isoPais1)) {
                    pais1 = pais;
                } else if (pais.getCodigoISO().equalsIgnoreCase(isoPais2)) {
                    pais2 = pais;
                }
            }

            if (pais1 != null && pais2 != null) {
                System.out.println("Vizinhos comuns entre " + pais1.getNome() + " e " + pais2.getNome() + ":");
                for (Pais vizinho : pais1.getVizinhosComuns(pais2)) {
                    System.out.println("- " + vizinho.getNome());
                }
            } else {
                System.out.println("Um ou ambos os países não foram encontrados.");
            }
        }

        scanner.close();
        System.out.println("Obrigado por usar o sistema!");
    }
}
