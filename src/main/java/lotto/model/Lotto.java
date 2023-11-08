package lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoConstant;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INAPPROPRIATE_NUMBER_COUNT_ERROR);
        }

        numbers.forEach(number -> {
            if (number < LottoConstant.LOTTO_FIRST_NUMBER || number > LottoConstant.LOTTO_LAST_NUMBER) {
                throw new IllegalArgumentException(ErrorMessage.INAPPROPRIATE_NUMBER_ERROR);
            }
        });

        if (numbers.size() > numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER_ERROR);
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }

    public String getNumbersAsString() {
        return numbers.stream().map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    public void validateBonusNumber(int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_BONUS_NUMBER_ERROR);
        }
    }
}
