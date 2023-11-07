package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        Collections.sort(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_PROPER_LOTTO_NUMBER.getMessage());
        }
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
