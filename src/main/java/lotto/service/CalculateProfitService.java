package lotto.service;

import lotto.view.ProfitView;

public class CalculateProfitService {
    ProfitView profitView = new ProfitView();
    private static final int HUNDRED = 100;

    public void printProfit(int winningPrice, int buyingPrice) {
        profitView.printProfit(calculateProfit(winningPrice, buyingPrice));
    }

    public double calculateProfit(int winningPrice, int buyingPrice) {
        return ((double) winningPrice / (double) buyingPrice) * HUNDRED;
    }
}
