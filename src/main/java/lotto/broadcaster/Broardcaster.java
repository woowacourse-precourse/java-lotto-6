package lotto.broadcaster;

import lotto.utils.CustomScanner;
import lotto.utils.Validator;

public class Broardcaster {
    public String[] pickLotteryNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputLotteryNumbers = CustomScanner.getReadLine();
        if (!Validator.validateLotteryNumbersAndSize(inputLotteryNumbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        String[] result = inputLotteryNumbers.split(",");
        if (Validator.isDuplicate(result)) {
            throw new IllegalArgumentException("[ERROR] 중복된 로또 번호가 존재합니다.");
        }

        return result;
    }

    public int pickBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputBonusNumber = CustomScanner.getReadLine();
        if (!Validator.validateBonusNumber(inputBonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        return Integer.parseInt(inputBonusNumber);
    }
}
