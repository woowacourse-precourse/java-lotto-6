package lotto.Enum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Number {

    UNIT(1000),
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    SIX(6),
    THREE(3),
    WINNING_MONEY(0,0,0,5000, 50000, 1500000, 2000000000, 30000000);

    private List<Integer> winningMoney;
    private int number;

    Number(int unit){
        this.number = unit;
    }
    Number(Integer... money) {
        winningMoney = new ArrayList<>();
        winningMoney.addAll(Arrays.asList(money));
    }

    public int getMoneyByIndex(int index) {
        if (index < 0 || index >= winningMoney.size()) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return winningMoney.get(index);
    }
    public int getNumber() {
        return number;
    }
}
