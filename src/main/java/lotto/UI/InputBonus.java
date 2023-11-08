package lotto.UI;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputBonus {
    public int inputBonusNumber(List<Integer> lottoNumbers) {
        int bonusNumber = -1;
//        while (bonusNumber < 0) {
            System.out.println("보너스 번호를 입력해 주세요.");
//            try {
                bonusNumber = checkBonusNumber(Console.readLine(), lottoNumbers);
//            } catch (IllegalArgumentException e) {
//                System.out.println(e.getMessage());
//            }
//        }
        return bonusNumber;
    }

    private int checkBonusNumber(String inputBonusNumber, List<Integer> lottoNumbers) {
        int bonusNumber = checkBonusNumberToInt(inputBonusNumber);
        checkBonusNumberRange(bonusNumber);
        checkBonusNumberDup(bonusNumber, lottoNumbers);
        return bonusNumber;
    }

    public static int checkBonusNumberToInt(String inputBonusNumber) {
        try {
            return Integer.parseInt(inputBonusNumber);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자를 입력해주세요.");
        }
    }

    public static void checkBonusNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 ~ 45 사이의 수를 입력해주세요.");
        }
    }

    public static void checkBonusNumberDup(int bonusNumber, List<Integer> lottoNumbers) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않은 숫자를 입력해주세요.");
        }
    }
}
