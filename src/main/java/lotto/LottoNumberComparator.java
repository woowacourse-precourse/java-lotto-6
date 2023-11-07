package lotto;

import java.util.List;

public class LottoNumberComparator {
    private List<Integer> winningNumbers;

    public LottoNumberComparator(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
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



}
