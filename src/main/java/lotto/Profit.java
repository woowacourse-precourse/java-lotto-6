package lotto;

import java.util.HashMap;
import java.util.Map;

public class Profit {

    Map<Rank, Integer> result;
    double profit;
    double profitRate;
    Money money;

    public Profit(Map<Rank, Integer> result, Money money) {
        this.result = result;
        this.money = money;
        calProfit();
        calProfitRate();
    }

    public void calProfit(){
        for (Rank r : Rank.values()){
            profit += r.prize * result.get(r);
        }
        this.profit = profit;
    }

    public void calProfitRate(){
        profitRate = profit / Integer.parseInt(money.amount) * 100;
    }

    public void printProfitRate(){
        System.out.println("총 수익률은 " + String.format("%.1f", profitRate) + "%입니다.");
    }
}
