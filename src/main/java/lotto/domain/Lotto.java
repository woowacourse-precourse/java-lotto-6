package lotto.domain;

import static lotto.constant.LottoConstant.COUNT;
import static lotto.exception.ErrorMessage.DUPLICATE_NUMBER;
import static lotto.exception.ErrorMessage.WRONG_SIZE;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import lotto.constant.LottoConstant;
import lotto.constant.Rank;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != COUNT.getValue()) {
            throw LottoException.of(WRONG_SIZE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (isDuplicateNumber(numbers)) {
            throw LottoException.of(DUPLICATE_NUMBER);
        }
    }

    private static boolean isDuplicateNumber(List<Integer> numbers) {
        return numbers.size() != Set.copyOf(numbers).size();
    }

    private void validateRange(List<Integer> numbers) {
        if (isWrongRange(numbers)) {
            throw LottoException.of(ErrorMessage.WRONG_RANGE);
        }
    }

    private void validateRange(int bonusNumber) {
        if (isWrongRange(bonusNumber)) {
            throw LottoException.of(ErrorMessage.WRONG_RANGE);
        }
    }

    private static boolean isWrongRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(Lotto::isWrongRange);
    }

    private static boolean isWrongRange(Integer number) {
        return number < LottoConstant.MIN_NUMBER.getValue() ||
                number > LottoConstant.MAX_NUMBER.getValue();
    }

    public void validateBonusNumber(int bonusNumber) {
        validateRange(bonusNumber);

        if (numbers.contains(bonusNumber)) {
            throw LottoException.of(DUPLICATE_NUMBER);
        }

    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public Rank getRank(Lotto answerLotto, int bonusNumber) {
        int sameNumberCount = answerLotto.checkSameNumber(numbers);
        boolean hasBonus = numbers.contains(bonusNumber);

        return Rank.of(sameNumberCount, hasBonus);
    }

    private int checkSameNumber(List<Integer> numbers) {
        return (int) numbers.stream()
                .filter(this.numbers::contains)
                .count();
    }


}
