package lotto;

import java.util.Collections;
import java.util.List;

import static lotto.ErrorCheck.validateRandomLottoSize;

public class Lotto {
    private final List<Integer> numbers;

    Lotto(List<Integer> numbers) {
        validateLottoSize(numbers);
        this.numbers = numbers;
        Collections.sort(numbers);
    }

    private void validateLottoSize(List<Integer> numbers) {
        validateRandomLottoSize(numbers);
    }

    public void printLottoPaper(Lotto lotto) {
        System.out.println(lotto.numbers);
    }


    public Score compareWinningNumbers(WinningNumberSet winningNumberSets) {
        int countMatch = 0;
        boolean checkBonus = false;
        for (String winningNumber : winningNumberSets.getWinningNumbers()) {
            if (numbers.contains(Integer.parseInt(winningNumber))) {
                countMatch++;
            }
        }
        if (numbers.contains(winningNumberSets.getBonusNumber())) {
            checkBonus = true;
        }

        return new Score(countMatch, checkBonus);

    }
}
