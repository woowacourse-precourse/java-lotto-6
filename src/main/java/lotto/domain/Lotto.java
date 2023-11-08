package lotto.domain;

import lotto.message.ErrorMessage;
import lotto.validate.Validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.message.ErrorMessage.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_SIZE_EXCEPTION.getMessage());
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }

    public int calculateMatchNumber(UserLotto userLotto) {
        return (int) userLotto.getLottoNumber().stream()
                .filter(number -> numbers.contains(number))
                .count();
    }

    public boolean calculateBonusNumber(UserLotto userLotto) {
        return numbers.contains(userLotto.getBonusNumber());
    }
}
