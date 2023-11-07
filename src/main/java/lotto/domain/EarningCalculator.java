package lotto.domain;

public class EarningCalculator implements Calculator{

    double earn;
    double money;
    public EarningCalculator(int money, double earn){
        this.earn = earn;
        this.money = money;
    }
    @Override
    public int computeInt() {
        return 0;
    }

    @Override
    public double computeDouble() {
        return earn/money*100;
    }
}
