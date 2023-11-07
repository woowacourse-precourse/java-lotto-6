package lotto.domain;

import java.util.List;
import lotto.domain.constant.LottoConstant;
import lotto.view.exception.LottoInputException;
import lotto.view.message.LottoInputExceptionMessage;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = makeLottoNumbers(numbers);
    }

    public static Lotto from(final List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private static void validate(final List<Integer> numbers) {
        isEachNumberUnique(numbers);
    }

    private static void isEachNumberUnique(final List<Integer> numbers) {
        if (isSizeLessThanSix(numbers)) {
            throw LottoInputException.of(LottoInputExceptionMessage.LOTTO_NUMBERS_ARE_DUPLICATED);
        }
    }

    private static boolean isSizeLessThanSix(final List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() < LottoConstant.LOTTO_ITEM_COUNT.getValue();
    }

    private static List<LottoNumber> makeLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::from)
                .toList();
    }

    public List<LottoNumber> getLottoNumbers() {
        return this.numbers;
    }
}