package lotto.validator;

import java.util.List;
import java.util.regex.Pattern;
import lotto.util.ConverterUtil;

public class InputWinningNumberValidator {
    private static final int WINNING_LOTTO_SIZE = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final String LOTTO_BONUS_NUMBER_REGEX = "[0-9]+";
    private static final String LOTTO_WINNING_NUMBERS_REGEX = "([0-9]+,?)+";


    public static void validateWinningNumber(String winningNumber) {
        if (isNotSeparateByComma(winningNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표로 구분한 숫자를 입력해야 합니다.");
        }
        if (isNotLottoNumber(winningNumber)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45사이의 숫자여야 합니다.");
        }
        if (incorrectLottoNumberSize(winningNumber)) {
            throw new IllegalArgumentException("[ERROR] 로또번호는 6개를 입력해야 합니다.");
        }
        if (isOverlapLottoNumber(winningNumber)) {
            throw new IllegalArgumentException("[ERROR] 중복된 로또 번호를 입력하였습니다.");
        }

    }

    public static void validateBonusNumber(String bonusNumber) {
        if (isNotDigit(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
        if (isNotLottoBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45사이의 숫자여야 합니다.");
        }
    }

    private static boolean isNotLottoNumber(String purchaseAmount) {
        List<Integer> winningNumbers = ConverterUtil.covertStringToList(purchaseAmount);
        return winningNumbers.stream()
                .anyMatch(winningNumber -> winningNumber < MIN_LOTTO_NUMBER || winningNumber > MAX_LOTTO_NUMBER);
    }

    private static boolean isNotSeparateByComma(String purchaseAmount) {
        return !Pattern.compile(LOTTO_WINNING_NUMBERS_REGEX).matcher(purchaseAmount).matches();

    }

    private static boolean incorrectLottoNumberSize(String purchaseAmount) {
        List<Integer> winningNumbers = ConverterUtil.covertStringToList(purchaseAmount);
        return winningNumbers.size() != WINNING_LOTTO_SIZE;
    }

    private static boolean isOverlapLottoNumber(String purchaseAmount) {
        List<Integer> winningNumbers = ConverterUtil.covertStringToList(purchaseAmount);
        return winningNumbers.stream().distinct().count() != WINNING_LOTTO_SIZE;
    }

    private static boolean isNotDigit(String bonusNumber) {
        return !Pattern.compile(LOTTO_BONUS_NUMBER_REGEX).matcher(bonusNumber).matches();
    }

    private static boolean isNotLottoBonusNumber(String bonusNumber) {
        int bonusNum = ConverterUtil.convertStringToInt(bonusNumber);
        return bonusNum < MIN_LOTTO_NUMBER || bonusNum > MAX_LOTTO_NUMBER;
    }
}
