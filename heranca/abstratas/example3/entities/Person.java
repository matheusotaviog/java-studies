package heranca.abstratas.example3.entities;

public abstract class Person {

    private String name;
    private Double annualIncome;

    public Person() {

    }
    public Person(String nome, Double annualIncome) {
        this.name = nome;
        this.annualIncome = annualIncome;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(Double annualIncome) {
        this.annualIncome = annualIncome;
    }

    public abstract Double tax();

}
