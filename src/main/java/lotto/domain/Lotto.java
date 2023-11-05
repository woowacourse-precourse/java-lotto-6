package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.system.ExceptionMessage;
import lotto.system.LottoNumberConstant;
import lotto.validator.BallValidator;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public Lotto createAuto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(LottoNumberConstant.MIN.getValue(),
                LottoNumberConstant.MAX.getValue(), LottoNumberConstant.LENGTH.getValue()));
    }

    private void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateDistinct(numbers);
        numbers.forEach(BallValidator::validate);
    }

    private void validateLength(List<Integer> numbers) {
        if (LottoNumberConstant.LENGTH.isNotEqual(numbers.size())) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_LENGTH.getMessage());
        }
    }

    private void validateDistinct(List<Integer> numbers) {
        if (isDuplicate(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_DISTINCT.getMessage());
        }
    }

    private boolean isDuplicate(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() != numbers.size();
    }
}
