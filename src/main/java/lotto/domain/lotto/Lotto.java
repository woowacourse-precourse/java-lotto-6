package lotto.domain.lotto;

import lotto.constants.ErrorMessage;
import lotto.constants.LottoRule;
import lotto.domain.winningNumber.BonusNumber;
import lotto.domain.winningNumber.FinalWinningNumber;
import lotto.domain.winningNumber.WinningNumber;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicateNumbers(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LottoRule.LOTTO_NUMBER_COUNT.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INVALID_NUMBER.getMessage());
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_DUPLICATE_NUMBER.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public LottoRank compareLottoNumberWithFinalWinningNumber(
            FinalWinningNumber finalWinningNumber) {
        return LottoRank.getRank(Arrays.asList(
                compareWithWinningNumber(finalWinningNumber.winningNumber()),
                compareWithBonusNumber(finalWinningNumber.bonusNumber())
        ));
    }

    private int compareWithWinningNumber(WinningNumber winningNumber) {
        return (int) numbers.stream()
                .filter(o -> winningNumber.getWinningNumber().stream()
                        .anyMatch(Predicate.isEqual(o)))
                .count();
    }

    private int compareWithBonusNumber(BonusNumber bonusNumber) {
        if (numbers.contains(bonusNumber.getBonusNumber())) {
            return 1;
        }
        return 0;
    }
}
