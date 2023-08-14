package heranca.abstratas.example3.entities;

public class LegalPerson extends Person{

    private Integer numberEmployees;

    public LegalPerson() {

    }

    public LegalPerson(String nome, Double annualIncome, Integer numberEmployees) {
        super(nome, annualIncome);
        this.numberEmployees = numberEmployees;
    }

    public Integer getNumberEmployees() {
        return numberEmployees;
    }

    public void setNumberEmployees(Integer numberEmployees) {
        this.numberEmployees = numberEmployees;
    }

    public Double tax() {

        double tax = 0.0;
        double taxPercentage = 0.0;
        if(getNumberEmployees() > 10) {
            taxPercentage = 0.14;
        } else {
            taxPercentage = 0.16;
        }
        tax = getAnnualIncome() * taxPercentage;
        if(tax < 0.0) {
            return 0.0;
        }

        return tax;
    }
}
