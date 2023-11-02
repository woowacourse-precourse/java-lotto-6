package lotto.domain;

import lotto.enums.LottoEnum;

import java.util.List;

import static lotto.enums.LottoEnum.*;

public class WinNum {

    private List<Integer> winNum;
    private int bonusNum;

    public WinNum(List<Integer> winNum, int bonusNum) {
        this.winNum = winNum;
        this.bonusNum = bonusNum;
    }

    public LottoEnum countResult(Lotto lotto) {
        int count = 0, bonusCount = 0;
        for (int number : lotto.getNumbers()) {
            if (winNum.contains(number)) count++;
            if (bonusNum == number) bonusCount++;
        }
        if (count == 6) return W1;
        if (count == 5 && bonusCount == 1) return W2;
        if (count == 5) return W3;
        if (count == 4) return W4;
        if (count == 3) return W5;
        return null;
    }
}
