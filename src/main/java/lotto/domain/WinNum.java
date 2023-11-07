package lotto.domain;

import lotto.enums.LottoEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.enums.LottoEnum.*;

public class WinNum {

    private final List<Integer> winNum;
    private final int bonusNum;

    public WinNum(List<Integer> winNum, int bonusNum) {
        this.winNum = winNum.stream().collect(Collectors.toList());
        this.bonusNum = bonusNum;
    }

    public int count(int number) {
        if (winNum.contains(number)) {
            return 1;
        }
        return 0;
    }

    public int bonusCount(int number) {
        if (bonusNum == number) {
            return 1;
        }
        return 0;
    }
}
