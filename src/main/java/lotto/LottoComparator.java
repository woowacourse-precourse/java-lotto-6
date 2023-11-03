package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoComparator {

    public LottoComparator() {
    }

    public List<Integer> compareLotto(List<String> winningNumbers, Integer bonus, Lotto lotto) {
        ArrayList<Integer> result = new ArrayList<>();
        int matchWinningNumbersCount = matchWinningNumbers(winningNumbers, lotto);
        int matchBonusCount = matchBonusNumber(bonus, lotto);
        result.add(matchWinningNumbersCount);
        result.add(matchBonusCount);

        return result;
    }

    private int matchBonusNumber(Integer bonus, Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        if (numbers.contains(bonus)) {
            return 1;
        }

        return 0;
    }

    private int matchWinningNumbers(List<String> winningNumbers, Lotto lotto) {
        int result = 0;
        List<Integer> numbers = lotto.getNumbers();
        for (String winningNumber : winningNumbers) {
            if (numbers.contains(Integer.parseInt(winningNumber))) {
                result++;
            }
        }
        return result;
    }
}
