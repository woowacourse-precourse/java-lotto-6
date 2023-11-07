package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.controller.BonusNumberController;
import lotto.controller.PurchaseResultController;
import lotto.controller.WinningNumberController;

public class ComparingLotto {

    public Map<Integer, Integer> comparingLotto() {
        List<List<Integer>> createsLotto = PurchaseResultController.createsLotto;
        List<Integer> convertingWinningNumbers = WinningNumberController.convertingWinningNumbers;
        int bonus = BonusNumberController.bonusNumber;
        return createsLotto.stream()
                .map(lottoNumbers -> countMatchingNumbers(lottoNumbers, convertingWinningNumbers, bonus))
                .filter(count -> count >= 3)
                .collect(Collectors.toMap(count -> count, count -> 1, Integer::sum));
    }

    private int countMatchingNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers, int bonus) {
        long matchingNumbers = lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
        if (matchingNumbers == 5 && lottoNumbers.contains(bonus)) {
            return 7;
        }
        return (int) matchingNumbers;
    }

}


