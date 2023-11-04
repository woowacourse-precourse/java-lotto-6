package lotto.valid;

import static lotto.consts.LottoConst.LOTTO_MAX_NUMBER;
import static lotto.consts.LottoConst.LOTTO_MIN_NUMBER;

import java.util.List;
import lotto.domain.WinNumber;

public class BonusNumberValid {

    public static int validBonusNumber(WinNumber winNumber, String input) {
        int bonusNumber = validOnlyNumber(input);
        validNumValue(bonusNumber);
        validNotDuplicateWinNumber(winNumber, bonusNumber);
        return bonusNumber;
    }


    private static int validOnlyNumber(String input) {
        String reg = "^[0-9]*$";
        if (!input.matches(reg)) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 숫자만 입력 가능합니다.");
        }
        return Integer.parseInt(input);
    }

    private static void validNumValue(int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1과 45 사이의 숫자여야 합니다.");
        }
    }

    private static void validNotDuplicateWinNumber(WinNumber winNumber, int bonusNumber) {
        List<Integer> lottoNums = winNumber.getLottoNums();
        if (lottoNums.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되는 숫자가 들어가면 안 됩니다.");
        }
    }
}
