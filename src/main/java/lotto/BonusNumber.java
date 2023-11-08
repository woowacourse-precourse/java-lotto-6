package lotto;

import lotto.constant.LottoConstant;

import java.util.regex.Pattern;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber() {
        bonusNumber = 0;
    }

    public BonusNumber(String num) {
        vaildateNumber(num);
        vaildateRange(num);
        bonusNumber = Integer.parseInt(num);
    }

    private void vaildateNumber(String num) {
        if (!Pattern.matches("^[1-9|0-9]+$", num)) {
            throw new IllegalArgumentException();
        }
    }

    private void vaildateRange(String num) {
        int number = Integer.parseInt(num);
        if (number < LottoConstant.START.getNumber() || LottoConstant.END.getNumber() < number) {
            throw new IllegalArgumentException();
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
