package lotto;

import java.util.List;

public class LottoNumberComparator {
    private List<Integer> winningNumbers;
    private int bonusNumber;
    public LottoNumberComparator(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }


    public int calculateMatchingNumbers(List<Integer> numbers) {
        int count = 0;
        for (Integer number : numbers) {
            if (winningNumbers.contains(number)) {
                count += 1;
            }
        }
        return count;
    }

    public int calculateMatchingNumberWithBonusNumber(List<Integer> numbers) {
        int count = 0;
        for (Integer number : numbers) {
            if (bonusNumber == number) {
                count += 1;
            }
        }
        return count;

    }



}
