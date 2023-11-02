package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateNumbersInRange(numbers);
        validateNumbersIsDuplicated(numbers);
        this.numbers = numbers;
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("6개의 로또 번호만 입력할 수 있습니다.");
        }
    }

    // TODO: 추가 기능 구현
    private void validateNumbersInRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateLottoNumberInRange(number);
        }
    }

    private void validateLottoNumberInRange(int lottoNumber) {
        if (lottoNumber < LottoNumbers.MIN_LOTTO_NUMBER.getNumber()
                || lottoNumber > LottoNumbers.MAX_LOTTO_NUMBER.getNumber()) {
            throw new IllegalArgumentException("로또 번호는 1~45까지의 숫자만 입력할 수 있습니다.");
        }
    }

    private void validateNumbersIsDuplicated(List<Integer> numbers) {
        Set<Integer> copyNumbers = new HashSet<>();
        copyNumbers.addAll(numbers);
        if (copyNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("로또 번호가 중복되었습니다.");
        }
    }
}
