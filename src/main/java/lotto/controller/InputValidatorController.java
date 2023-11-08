package lotto.controller;

import static lotto.utils.phrase.ErrorPhrase.*;
import static lotto.utils.system.LottoSystemUtils.*;

public class InputValidatorController {

    public static void inputMoneyValidate(String money) {
        isMoneyDigit(money);
        isRightRangeMoney(money);
        isRightMoneyUnit(Long.parseLong(money));
    }

    public static void inputLottoNumberValidate(String lottoNumbers) {
        isAllDigit(lottoNumbers);
    }

    public static void inputLottoBonusNumberValidate(String lottoBonusNumber) {
        isLottoNumberDigit(lottoBonusNumber);
    }

    private static void isAllDigit(String lottoNumbers) {
        for (String separate : lottoNumbers.split(",")) {
            isLottoNumberDigit(separate);
        }
    }

    private static void isLottoNumberDigit(String num) {
        try {
            Integer.parseInt(num);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_PHRASE_LOTTO_NUMBER_IS_NOT_DIGIT);
        }
    }

    private static void isMoneyDigit(String num) {
        try {
            Integer.parseInt(num);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_PHRASE_MONEY_IS_NOT_DIGIT);
        }
    }

    private static void isRightRangeMoney(String money) {
        Long purchaseMoney = Long.parseLong(money);

        if (purchaseMoney < MONEY_MIN_RANGE || purchaseMoney > MONEY_MAX_RANGE) {
            throw new IllegalArgumentException(ERROR_PHRASE_MONEY_IS_OUT_OF_RANGE);
        }
    }

    private static void isRightMoneyUnit(long money) {
        if (money % MONEY_UNIT != 0 || money == 0) {
            throw new IllegalArgumentException(ERROR_PHRASE_MONEY_IS_WRONG_UNIT);
        }
    }
}
