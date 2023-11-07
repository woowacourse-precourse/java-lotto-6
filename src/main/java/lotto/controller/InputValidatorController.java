package lotto.controller;

import static lotto.utils.ErrorPhrase.*;
import static lotto.utils.LottoSystemUtils.moneyUnit;

public class InputValidatorController {

    public static void inputMoneyValidate(String money) {
        isMoneyDigit(money);
        isRightMoneyUnit(Integer.parseInt(money));
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

    private static void isRightMoneyUnit(int money) {
        if (money % moneyUnit != 0 || money == 0) {
            throw new IllegalArgumentException(ERROR_PHRASE_MONEY_IS_WRONG_UNIT);
        }
    }
}
