package lotto.Domain;

import java.util.List;

public class WinnigNumbers {
    public static final String INVALID_RANGE_MESSAGE = "[ERROR] 1~45 사이의 숫자를 입력해주세요";
    public static final String DUPLICATE_MESSAGE = "[ERROR] 보너스 번호는 당첨번호와 중복될 수 없습니다.";
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    private Lotto winnigNumbers;
    private int bonusNumber;

    public WinnigNumbers(List<Integer> winNum, String bonusNum) {
        winnigNumbers = new Lotto(winNum);
        int bonusNumber = Integer.parseInt(bonusNum);
        validateNumber(bonusNumber);
        validateDuplicate(winNum, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateNumber(int bonusNumber) {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException(INVALID_RANGE_MESSAGE);
        }
    }

    private void validateDuplicate (List<Integer> winNum, int bonusNum) {
        if (winNum.contains(bonusNum)) {
            throw new IllegalArgumentException(DUPLICATE_MESSAGE);
        }
    }

}
