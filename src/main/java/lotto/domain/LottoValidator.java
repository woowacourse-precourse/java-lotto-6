package lotto.domain;

import java.util.List;

public class LottoValidator {
    public void validate(List<Integer> numbers) {
        validateNumbersLength(numbers);
        validateNumberRange(numbers);
    }

    private void validateNumbersLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 총 6개입니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for(int number : numbers){
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }
}
