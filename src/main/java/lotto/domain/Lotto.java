package lotto.domain;

import java.util.List;

import static lotto.domain.LottoStandard.*;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateDuplicatedNumbers(numbers);
        validateNumberRange(numbers);

        this.numbers = numbers;
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != SIZE.getNumber()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다. 다시 입력해주세요.");
        }
    }

    private void validateDuplicatedNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (numbers.contains(number)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복할 수 없습니다. 다시 입력해주세요.");
            }
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if(number < MIN.getNumber() || number > MAX.getNumber()) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이의 숫자여야 합니다. 다시 입력해주세요.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
