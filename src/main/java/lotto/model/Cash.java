package lotto.model;

import java.util.Iterator;
import java.util.List;

public class Cash {
    private final int cash;

    public Cash(int cash) {
        cashCheck(cash); // 1000원 단위인지 확인
        this.cash = cash;
    }

    public void cashCheck(int cash){
        if (cash % 1000 != 0 || cash < 1000){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 천 원 단위여야 합니다.");
        }
    }

    public int getNumber() {
        return cash;
    }
}
