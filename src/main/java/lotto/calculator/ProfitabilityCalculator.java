package lotto.calculator;

import java.util.List;
import lotto.WinningPrize;

public class ProfitabilityCalculator {


    private int amountOfMoney;

    private List<WinningPrize> prizes;

    private int profits = 0;
    public ProfitabilityCalculator(int amountOfMoney, PrizeCalculator prizeCalculator) {
        this.amountOfMoney = amountOfMoney;
        this.prizes = prizeCalculator.getPrizes();
    }

    //반올림하는 기능 만들어야해
    public double calculateProfitability () {
        calculateProfits(prizes);

        double fakeProfitability = ((double) profits/amountOfMoney) * 100;
        //반올림
        double profitability = Math.round(fakeProfitability*10)/10.0;
        return profitability;
    }


    public void calculateProfits (List<WinningPrize> prizes) {
        for (int i=0; i<prizes.size(); i++) {
            profits = profits + prizes.get(i).getPrize();
        }
    }
}
