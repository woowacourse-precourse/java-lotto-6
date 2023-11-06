package lotto.domain;

import java.util.ArrayList;
import java.util.List;
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
        // 6개의 값이 숫자 형식인지 확인한다.
        isEachInputNumericType(numbers);
        // 중복이 되지 않는지 확인한다.
        // LottoNumber -> 1 ~ 45 까지의 숫자인지를 책임진다.
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

    private static void isEachInputNotDuplicate(final List<String> numbers) {

    }
}
