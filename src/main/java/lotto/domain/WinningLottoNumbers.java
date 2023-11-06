package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.constant.LottoConstant;
import lotto.view.exception.LottoInputException;
import lotto.view.message.LottoInputExceptionMessage;

public class WinningLottoNumbers {
    private List<LottoNumber> winningLottoNumbers;

    private WinningLottoNumbers(List<String> winningLottoNumbers) {
        this.winningLottoNumbers = new ArrayList<>();
    }

    public static WinningLottoNumbers from(final List<String> numbers) {
        validate(numbers);
        return new WinningLottoNumbers(numbers);
    }

    private static void validate(final List<String> numbers) {
        isEachInputNumericType(numbers);
        isEachNumberUnique(numbers);
    }

    private static void isEachInputNumericType(final List<String> numbers) {
        for (String number : numbers) {
            throwExceptionIfNotNumeric(number);
        }
    }

    private static void throwExceptionIfNotNumeric(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw LottoInputException.of(LottoInputExceptionMessage.WINNING_LOTTO_NUMBER_IS_NOT_NUMERIC_TYPE);
        }
    }

    private static void isEachNumberUnique(final List<String> numbers) {
        if (isSizeLessThanSix(numbers)) {
            throw LottoInputException.of(LottoInputExceptionMessage.WINNING_LOTTO_NUMBERS_ARE_DUPLICATED);
        }
    }

    private static boolean isSizeLessThanSix(final List<String> numbers) {
        return numbers.stream()
                .distinct()
                .count() < LottoConstant.LOTTO_ITEM_COUNT.getValue();
    }
}
