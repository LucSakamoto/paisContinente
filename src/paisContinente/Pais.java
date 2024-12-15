package paisContinente;

import java.util.ArrayList;
import java.util.List;

public class Pais {

    private String codigoISO;
    private String nome;
    private double populacao;
    private double dimensao;
    private List<Pais> fronteiras;

    public Pais(String codigoISO, String nome, double dimensao) {
        this.codigoISO = codigoISO;
        this.nome = nome;
        this.dimensao = dimensao;
        this.fronteiras = new ArrayList<>();
    }

    public String getCodigoISO() {
        return codigoISO;
    }

    public void setCodigoISO(String codigoISO) {
        this.codigoISO = codigoISO;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPopulacao() {
        return populacao;
    }

    public void setPopulacao(double populacao) {
        this.populacao = populacao;
    }

    public double getDimensao() {
        return dimensao;
    }

    public void setDimensao(double dimensao) {
        this.dimensao = dimensao;
    }

    public List<Pais> getFronteiras() {
        return fronteiras;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pais outroPais = (Pais) obj;
        return this.codigoISO.equals(outroPais.codigoISO);
    }

    public boolean isLimitrofe(Pais outroPais) {
        return fronteiras.contains(outroPais);
    }

    public double getDensidadePopulacional() {
        return populacao / dimensao;
    }

    public List<Pais> getVizinhosComuns(Pais outroPais) {
        List<Pais> vizinhosComuns = new ArrayList<>();
        for (Pais pais : fronteiras) {
            if (outroPais.getFronteiras().contains(pais)) {
                vizinhosComuns.add(pais);
            }
        }
        return vizinhosComuns;
    }

    public void adicionarFronteira(Pais pais) {
        if (fronteiras.size() < 40 && !fronteiras.contains(pais)) {
            fronteiras.add(pais);
        }
    }
}
