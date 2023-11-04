package lotto.validator;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Validator {

    private int maxMoney = Integer.MAX_VALUE;

    public void validateMoney(String moneyInput) {
        checkNumber(moneyInput);
        checkGoe0(moneyInput);
        checkLoeMaxMoney(moneyInput);
        checkDivisibleBy1000(moneyInput);
    }

    private void checkNumber(String moneyInput) {
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
        checkForm(lottoNumberInput);
        checkRange(lottoNumberInput);
        checkDuplication(lottoNumberInput);
    }

    private void checkForm(String lottoNumberInput) {
        if (!Pattern.matches("^\\d+(,\\d+){5}$", lottoNumberInput)) {
            throw new IllegalArgumentException("번호 양식에 맞게 입력해주세요.");
        }
    }

    private void checkRange(String lottoNumberInput) {
        int numberCount = (int) Arrays.stream(lottoNumberInput.split(","))
                .mapToInt(Integer::parseInt)
                .filter(number -> (number >= 1 && number <= 45))
                .count();
        if (numberCount != 6) {
            throw new IllegalArgumentException("1~45 사이의 수를 입력해주세요.");
        }
    }

    private void checkDuplication(String lottoNumberInput) {
        int numberCount = (int) Arrays.stream(lottoNumberInput.split(","))
                .mapToInt(Integer::parseInt)
                .distinct()
                .count();
        if (numberCount != 6) {
            throw new IllegalArgumentException("서로 다른 6개의 숫자를 입력해주세요.");
        }
    }

    public void validateBonusNumber(String bonusNumberInput) {

    }

    public void setMaxMoney(int maxMoney) {
        this.maxMoney = maxMoney;
    }
}
