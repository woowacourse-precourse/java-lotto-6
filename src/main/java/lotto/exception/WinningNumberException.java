package lotto.exception;

import java.util.HashSet;
import java.util.Set;
import lotto.type.ConditionSetting;

public class WinningNumberException {

    private static final int MIN_NUMBER = ConditionSetting.MIN_NUMBER.getValue();
    private static final int MAX_NUMBER = ConditionSetting.MAX_NUMBER.getValue();
    private static final int COUNT = ConditionSetting.COUNT.getValue();

    private static final String NOT_NUMBER = "[ERROR] 숫자를 입력해주세요";
    private static final String NOT_CONDITIONAL_NUMBER = "[ERROR] 숫자는 " + MIN_NUMBER + " ~ " + MAX_NUMBER + "사이어야 합니다.";
    private static final String DUPLICATED_NUMBER = "[ERROR] 번호가 중복되었습니다.";
    private static final String NOT_CONDITIONAL_COUNT = "[ERROR] 번호는 " + COUNT + "개 입력해야합니다.";

    public void validate(String[] inputNumbers) {
        count(inputNumbers);
        word(inputNumbers);
        conditionalNumber(inputNumbers);
        duplicated(inputNumbers);
    }

    private void count(String[] inputNumbers) {
        if (inputNumbers.length != COUNT) {
            throw new IllegalArgumentException(NOT_CONDITIONAL_COUNT);
        }
    }

    public void word(String[] inputNumbers) {
        for (int i = 0; i < inputNumbers.length; i++) {
            int idx = 0;
            if (inputNumbers[i].charAt(idx) == '-') {
                idx++;
            }
            if (inputNumbers[i].charAt(idx) < 48 || inputNumbers[i].charAt(idx) > 57) {
                throw new IllegalArgumentException(NOT_NUMBER);
            }
        }
    }

    private void conditionalNumber(String[] inputNumbers) {
        for (int i = 0; i < inputNumbers.length; i++) {
            int num = Integer.parseInt(inputNumbers[i]);
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException(NOT_CONDITIONAL_NUMBER);
            }
        }
    }

    private void duplicated(String[] inputNumbers) {
        Set<String> nums = new HashSet<>();
        for (int i = 0; i < inputNumbers.length; i++) {
            nums.add(inputNumbers[i]);
        }
        if (nums.size() != inputNumbers.length) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER);
        }
    }

}
