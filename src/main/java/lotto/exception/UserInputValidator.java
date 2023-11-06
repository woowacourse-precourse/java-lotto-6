package lotto.exception;


import lotto.domain.Lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserInputValidator {
    private static final String DELIMITER = ",";
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int PURCHASE_UNIT = 1000;

    public static void validatePurchasePrice(String purchasePrice) {
        isNumber(purchasePrice);
        isValidPurchaseRange(Integer.parseInt(purchasePrice));
        isValidPurchaseUnit(Integer.parseInt(purchasePrice));
    }

    public static void validateWinningLotto(String winningLotto) {
        String[] splitLotto = winningLotto.split(DELIMITER);
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
            throw new IllegalArgumentException("[ERROR] 당첨 로또 번호와 보너스 번호는 서로 달라야 합니다.");
        }
    }

    private static void isValidDuplicateWinningLotto(List<String> splitLotto) {
        Set<String> setLotto = new HashSet<>(splitLotto);
        if (setLotto.size() != splitLotto.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 로또 번호는 중복되면 안됩니다.");
        }
    }

    public static void isValidLottoSize(int splitSize) {
        if (splitSize != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 ,로 구분해야 합니다.");
        }
    }

    public static void isValidLottoRange(int lottoNumber) {
        if (MIN_LOTTO_NUMBER > lottoNumber || MAX_LOTTO_NUMBER < lottoNumber) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45까지의 정수여야 합니다.");
        }
    }

    public static void isNumber(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력 값은 숫자여야 합니다.");
        }
    }

    public static void isValidPurchaseRange(int userInput) {
        if (userInput <= 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 양수여야 합니다.");
        }
    }

    public static void isValidPurchaseUnit(int userInput) {
        if (userInput % PURCHASE_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위여야 합니다.");
        }
    }
}

