package validator;

import java.util.List;

public class BonusNumberValidator {
    public static int bonusNumberValidate(String bonusNumber, List<Integer> lottoWinningNumbers) {
        bonusNumberNotNull(bonusNumber);
        bonusNumberRange(bonusNumber);
        int lottoBonusNumber;
        try {
            lottoBonusNumber = Integer.parseInt(bonusNumber);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 1부터 45까지의 수를 입력해주세요.");
        }
        bonusNumberUnique(lottoBonusNumber, lottoWinningNumbers);
        return lottoBonusNumber;

    }

    private static void bonusNumberNotNull(String bonusNumber) {
        if (bonusNumber.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 값을 입력해주세요.");
        }
    }

    private static void bonusNumberRange(String bonusNumber) {
        if (!bonusNumber.matches("([1-9]|[1-3][0-9]|4[0-5])")) {
            throw new IllegalArgumentException("[ERROR] 1부터 45까지의 수를 입력해주세요.");
        }
    }

    private static void bonusNumberUnique(int lottobonusNumber, List<Integer> lottoWinningNumbers) {
        if (lottoWinningNumbers.contains(lottobonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복되지 않은 수를 입력해주세요.");
        }
    }

}
