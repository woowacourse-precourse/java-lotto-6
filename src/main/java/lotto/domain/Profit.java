package lotto.domain;

import java.util.List;

public class Profit {
    public double CalProfit(Integer Amount, List<Integer> result){
        double profit = 0.2f;
        double sum = 0;
        for(int i=3; i<7; i++){
            switch (i){
                case 3:
                    sum += result.get(i) * 5000;
                    break;
                case 4:
                    sum += result.get(i) * 50000;
                    break;
                case 5:
                    sum += result.get(i) * 1500000;
                    break;
                case 6:
                    sum += result.get(i) * 2000000000;
                    break;
                case 7:
                    sum += result.get(i) * 30000000;
                    break;
                default:
                    break;
            }
        }
        profit = (sum/Amount)*100;
        return profit;
    }

    public void PrintProfit(double profit){
        System.out.println(profit);
    }

}
