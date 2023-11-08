package lotto.validator;

import lotto.util.Utils;

import java.util.List;

public class BonusLottoValidator {
    public static boolean isInvalid(String bonusLotto) {
        try {
            Utils.convertStringToInt(bonusLotto);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 하나의 숫자를 입력해주셔야 합니다.");
            return true;
        }
        return false;
    }

    public static boolean isInvalidNumber(String bonusLottoString) {
        int bonusLotto = Utils.convertStringToInt(bonusLottoString);
        if (bonusLotto > 45 || bonusLotto < 1) {
            System.out.println("[ERROR] 보너스 번호는 1 ~ 45 사이의 숫자이어야 합니다.");
            return true;
        }
        return false;
    }

    public static boolean isDuplicated(String bonusLottoString, List<Integer> winningLotto) {
        int bonusLotto = Utils.convertStringToInt(bonusLottoString);
        if (winningLotto.contains(bonusLotto)) {
            System.out.println("[ERROR] 보너스 번호는 당첨 번호와 달라야 합니다.");
            return true;
        }
        return false;
    }
}
