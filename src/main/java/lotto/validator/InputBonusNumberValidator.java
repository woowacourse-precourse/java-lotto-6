package lotto.validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputBonusNumberValidator {
    private static final String NON_INPUT_ERROR_MESSAGE = "[ERROR] 입력하지 않으셨습니다. 보너스 번호를 입력해주세요";
    private static final String NON_INTEGER_ERROR_MESSAGE = "[ERROR] 보너스 번호는 숫자만 입력 가능합니다.";
    private static final String NON_NUMBER_SIZE_ONE_ERROR_MESSAGE = "[ERROR] 보너스 번호는 숫자 1개만 입력해주세요 .";
    private static final String WRONG_RANGE_ERROR_MESSAGE = "[ERROR] 보너스 번호는 1부터 45 사이의 정수입니다.";
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    public void validateNonInputBonusNumber(String bonusNumber) {
        if (bonusNumber.equals("")) {
            throw new IllegalArgumentException(NON_INPUT_ERROR_MESSAGE);
        }
    }

    public void validateNonIntegerBonusNumber(String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_INTEGER_ERROR_MESSAGE);
        }
    }

    public void validateNonNumberSizeOne(String bonusNumber) {
        List<Integer> number = Arrays.stream(bonusNumber.split(","))
                .map(Integer::parseInt)
                .toList();

        if (number.size() != 1) {
            throw new IllegalArgumentException(NON_NUMBER_SIZE_ONE_ERROR_MESSAGE);
        }
    }

    public void validateWrongRangeBonusNumber(String bonusNumber) {
        int number = Integer.parseInt(bonusNumber);

        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(WRONG_RANGE_ERROR_MESSAGE);
        }
    }
}
