package lotto.domain;

public class EarningCalculator{

    double earn;
    double money;
    public EarningCalculator(int money, double earn){
        this.earn = earn;
        this.money = money;
    }
    public double compute() {
        return earn/money*100;
    }
}
