package lotto.validator;

import java.util.regex.Pattern;

public class Validator {

    private int maxMoney = Integer.MAX_VALUE;

    public void validateMoney(String moneyInput) {
        isNumber(moneyInput);
        checkGoe0(moneyInput);
        checkLoeMaxMoney(moneyInput);
        checkDivisibleBy1000(moneyInput);
    }

    private void isNumber(String moneyInput) {
        if (!Pattern.matches("^\\d+$", moneyInput)) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    private void checkGoe0(String moneyInput) {
        if ((Integer.parseInt(moneyInput) < 0)) {
            throw new IllegalArgumentException("0이상의 값을 입력해주세요.");
        }
    }

    private void checkLoeMaxMoney(String moneyInput) {
        if ((Integer.parseInt(moneyInput) > maxMoney)) {
            throw new IllegalArgumentException(maxMoney + "이하의 값을 입력해주세요.");
        }
    }

    private void checkDivisibleBy1000(String moneyInput) {
        if ((Integer.parseInt(moneyInput) % 1000) != 0) {
            throw new IllegalArgumentException("1000으로 나누어 떨어지는 값을 입력해주세요.");
        }
    }

    public void validateLottoNumber(String lottoNumberInput) {

    }

    public void validateBonusNumber(String bonusNumberInput) {

    }

    public void setMaxMoney(int maxMoney) {
        this.maxMoney = maxMoney;
    }
}
