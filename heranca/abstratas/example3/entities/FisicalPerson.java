package heranca.abstratas.example3.entities;

public class FisicalPerson extends Person{

    private Double healthExpenses;

    public FisicalPerson() {

    }

    public FisicalPerson(String name, Double annualIncome, Double healthExpenses) {
        super(name, annualIncome);
        this.healthExpenses = healthExpenses;
    }

    public Double getHealthExpenses() {
        return healthExpenses;
    }

    public void setHealthExpenses(Double healthExpenses) {
        this.healthExpenses = healthExpenses;
    }

    public Double tax() {
        double taxPercentage = 0.0;
        if (getAnnualIncome() < 20000.00) {
            taxPercentage = 0.15;
        } else {
            taxPercentage = 0.25;
        }

        double tax = 0.0;
        if (healthExpenses > 0.0) {
            tax = getAnnualIncome() * taxPercentage - getHealthExpenses() * 0.5;
        } else {
            tax = getAnnualIncome() * taxPercentage;
        }

        if(tax < 0.0) {
            return 0.0;
        }

        return tax;
    }
}
