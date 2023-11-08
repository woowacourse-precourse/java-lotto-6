package lotto.service;

import lotto.dto.Bingo;

public class CalculateProfit {
    double profit = 0;

    public void calcProfit(){
        profit += 5000*Bingo.getBingo3().correctLotto;
        profit += 50000*Bingo.getBingo4().correctLotto;
        profit += 1500000*Bingo.getBingo5().correctLotto;
        profit += 30000000*Bingo.getBingo5wB().correctLotto;
        profit += 2000000000*Bingo.getBingo6().correctLotto;
    }

    public double calcProfitPercent(int money){
        double percent = (profit/(double)money)*100;
        return Math.round(percent*100)/100.0;
    }

}
