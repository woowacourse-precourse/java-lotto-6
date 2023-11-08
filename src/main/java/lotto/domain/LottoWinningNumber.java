package lotto.domain;

import java.util.List;

public class LottoWinningNumber {

    private List<Integer> winningNums;
    private Integer bonusNum;

    public void getWinningSixNumbersInfo(List<Integer> numbers) {
        this.winningNums = numbers;
    }

    public void getWinningBonusNumbersInfo(int bonus) {
        this.bonusNum = bonus;
    }

    public List<Integer> getWinningNums() {
        return winningNums;
    }

    public Integer getBonusNum() {
        return bonusNum;
    }
}
