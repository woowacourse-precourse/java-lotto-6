package lotto.vo;

import java.util.List;

public class WinLotto {

    private List<Integer> numbers;
    private int bonusNum;

    public WinLotto(List<Integer> numbers, int bonusNum) {
        this.numbers = numbers;
        this.bonusNum = bonusNum;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNum() {
        return bonusNum;
    }
}
