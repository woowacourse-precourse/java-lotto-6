package lotto;

public class Profit {
    public double getRounding(Price price, Result checkedResult) {
        double profit = 0.0;
        for (Result result : checkedResult.values()){
            profit += (result.getCount() * result.getReward() * 100.0) / price.getPrice();
        }

        return Math.round(profit * 100.0) / 100.0;
    }
}
