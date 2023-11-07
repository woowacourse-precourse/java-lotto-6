package lotto.Exception;

import java.util.List;

public class BonusNumberException {
    private final static String ERROR = "[ERROR] ";

    public void checkBonusNumber(List<Integer> bonusNumbers, int bonusNumber) {
        notRightRangeCase(bonusNumber);
        duplicationCase(bonusNumbers, bonusNumber);
    }

    // [E2] 보너스 번호의 1~45 범위에 벗어난 경우
    public void notRightRangeCase(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ERROR + "보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }


    public void BonusNumberCase(String bonusNumber) {
        // [E5] 공백을 입력한 경우
        if (bonusNumber.trim().isEmpty()) {
            throw new IllegalArgumentException(ERROR + "보너스 번호를 입력해주세요.");
        }

        // [E3] 보너스 번호에 문자를 입력한 경우([E1] 보너스 번호의 개수가 1개가 아닐 경우도 이곳에서 예외 처리)
        for (int i = 0; i < bonusNumber.length(); i++) {
            char c = bonusNumber.charAt(i);
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(ERROR + "보너스 번호는 숫자와 콤마(,)로 구성해야 하며 1개여야 합니다.");
            }
        }
    }

    // [E4] 보너스 번호가 중복된 경우
    public void duplicationCase(List<Integer> bonusNumbers, int bonusNumber) {
        if (bonusNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR + "보너스 번호는 중복되지 않는 숫자를 입력해주세요.");
        }
    }
}
