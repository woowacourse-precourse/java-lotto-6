package lotto.domain;

public class Asset {
    private final Float money;
    private Float income;

    public Asset(Float money) {
        validate(money);
        this.money = money;
        this.income = 0F;
    }
    private void validate(Float money) {
        if(money % 1000 != 0){
            throw new IllegalArgumentException("wrong money input");
        }
    }
    public void increaseIncome(Grade grade){
        income += grade.getPrize();
    }
    public Float getRate(){
        if (money == 0) return 0F;
        return (income / money) * 100;
    }
    public Float getMoney(){
        return money;
    }
}
