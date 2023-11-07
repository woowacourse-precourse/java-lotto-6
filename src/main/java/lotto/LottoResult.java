package lotto;

import java.util.List;


public class LottoResult {

    private final List<Integer> resultNumbers;
    private final int bonusNumber;

    public LottoResult(List<Integer> resultNumbers, int bonusNumber) {
        this.resultNumbers = resultNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int containResultNumbers(int number) {
        if (resultNumbers.contains(number)) {
            return 1;
        }
        return 0;
    }

    public boolean hasBonusNumber(List<Integer> numbers) {
        return numbers.contains(bonusNumber);
    }
}
