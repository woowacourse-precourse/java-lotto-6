package lotto.domain;

import java.util.HashSet;
import java.util.List;


public class WinningNumbers {

    private List<Integer> winningNums;
    private int bonusNum;

    public WinningNumbers() {
    }

    public WinningNumbers(List<Integer> winningNums) {
        validate(winningNums);
        this.winningNums = winningNums;
    }

    public WinningNumbers(int bonusNum) {
//        validate(bonusNum);
        this.bonusNum = bonusNum;
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
