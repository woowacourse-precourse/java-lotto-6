package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lib.constant.LottoConstants;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        this.validateNumbers(numbers);
    private void validateNumbers(List<Integer> numbers) {
        this.validateNumberSize(numbers);
        this.validateNumberDuplicated(numbers);
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개만 입력할 수 있습니다.");
        }
    }

    private void validateNumberDuplicated(List<Integer> numbers) {
        Set<Integer> uniqueNumber = new HashSet<Integer>();

        numbers.forEach(number -> uniqueNumber.add(number));

        if (uniqueNumber.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 로또 번호를 입력하였습니다.");
        }
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
