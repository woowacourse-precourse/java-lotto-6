package lotto.domain;

import java.util.List;

public class LottoChecker {
    public static int countMatchingNumbers(Lotto lotto, LottoAnswer lottoAnswer) {
        List<Integer> numbers = lotto.getNumbers();
        List<Integer> answerNumbers = lottoAnswer.getNumbers();

        int count = (int) numbers.stream()
                .filter(answerNumbers::contains)
                .count();

        if (lottoAnswer.hasBonusNumber() && isBonusNumberMatch(lotto, lottoAnswer.getBonusNumber())) {
            count += 1;
        }
        return count;
    }

    public static boolean isBonusNumberMatch(Lotto lotto, BonusNumber bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber.getNumber());
    }
}
