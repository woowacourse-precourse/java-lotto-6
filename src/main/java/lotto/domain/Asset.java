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

    public void increaseIncome(int grade){
        if(grade == 1){
            income += 2000000000;
            return;
        }
        if(grade == 2){
            income += 30000000;
        }
        if(grade == 3){
            income += 1500000;
        }
        if(grade == 4){
            income += 50000;
        }
        if(grade == 5){
            income += 5000;
        }
    }

    public Float getRate(){
        return income / money * 100;
    }
    public Float getMoney(){
        return money;
    }
}
