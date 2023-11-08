package lotto.domain;

import java.util.List;
import lotto.domain.validator.ValidateUserNumber;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        ValidateUserNumber.isLengthSix(numbers);
        ValidateUserNumber.isDuplicate(numbers);
        ValidateUserNumber.isInRange(numbers);
    }

    // TODO: 추가 기능 구현
    public boolean hasNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public int calculateWinNumber(LottoNumber lottoNumber) {
        int winCount = (int) numbers.stream()
                .map(lottoNumber::calculateScore)
                .filter(result -> result)
                .count();
        return winCount;
    }
}
