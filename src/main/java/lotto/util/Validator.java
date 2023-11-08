package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Validator {
    private static final Pattern purchaseAmountPattern = Pattern.compile("^[1-9]([0-9])*000$");
    private static final Pattern winningNumberPattern = Pattern.compile(
            "(([1-9]|[1-3][0-9]|4[0-5]),){5}[1-9]|[1-3][0-9]|4[0-5]");
    private static final Pattern bonusNumberPattern = Pattern.compile("[1-9]|[1-3][0-9]|4[0-5]");
    private static final String PURCHASE_INPUT_ERROR_MESSAGE = "[ERROR] 1000원 단위의 양수를 입력해 주세요";
    private static final String WINNING_INPUT_ERROR_MESSAGE = "[ERROR] 1에서 45 사이의 6개의 양수를 중복과 공백없이 ,로 구분해서 입력해 주세요.";
    private static final String BONUS_INPUT_ERROR_MESSAGE = "[ERROR] 1에서 45 사이의 하나의 숫자를 당첨 숫자와 중복없이 입력해주세요.";

    public static boolean lottoPurchaseAmountValidator(String inputLottoPurchaseAmount) {
        try {
            isCorrectPurchaseAmount(inputLottoPurchaseAmount);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(PURCHASE_INPUT_ERROR_MESSAGE);
            return false;
        }
    }

    private static void isCorrectPurchaseAmount(String inputLottoPurchaseAmount) {
        if (!purchaseAmountPattern.matcher(inputLottoPurchaseAmount).matches()) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean lottoNumberValidator(String inputLottoNumbers) {
        try {
            isCorrectLottoNumbers(inputLottoNumbers);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(WINNING_INPUT_ERROR_MESSAGE);
            return false;
        }
    }

    private static void isCorrectLottoNumbers(String inputLottoNumbers) {
        if (winningNumberPattern.matcher(inputLottoNumbers).matches()) {
            isDuplicatedNumbers(inputLottoNumbers);
            return;
        }
        throw new IllegalArgumentException();
    }

    private static void isDuplicatedNumbers(String inputLottoNumbers) {
        String[] winningNumbers = inputLottoNumbers.split(",");

        if (Arrays.stream(winningNumbers)
                .distinct()
                .count() != winningNumbers.length) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean bonusNumberValidator(String inputBonusNumber, List<Integer> winningNumbers) {
        try {
            isCorrectInputBonusNumber(inputBonusNumber);
            isDuplicatedWithWinningNumbers(inputBonusNumber, winningNumbers);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(BONUS_INPUT_ERROR_MESSAGE);
            return false;
        }
    }

    private static void isDuplicatedWithWinningNumbers(String inputBonusNumber, List<Integer> winningNumbers) {
        int bonusNumber = Integer.parseInt(inputBonusNumber);

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private static void isCorrectInputBonusNumber(String inputBonusNumber) {
        if (!bonusNumberPattern.matcher(inputBonusNumber).matches()) {
            throw new IllegalArgumentException();
        }
    }
}