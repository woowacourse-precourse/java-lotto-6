package lotto.Domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.Constant.Constant;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicate(numbers);
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != Constant.LOTTO_NUMBER_AMOUNT) {
            String errorMessage = Constant.ERROR_PREFIX + "6개의 번호를 입력하지 않으셨습니다.";
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != Constant.LOTTO_NUMBER_AMOUNT) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }
    }

    public void validateDuplicateBonusNumber(LottoNumber bonusNumber) {
        if (numbers.contains(bonusNumber.getLottoNumber())) {
            String errorMessage = Constant.ERROR_PREFIX + "이미 당첨 번호에 있는 숫자입니다.";
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
