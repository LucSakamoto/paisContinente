package paisContinente;

import java.util.ArrayList;
import java.util.List;

class Continente {

    private String nome;
    private List<Pais> paises;

    public Continente(String nome) {
        this.nome = nome;
        this.paises = new ArrayList<>();
    }

    public void adicionarPais(Pais pais) {
        if (!paises.contains(pais)) {
            paises.add(pais);
        }
    }

    public double getDimensaoTotal() {
        double total = 0;
        for (Pais pais : paises) {
            total += pais.getDimensao();
        }
        return total;
    }

    public double getPopulacaoTotal() {
        double total = 0;
        for (Pais pais : paises) {
            total += pais.getPopulacao();
        }
        return total;
    }

    public double getDensidadePopulacional() {
        return getPopulacaoTotal() / getDimensaoTotal();
    }

    public Pais getPaisMaiorPopulacao() {
        Pais maior = null;
        for (Pais pais : paises) {
            if (maior == null || pais.getPopulacao() > maior.getPopulacao()) {
                maior = pais;
            }
        }
        return maior;
    }

    public Pais getPaisMenorPopulacao() {
        Pais menor = null;
        for (Pais pais : paises) {
            if (menor == null || pais.getPopulacao() < menor.getPopulacao()) {
                menor = pais;
            }
        }
        return menor;
    }

    public Pais getPaisMaiorDimensao() {
        Pais maior = null;
        for (Pais pais : paises) {
            if (maior == null || pais.getDimensao() > maior.getDimensao()) {
                maior = pais;
            }
        }
        return maior;
    }

    public Pais getPaisMenorDimensao() {
        Pais menor = null;
        for (Pais pais : paises) {
            if (menor == null || pais.getDimensao() < menor.getDimensao()) {
                menor = pais;
            }
        }
        return menor;
    }

    public double getRazaoTerritorial() {
        Pais maior = getPaisMaiorDimensao();
        Pais menor = getPaisMenorDimensao();
        if (maior != null && menor != null) {
            return maior.getDimensao() / menor.getDimensao();
        }
        return 0;
    }

    public List<Pais> getPaises() {
        return paises;
    }
}
