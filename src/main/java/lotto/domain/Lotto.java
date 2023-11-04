package lotto.domain;

import java.util.List;
import java.util.StringJoiner;
import lotto.domain.wrapper.LottoNumber;
import lotto.utils.ErrorMessage;
import lotto.utils.LottoConstantValue;
import lotto.utils.LottoConstant;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .toList();
    }

    private void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplication(numbers);
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != LottoConstantValue.LOTTO_NUMBERS_LENGTH.get()) {
            throw new IllegalArgumentException(
                    ErrorMessage.LOTTO_NUMBERS_LENGTH_ERROR.getFormattedMessage(
                            LottoConstantValue.LOTTO_NUMBERS_LENGTH.get()
                    )
            );
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        long uniqueNumbersLength = numbers.stream()
                .distinct()
                .count();
        if (numbers.size() != uniqueNumbersLength) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DUPLICATION_ERROR.getMessage());
        }
    }

    @Override
    public String toString() {
        StringJoiner lottoPrintFormat = new StringJoiner(
                LottoConstant.DELIMITER.getLottoStringWithSpace(),
                LottoConstant.OPENING_BRACKET.get(),
                LottoConstant.CLOSING_BRACKET.get());
        numbers.stream()
                .sorted()
                .map(LottoNumber::toString)
                .forEach(lottoPrintFormat::add);
        return lottoPrintFormat.toString();
    }
}
