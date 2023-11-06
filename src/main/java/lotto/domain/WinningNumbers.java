package lotto.domain;

import java.util.HashSet;
import java.util.List;

import static lotto.domain.LottoConst.*;
import static lotto.domain.LottoConst.NOT_INPUT_WINNING_NUMS_NUMBER;


public class WinningNumbers {

    private List<Integer> winningNums;
    private int bonusNum;

    public WinningNumbers(List<Integer> winningNums, int bonusNum) {
        validate(winningNums, bonusNum);
        this.winningNums = winningNums;
        this.bonusNum = bonusNum;
    }

    private void validate(List<Integer> winningNums, int bonusNum) {
        try {
            for (int num : winningNums) {
                if (num < LOTTO_MIN_NUM || num > LOTTO_MAX_NUM) throw new IllegalArgumentException(NOT_INPUT_NUM_IN_RANGE);
            }
            if (winningNums.size() != LOTTO_SIZE) throw new IllegalArgumentException(NOT_LOTTO_SIZE);
            if (winningNums.contains(bonusNum)) throw new IllegalArgumentException(DUPLICATE_NUMS);
            if (bonusNum < LOTTO_MIN_NUM || bonusNum > LOTTO_MAX_NUM) throw new IllegalArgumentException(NOT_INPUT_NUM_IN_RANGE);

            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < winningNums.size(); j++) {
                if (set.contains(winningNums.get(j))) {
                    throw new IllegalArgumentException(DUPLICATE_NUMS);
                }
                set.add(winningNums.get(j));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INPUT_WINNING_NUMS_NUMBER);
        }
    }

    public List<Integer> getWinningNums() {
        return winningNums;
    }

    public void setWinningNums(List<Integer> winningNums) {
        this.winningNums = winningNums;
    }

    public int getBonusNum() {
        return bonusNum;
    }

    public void setBonusNum(int bonusNum) {
        this.bonusNum = bonusNum;
    }

    private void validate(List<Integer> winningNums) {
        if (winningNums.size() != 6) {
            throw new IllegalArgumentException();
        }
        HashSet<Integer> set = new HashSet<>();
        for (int j = 0; j < winningNums.size(); j++) {
            if (set.contains(winningNums.get(j))) {
                throw new IllegalArgumentException("중복 숫자 예외");
            }
            set.add(winningNums.get(j));
        }
    }
//
//    private void validate(int bonus) {
//        try {
//
//        }
//    }


}
