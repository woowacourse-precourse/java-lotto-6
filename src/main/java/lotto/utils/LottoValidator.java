package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LottoValidator {
    private static final String DIGIT_REGEX = "^[0-9]+$";
    private static final String LOTTO_WINNING_NUMBERS_REGEX = "^[0-9,]+$";

    public static boolean isRestOfLottoPurchaseAmountDivideBy1000NotZero(String lottoPurchaseAmount) {
        return Integer.parseInt(lottoPurchaseAmount) % LottoConstants.A_LOTTO_PRICE.getValue() != 0;
    }

    public static boolean isLottoPurchaseAmountNotDigit(String lottoPurchaseAmount) {
        return !Pattern.compile(DIGIT_REGEX).matcher(String.valueOf(lottoPurchaseAmount)).matches();
    }

    public static boolean isLottoWinningNumbersSizeNotSix(List<Integer> lottoWinningNumbers) {
        return lottoWinningNumbers.size() != LottoConstants.CORRECT_LOTTO_WINNING_NUMBERS_SIZE.getValue();
    }

    public static boolean isLottoWinningNumbersDuplicate(List<Integer> lottoWinningNumbers) {
        long numbersDistinctSize = lottoWinningNumbers.stream()
                .distinct().count();
        return numbersDistinctSize != LottoConstants.CORRECT_LOTTO_WINNING_NUMBERS_SIZE.getValue();
    }

    public static boolean isLottoWinningNumbersWrongRange(List<Integer> lottoWinningNumbers) {
        long correctNumbersRangeCount = lottoWinningNumbers.stream()
                .filter(number -> number >= 1 && number <= 45)
                .count();
        return correctNumbersRangeCount != LottoConstants.CORRECT_LOTTO_WINNING_NUMBERS_SIZE.getValue();
    }

    public static boolean isLottoWinningNumbersWrongType(String inputLottoWinningNumber) {
        return !Pattern.compile(LOTTO_WINNING_NUMBERS_REGEX).matcher(inputLottoWinningNumber).matches();
    }

    public static boolean isBonusNumberNotDigit(String bonusNumber) {
        return !Pattern.compile(DIGIT_REGEX).matcher(bonusNumber).matches();
    }

    public static boolean isBonusNumberWrongRange(String bonusNumber) {
        return Integer.parseInt(bonusNumber) < 1 || Integer.parseInt(bonusNumber) > 45;
    }

    public static boolean isBonusNumberDuplicateWinningNumbers(String lottoWinningNumbers, String bonusNumber) {
        List<Integer> collectedLottoWinningNumbers = Arrays.stream(lottoWinningNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return collectedLottoWinningNumbers.contains(Integer.parseInt(bonusNumber));
    }
}
