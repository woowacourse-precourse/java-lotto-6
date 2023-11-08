package lotto.domain;

import java.util.List;
import lotto.controller.Validator;
import lotto.view.Message;

public class Lotto {
    private final List<Integer> numbers;
    private static final int FIVE = 5;
    private static final int SECOND_FLAG = -1;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!Validator.isSizeSix(numbers)) {
            throw new IllegalArgumentException(Message.ERROR_IS_NOT_SIX_BY_COMMMA.label());
        }

        if (!Validator.isDistinct(numbers)) {
            throw new IllegalArgumentException(Message.ERROR_IS_NOT_SIX_BY_COMMMA.label());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getCorrectCount(List<Integer> answerlottoNumbers, int bonusNumber) {
        int correctCount = (int) answerlottoNumbers.stream()
                .filter(numbers::contains)
                .count();

        if (correctCount == FIVE && numbers.contains(bonusNumber)) {
            return SECOND_FLAG * correctCount;
        }

        return correctCount;
    }
}
