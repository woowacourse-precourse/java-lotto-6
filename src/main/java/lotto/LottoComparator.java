package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoComparator {

    public LottoComparator() {
    }

    public List<Integer> compareLotto(List<Integer> winningNumbers, Integer bonus, Lotto lotto) {
        ArrayList<Integer> result = new ArrayList<>();
        int matchWinningNumbersCount = matchWinningNumbers(winningNumbers, lotto);
        int matchBonusCount = lotto.countBonusMatch(bonus);
        result.add(matchWinningNumbersCount);
        result.add(matchBonusCount);

        return result;
    }

    private int matchWinningNumbers(List<Integer> winningNumbers, Lotto lotto) {
        int result = 0;
        List<Integer> numbers = lotto.getNumbers();
        for (Integer winningNumber : winningNumbers) {
            if (numbers.contains(winningNumber)) {
                result++;
            }
        }
        return result;
    }
}
