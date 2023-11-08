package lotto.model;

import lotto.Winnings;

import java.util.List;

public class WinningMoney {
    private final List<Integer> winningMoneyList;
    private int money = 0;

    public WinningMoney(List<Integer> winningMoneyList) {
        this.winningMoneyList = winningMoneyList;
        calculateWinningMoney();
    }

    private void calculateWinningMoney() {

        for (int i = 1; i <= 5; i++) {
            money += winningMoneyList.get(i) * Winnings.values()[i - 1].getPrize();
        }
    }

    public int getWinningMoney() {
        return money;
    }
}
