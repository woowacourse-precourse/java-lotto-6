package lotto.Enum;

import static lotto.Enum.ErrorMessage.INDEX_OUT_OF_RANGE_ERROR;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum Number {

    THOUSAND(1000),
    ONE(1),
    THREE(3),
    SIX(6),
    SEVEN(7),
    FORTY_FIVE(45),
    WINNING_MONEY(0, 0, 0, 5000, 50000, 1500000, 2000000000, 30000000);

    private List<Integer> winningMoney;
    private int number;

    Number(int unit) {
        this.number = unit;
    }

    Number(Integer... money) {
        winningMoney = new ArrayList<>();
        Collections.addAll(winningMoney, money);
    }

    public int getMoneyByIndex(int index) {
        if (index < 0 || index >= winningMoney.size()) {
            throw new IndexOutOfBoundsException(INDEX_OUT_OF_RANGE_ERROR.getMessage());
        }
        return winningMoney.get(index);
    }

    public int getNumber() {
        return number;
    }
}
