package lotto.model;

import lotto.CalculateLotto;
import lotto.constant.ExceptionMessage;
import lotto.constant.LottoConstant;

import java.util.regex.Pattern;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber() {
        bonusNumber = 0;
    }

    public BonusNumber(String num, CalculateLotto answerLotto) {
        vaildateNumber(num);
        vaildateRange(num);
        vaildateLotto(answerLotto,num);
        bonusNumber = Integer.parseInt(num);
    }

    private void vaildateNumber(String num) {
        if (!Pattern.matches("^[1-9|0-9]+$", num)) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_ONLY.getMessage());
        }
    }

    private void vaildateRange(String num) {
        int number = Integer.parseInt(num);
        if (number < LottoConstant.START.getNumber() || LottoConstant.END.getNumber() < number) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_RANGE.getMessage());
        }
    }

    private void vaildateLotto(CalculateLotto lotto,String number){
        if(lotto.isCheckedBonusNumber(Integer.parseInt(number))){
            throw new IllegalArgumentException(ExceptionMessage.BONUS_NUMBER_IN_WINNING_LOTTO.getMessage());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
