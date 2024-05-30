public class Empregado {
    private String primeiroNome;
    private String sobrenome;
    private float salarioMensal;

    public Empregado(String primeiroNome, String sobrenome, float salarioMensal) {
        this.primeiroNome = primeiroNome;
        this.sobrenome = sobrenome;
        this.setSalarioMensal(salarioMensal);
    }

    public Empregado() {
        this.primeiroNome = "";
        this.sobrenome = "";
        this.salarioMensal = 0.0f;
    }

    public float calcularSalarioAnual() {
        return this.salarioMensal * 12;
    }

    public void aumentarSalario() {
        this.salarioMensal = this.salarioMensal * 1.10f;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setSalarioMensal(float salarioMensal) {
        if (salarioMensal > 0) {
            this.salarioMensal = salarioMensal;
        } else {
            this.salarioMensal = 0.0f;
        }
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public float getSalarioMensal() {
        return salarioMensal;
    }
}
