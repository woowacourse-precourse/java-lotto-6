package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import lotto.constant.LottoResultStatus;
import lotto.exception.LottoExceptionMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        isDuplicate(numbers);
        this.numbers = numbers;
    }

    public String getSortedNumbers() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers.toString();
    }

    public LottoResultStatus getLottoResultStatus(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        List<Integer> winning = winningNumbers.getWinningNumbers();
        int matchCount = (int) numbers.stream().filter(winning::contains).count();

        if (matchCount == 5 && isBonusMatch(bonusNumber)) {
            return LottoResultStatus.from(7);
        }
        return LottoResultStatus.from(matchCount);
    }

    private boolean isBonusMatch(BonusNumber bonusNumber) {
        return numbers.contains(bonusNumber.getBonusNumber());
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LottoExceptionMessage.LOTTO_NUMBERS_MUST_BE_SIX_DIGITS.getMessage());
        }
    }

    private void isDuplicate(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>(numbers);
        if (set.size() != 6) {
            throw new IllegalArgumentException(LottoExceptionMessage.LOTTO_NUMBERS_MUST_BE_SIX_DIGITS.getMessage());
        }
    }
}
