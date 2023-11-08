package lotto.domain;

import lotto.verification.InputVerification;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        InputVerification inputVerification = new InputVerification();

        if (!inputVerification.isInputSizeCorrect(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또번호 개수 에러");
        }
        if (inputVerification.isNumbersDuplicated(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또번로 중복");
        }

    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }
}
