package lotto.exception;

import java.util.List;
import lotto.Lotto;
import lotto.type.ConditionSetting;

public class BonusNumberException {

    private static final int MIN_NUMBER = ConditionSetting.MIN_NUMBER.getValue();
    private static final int MAX_NUMBER = ConditionSetting.MAX_NUMBER.getValue();

    private static final String NOT_NUMBER = "[ERROR] 숫자를 입력해주세요";
    private static final String NOT_CONDITIONAL_NUMBER = "[ERROR] 숫자는 " + MIN_NUMBER + " ~ " + MAX_NUMBER + "사이어야 합니다.";
    private static final String DUPLICATED_NUMBER = "[ERROR] 번호가 중복되었습니다.";

    public void validate(String bonusNumber, Lotto lotto) {
        word(bonusNumber);
        conditionalNumber(bonusNumber);
        duplicated(bonusNumber, lotto);
    }

    public void word(String bonusNumber) {
        int idx = 0;
        if (bonusNumber.charAt(idx) == '-') {
            idx++;
        }
        if (bonusNumber.charAt(idx) < 48 || bonusNumber.charAt(idx) > 57) {
            throw new IllegalArgumentException(NOT_NUMBER);
        }
    }

    private void conditionalNumber(String bonusNumber) {
        if (Integer.parseInt(bonusNumber) < 1 || Integer.parseInt(bonusNumber) > 45) {
            throw new IllegalArgumentException(NOT_CONDITIONAL_NUMBER);
        }
    }

    private void duplicated(String bonusNumber, Lotto winningLotto) {
        List<Integer> numbers = winningLotto.getNumbers();
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == Integer.parseInt(bonusNumber)) {
                throw new IllegalArgumentException(DUPLICATED_NUMBER);
            }
        }
    }

}
