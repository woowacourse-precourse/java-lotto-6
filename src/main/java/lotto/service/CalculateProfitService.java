package lotto.service;

import lotto.view.ProfitView;

public class CalculateProfitService {
    private static final int HUNDRED = 100;
    ProfitView profitView = new ProfitView();

    public void printProfit(int winningPrice, int buyingPrice) {
        profitView.printProfit(calculateProfit(winningPrice, buyingPrice));
    }

    public double calculateProfit(int winningPrice, int buyingPrice) {
        return ((double) winningPrice / (double) buyingPrice) * HUNDRED;
    }
}
