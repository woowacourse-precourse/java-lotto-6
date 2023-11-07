package lotto.exception;

import lotto.domain.Lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constant.Constants.*;

public class UserInputValidator {
    private static final String DUPLICATE_WINNING_NUMBER_AND_BONUS_NUMBER_MESSAGE = "[ERROR] 당첨 로또 번호와 보너스 번호는 서로 달라야 합니다.";
    private static final String DUPLICATE_LOTTO_NUMBER_MESSAGE = "[ERROR] 당첨 로또 번호는 중복되면 안됩니다.";
    private static final String INVALID_WINNING_NUMBER_DELIMITER_MESSAGE = "[ERROR] 당첨 번호는 ,로 구분해야 합니다.";
    private static final String INVALID_LOTTO_NUMBER_RANGE_MESSAGE = "[ERROR] 당첨 번호는 1부터 45까지의 정수여야 합니다.";
    private static final String NON_NUMERIC_INPUT_MESSAGE = "[ERROR] 입력 값은 숫자여야 합니다.";
    private static final String NEGATIVE_PURCHASE_AMOUNT_MESSAGE = "[ERROR] 로또 구입 금액은 양수여야 합니다.";
    private static final String INVALID_PURCHASE_UNIT_MESSAGE = "[ERROR] 로또 구입 금액은 1000원 단위여야 합니다.";

    public static void validatePurchasePrice(String purchasePrice) {
        isNumber(purchasePrice);
        isValidPurchaseRange(Integer.parseInt(purchasePrice));
        isValidPurchaseUnit(Integer.parseInt(purchasePrice));
    }

    public static void validateWinningLotto(String winningLotto) {
        String[] splitLotto = winningLotto.split(WINNING_LOTTO_DELIMITER);
        isValidLottoSize(splitLotto.length);
        for (String lottoNumber : splitLotto) {
            isNumber(lottoNumber);
            isValidLottoRange(Integer.parseInt(lottoNumber));
        }
        isValidDuplicateWinningLotto(List.of(splitLotto));
    }

    public static void validateBonusNumber(Lotto winningLotto, String bonusNumber) {
        isNumber(bonusNumber);
        isValidLottoRange(Integer.parseInt(bonusNumber));
        isValidDuplicateBonusNumber(winningLotto, Integer.parseInt(bonusNumber));
    }

    private static void isValidDuplicateBonusNumber(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.contain(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_WINNING_NUMBER_AND_BONUS_NUMBER_MESSAGE);
        }
    }

    private static void isValidDuplicateWinningLotto(List<String> splitLotto) {
        Set<String> setLotto = new HashSet<>(splitLotto);
        if (setLotto.size() != splitLotto.size()) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER_MESSAGE);
        }
    }

    public static void isValidLottoSize(int splitSize) {
        if (splitSize != LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER_DELIMITER_MESSAGE);
        }
    }

    public static void isValidLottoRange(int lottoNumber) {
        if (MIN_LOTTO_NUMBER > lottoNumber || MAX_LOTTO_NUMBER < lottoNumber) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE_MESSAGE);
        }
    }

    public static void isNumber(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMERIC_INPUT_MESSAGE);
        }
    }

    public static void isValidPurchaseRange(int userInput) {
        if (userInput <= 0) {
            throw new IllegalArgumentException(NEGATIVE_PURCHASE_AMOUNT_MESSAGE);
        }
    }

    public static void isValidPurchaseUnit(int userInput) {
        if (userInput % STANDARD_LOTTO_AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_UNIT_MESSAGE);
        }
    }
}

