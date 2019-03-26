package server;

public class Document {
    private String name;
    private double uspeh;
    private double dohod;
    private String fakultet;

    public Document() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUspeh() {
        return uspeh;
    }

    public void setUspeh(double uspeh) {
        this.uspeh = uspeh;
    }

    public double getDohod() {
        return dohod;
    }

    public void setDohod(double dohod) {
        this.dohod = dohod;
    }

    public String getFakultet() {
        return fakultet;
    }

    public void setFakultet(String fakultet) {
        this.fakultet = fakultet;
    }
}
