package lotto.data;

import java.util.ArrayList;
import java.util.List;

public class Statics {
    private int profit;
    private List<Integer> count = new ArrayList<>();


    public Statics(int c) {
        count.add(0);
        count.add(0);
        count.add(0);
        count.add(0);
        count.add(0);
        count.add(0);
    } // CHECK

    public void EvaluateProfit(Purchasing purchasing){
        int purchasedPrice = purchasing.getPurchasedPrice();

        int totalCost = 0;
        for (int i = 0; i < count.size(); i++) {
            totalCost += count.get(i) * Prize.getMoneyByNumber(i);
        }

        double profitRate = ((double) (purchasedPrice - totalCost) / totalCost) * 100;
        this.profit = (int) Math.round(profitRate);
    }

    public int getProfit() {
        return profit;
    }

    public List<Integer> getCount() {
        return count;
    }

    public int getCountNumber(int number) {
        return count.get(number);
    }
}
