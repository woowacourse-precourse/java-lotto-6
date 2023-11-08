package lotto.domain.lotto;

import static lotto.global.constant.LottoConstant.LOTTO_NUMBER_AMOUNT;

import java.util.List;
import lotto.global.constant.message.ErrorMessage;
import lotto.global.exception.LottoIllegalArgumentException;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);

        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .toList();
    }


    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    public boolean containsNumber(LottoNumber number) {
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        validateNumbersAmount(numbers);
        validateNumbersDuplication(numbers);
    }

    private static void validateNumbersAmount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_AMOUNT) {
            throw new LottoIllegalArgumentException(ErrorMessage.LOTTO_NUMBER_AMOUNT_ERROR);
        }
    }

    private static void validateNumbersDuplication(List<Integer> numbers) {
        long numberCount = numbers.stream()
                .distinct()
                .count();
        if (numberCount != LOTTO_NUMBER_AMOUNT) {
            throw new LottoIllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DUPLICATION_ERROR);
        }
    }
}
