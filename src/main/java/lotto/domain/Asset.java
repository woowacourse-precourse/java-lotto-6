package lotto.domain;

public class Asset {
    private final Double money;
    private Double income;

    public Asset(Double money) {
        validate(money);
        this.money = money;
        this.income = 0D;
    }

    private void validate(Double money) {
        if(money % 1000 != 0){
            System.out.println("1000");
            throw new IllegalArgumentException("wrong money input");
        }

        if(money > Double.MAX_VALUE){
            System.out.println("over");
            throw new IllegalArgumentException("wrong money input or money overflow");
        }
    }

    public void increaseIncome(Grade grade){
        income += grade.getPrize();
        System.out.println(income);
        validateIncome(income);
    }

    private void validateIncome(Double income){
        if(income > Double.MAX_VALUE){
            throw new IllegalArgumentException("income overflow");
        }
    }

    public Double getRate(){
        if (money == 0) return 0D;
        return (income / money) * 100;
    }

    public Double getMoney(){
        return money;
    }

    public Double getIncome() { return income; }

    public void setIncome(Double income) {
        validateIncome(income);
        this.income = income;
    }
}
