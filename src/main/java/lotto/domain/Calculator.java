package lotto.domain;

public class Calculator {

    private static final double PERCENT = 100.00;

    public String calculateROI(long prize, Amount amount){
        double spentCost = amount.getAmount();
        double roi = (double)prize/spentCost*PERCENT;
        return String.format("%.1f",roi);
    }

}
