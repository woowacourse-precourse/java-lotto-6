package lotto.domain.validator;

import java.util.List;
import lotto.domain.lotto.BonusNumber;
import lotto.domain.lotto.Lotto;
import lotto.util.ErrorMessage;

public class LottoValidator {
    public static final int LOTTO_NUMBERS = 6;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    public static void verifyNumbersSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBERS_COUNT.get());
        }
    }

    public static void verifyNoDuplication(List<Integer> numbers) {
        int uniqueCount = getUniqueCount(numbers);
        if (uniqueCount != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBERS.get());
        }
    }

    private static int getUniqueCount(List<Integer> numbers) {
        return (int) numbers.stream().distinct().count();
    }

    public static void verifyLottoNumberRange(List<Integer> numbers) {
        if (isOutOfRange(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBERS_OUT_OF_RANGE.get());
        }
    }

    private static boolean isOutOfRange(List<Integer> numbers) {
        return numbers.stream().anyMatch(number -> number < MIN_NUMBER || number > MAX_NUMBER);
    }

    public static void verifyBonusNumberRange(int bonusNumber) {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_OUT_OF_RANGE.get());
        }
    }

    public static void verifyBonusIsNotContainWinningNumbers(Lotto winningNumbers, BonusNumber bonusNumber) {
        if (hasBonusNumber(winningNumbers, bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WINNING_NUMBERS_AND_BONUS_NUMBER.get());
        }
    }

    private static boolean hasBonusNumber(Lotto winningNumbers, BonusNumber bonusNumber) {
        List<Integer> lottoNumbers = winningNumbers.getLottoNumbers();
        return lottoNumbers.contains(bonusNumber.getBonusNumber());
    }

    public static void verifyLottosNotNullOrNotEmpty(List<Lotto> lottos) {
        if (lottos == null || lottos.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_LOTTOS.get());
        }
    }
}
