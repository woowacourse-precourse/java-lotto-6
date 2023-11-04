package lotto.entity;

import lotto.common.LottoValidator;
import lotto.common.Range;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        new LottoValidator().validateLotto(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int checkWin(Lotto prize, int bonus) {
        return getRank(getCount(prize), bonus);
    }

    private int getCount(Lotto prize) {
        int count = 0;

        for (int number : numbers) {
            if (prize.getNumbers().contains(number)) {
                count++;
            }
        }
        return count;
    }

    private int getRank(int count, int bonus) {
        if (count == Range.SIZE.getValue()) {
            return 1;
        }
        if (count == (Range.SIZE.getValue() - 1) && numbers.contains(bonus)) {
            return 2;
        }
        if (count >= 3) {
            return (Range.SIZE.getValue() + 2) - count;
        }
        return 0;
    }

}
