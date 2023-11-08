package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.InputView;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        try {
            validateSixNumbers(numbers);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            InputView.inputWinningNumbers();
        }
    }

    // TODO: 추가 기능 구현

    private void validateSixNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자가 필요합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
