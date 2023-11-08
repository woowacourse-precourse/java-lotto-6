package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final List<Integer> numbers; // 로또 당첨번호
    private final int bonusNum;

    public WinningLotto(List<Integer> numbers, int bonusNum) {
        this.numbers = numbers;
        this.bonusNum = bonusNum;
    }

    public int countMatchedNum(List<Integer> numbers) {
        int count = 0;
        for (int number : numbers) {
            if (this.numbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public boolean isMatchedBonus(List<Integer> numbers) {
        return numbers.contains(bonusNum);
    }
}
