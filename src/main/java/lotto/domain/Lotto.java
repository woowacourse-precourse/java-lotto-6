package lotto.domain;

import java.util.List;
import lotto.constant.LottoConstant;
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
        isSizeNotSix(numbers);
        isEachNumberUnique(numbers);
    }

    private static void isSizeNotSix(final List<Integer> numbers) {
        if (numbers.size() != LottoConstant.LOTTO_ITEM_COUNT.getValue()) {
            throw LottoInputException.of(LottoInputExceptionMessage.LOTTO_NUMBERS_SIZE_IS_NOT_SIX);
        }
    }

    private static void isEachNumberUnique(final List<Integer> numbers) {
        if (eachNumberIsNotUnique(numbers)) {
            throw LottoInputException.of(LottoInputExceptionMessage.LOTTO_NUMBERS_ARE_DUPLICATED);
        }
    }

    private static boolean eachNumberIsNotUnique(final List<Integer> numbers) {
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