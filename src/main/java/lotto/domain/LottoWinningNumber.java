package lotto.domain;

import java.util.List;

public class LottoWinningNumber {

    private List<Integer> winningNums;
    private Integer bonusNum;

    public void getWinningNumbersInfo(List<Integer> numbers, int bonus) {
        this.winningNums = numbers;
        this.bonusNum = bonus;
    }

    public List<Integer> getWinningNums() {
        return winningNums;
    }

    public Integer getBonusNum() {
        return bonusNum;
    }
}
