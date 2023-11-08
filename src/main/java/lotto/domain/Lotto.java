package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public int compare(List<Integer> winningNumbers) {
        int count = 0;
        for (Integer i : numbers) {
            if (winningNumbers.contains(i)) {
                winningNumbers.remove(i);
                count++;
            }
        }
        return count;
    }

    public Rank compareResult(int count, int bonusNumber) {
        if (count == 6) {
            return Rank.FIRST_PLACE;
        }
        if (count == 5) {
            if (numbers.contains(bonusNumber)) {
                return Rank.SECOND_PLACE;
            }
            return Rank.THIRD_PLACE;
        }
        if (count == 4) {
            return Rank.FOURTH_PLACE;
        }
        if (count == 3) {
            return Rank.FIFTH_PLACE;
        }
        return Rank.LAST_PLACE;
    }

    public static void lottoPrint(List<Lotto> lottoNumbers, int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
        for (Lotto lotto : lottoNumbers) {
            Collections.sort(lotto.numbers);
            System.out.println(lotto.numbers);
        }
    }
}
