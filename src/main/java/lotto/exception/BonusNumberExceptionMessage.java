package lotto.exception;

import java.util.List;

public class BonusNumberExceptionMessage extends IllegalArgumentException{

    public BonusNumberExceptionMessage(String message){
        super(message);
    }

    public static void validateBonusNumberFormat(String inputBonusNumber) {
        if (!inputBonusNumber.matches("^([1-9]|[1-3]\\d|4[0-5])$")) {
            throw new BonusNumberExceptionMessage("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }

    public static void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new BonusNumberExceptionMessage("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}