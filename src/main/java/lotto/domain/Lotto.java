package lotto.domain;

import static lotto.global.constants.NumberType.LOTTO_SIZE;

import java.util.Collections;
import java.util.List;
import lotto.global.exception.ErrorMessage;
import lotto.global.exception.LottoException;

/**
 * 로또 번호를 저장하는 클래스
 */
public class Lotto {
    private final List<Number> numbers;

    private Lotto(List<Number> numbers) {
        Validator.validate(numbers);
        this.numbers = numbers;
    }

    /**
     * 로또 번호를 저장하는 객체를 생성하는 메서드
     *
     * @param numbers 로또 번호
     * @return 로또 객체
     */
    public static Lotto from(final List<Integer> numbers) {
        return new Lotto(parse(numbers));
    }

    public static List<Number> parse(final List<Integer> numbers) {
        return numbers.stream()
                .map(Number::valueOf)
                .toList();
    }

    /**
     * 로또 번호를 반환하는 메서드
     *
     * @return 로또 번호
     */
    public List<Number> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private static class Validator {
        private static void validate(final List<Number> numbers) {
            if (numbers.size() != LOTTO_SIZE.getValue()) {
                throw LottoException.from(ErrorMessage.INVALID_LOTTO_SIZE_ERROR);
            }
        }
    }
}
