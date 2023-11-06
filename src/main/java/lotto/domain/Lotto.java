package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.common.Constant;
import lotto.common.ErrorMessage;
import lotto.util.LottoNumberGenerator;
import lotto.util.LottoNumberValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto from() {
        List<Integer> numbers = LottoNumberGenerator.generate();
        return new Lotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateLottoNumSize(numbers);
        validateLottoInvalidNumber(numbers);
    }

    // 로또 번호 개수가 6개가 아닐 경우
    private void validateLottoNumSize(List<Integer> numbers) {
        if (numbers.size() != Constant.LOTTO_NUM_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUM_SIZE_ERROR.getMessage());
        }
    }

    // 로또 번호가 1 - 45 사이의 수가 아닐 경우
    private void validateLottoInvalidNumber(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> !LottoNumberValidator.validate(number))) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUM_RANGE_ERROR.getMessage());
        }
    }

    // 로또 번호 가운데 중복된 수가 있을 경우
    private void validateLottoDuplicationNumber(List<Integer> numbers) {
        if(numbers.stream().distinct().collect(Collectors.toList()).size() != Constant.LOTTO_NUM_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUM_DUPLICATION_ERROR.getMessage());
        }
    }
}
