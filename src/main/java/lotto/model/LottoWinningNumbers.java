package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoWinningNumbers {
    private Lotto winningNumbers;
    private int bonusNumber;

    public LottoWinningNumbers(Lotto winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        validateBonusNumber(winningNumbers.getNumbers(), bonusNumber);
    }

    public List<Integer> correctNumberCheckerForMultipleLottos(Lottos lottos) {
        List<Integer> matchCounts = new ArrayList<>();
        for (int i = 0; i < lottos.getLottos().size(); i++) {
            List<Integer> result = correctNumberChecker(lottos.getLottos().get(i));
            if (result.get(0) == 5) {
                // 맞는 숫자가 5개 일 때, 보너스 번호가 맞는 경우 +10 해준다.
                matchCounts.add(result.get(0) + result.get(1) * 10);
                continue;
            }
            matchCounts.add(result.get(0));
        }
        return matchCounts;
    }

    private List<Integer> correctNumberChecker(Lotto lotto) {
        int matchCount = 0;
        int bonusCount = 0;
        for (int i = 0; i < lotto.getNumbers().size(); i++) {
            int number = lotto.getNumbers().get(i);
            if (winningNumbers.getNumbers().contains(number)) {
                matchCount++;
                continue;
            }
            if (number == bonusNumber) {
                bonusCount++;
            }
        }
        return Arrays.asList(matchCount, bonusCount);
    }

    private void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        isNumberInRange(bonusNumber);
        duplicateCheckForBonusNumber(numbers, bonusNumber);
    }

    private void isNumberInRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 1과 45사이의 숫자가 아닙니다.");
        }
    }

    private void duplicateCheckForBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERRPR] 당첨 번호 중 보너스 번호와 중복되는 숫자가 있습니다.");
        }
    }


}
