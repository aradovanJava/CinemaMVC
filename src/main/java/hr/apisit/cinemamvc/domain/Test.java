package hr.apisit.cinemamvc.domain;

public class Test {

    private String prvi;
    private String drugi;
    private String treci;

    public Test(String prvi, String drugi, String treci) {
        this.prvi = prvi;
        this.drugi = drugi;
        this.treci = treci;
    }

    public String getPrvi() {
        return prvi;
    }

    public void setPrvi(String prvi) {
        this.prvi = prvi;
    }

    public String getDrugi() {
        return drugi;
    }

    public void setDrugi(String drugi) {
        this.drugi = drugi;
    }

    public String getTreci() {
        return treci;
    }

    public void setTreci(String treci) {
        this.treci = treci;
    }
}
