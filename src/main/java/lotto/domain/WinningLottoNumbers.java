package lotto.domain;

import java.util.List;
import lotto.domain.constant.LottoConstant;
import lotto.view.exception.LottoInputException;
import lotto.view.message.LottoInputExceptionMessage;

public class WinningLottoNumbers {
    private final List<LottoNumber> winningLottoNumbers;

    private WinningLottoNumbers(List<LottoNumber> winningLottoNumbers) {
        this.winningLottoNumbers = winningLottoNumbers;
    }

    public static WinningLottoNumbers from(final List<Integer> numbers) {
        validate(numbers);
        return new WinningLottoNumbers(makeWinningLottoNumbers(numbers));
    }

    private static void validate(final List<Integer> numbers) {
        isEachNumberUnique(numbers);
    }

    private static void isEachNumberUnique(final List<Integer> numbers) {
        if (isSizeLessThanSix(numbers)) {
            throw LottoInputException.of(LottoInputExceptionMessage.WINNING_LOTTO_NUMBERS_ARE_DUPLICATED);
        }
    }

    private static boolean isSizeLessThanSix(final List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() < LottoConstant.LOTTO_ITEM_COUNT.getValue();
    }

    private static List<LottoNumber> makeWinningLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::from)
                .toList();
    }

    public List<LottoNumber> getWinningLottoNumbers() {
        return this.winningLottoNumbers;
    }
}