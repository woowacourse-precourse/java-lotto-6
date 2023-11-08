package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.enums.ErrorMessages;
import lotto.enums.GlobalConstant;

public class InputValidator {
    private static final int REMAINDER_CRITERION = 0;
    private static final String regEx = "^[0-9]*$";
    private static final String SEPARATOR = ",";

    public void validateMoney(String price) {
        validateInputEmpty(price);
        validateInputBlank(price);
        validateNonNumberInput(price);
        validatePriceDivideBy1000(price);
    }

    public void validateHitNumbers(String answer) {
        validateInputEmpty(answer);
        validateInputBlank(answer);
        validateInputForm(answer);

        List<String> splitAnswer = convertStringToList(answer);
        for (String element : splitAnswer) {
            validateNonNumberInput(element);
        }
    }

    public void validateBonusNumber(String input) {
        validateInputEmpty(input);
        validateInputBlank(input);
        validateNonNumberInput(input);
    }

    // 공통 검증 사항 시작
    private void validateInputEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_EMPTY_EXCEPTION_MSG.getMsg());
        }
    }

    private void validateInputBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_BLANK_EXCEPTION_MSG.getMsg());
        }
    }

    private void validateNonNumberInput(String input) {
        if (!input.matches(regEx)) {
            throw new IllegalArgumentException(ErrorMessages.NON_NUMBER_EXCEPTION_MSG.getMsg());
        }
    }
    // 공통 검증 사항 종료

    // 로또 구입 금액에 대한 검증 사항 시작
    private void validatePriceDivideBy1000(String input) {
        int price = Integer.parseInt(input);
        if (price % GlobalConstant.DIVIDE_NUMBER.getValue() != REMAINDER_CRITERION) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_DIVIDE_EXCEPTION_MSG.getMsg());
        }
    }
    // 로또 구입 금액에 대한 검증 사항 종료

    // 당첨 번호와 보너스 번호에 대한 공통 검증 사항 시작
    public static void validateNumberInRange(int number) {
        if (number < GlobalConstant.LOTTO_NUMBER_MIN.getValue() || number > GlobalConstant.LOTTO_NUMBER_MAX.getValue()) {
            throw new IllegalArgumentException(ErrorMessages.NUMBER_RANGE_EXCEPTION_MSG.getMsg());
        }
    }
    // 당첨 번호와 보너스 번호에 대한 공통 검증 사항 종료

    // 당첨 번호에 대한 검증 사항 시작
    private void validateInputForm(String input) {
        if (!input.contains(SEPARATOR)) {
            throw new IllegalArgumentException(ErrorMessages.ANSWER_FORM_EXCEPTION_MSG.getMsg());
        }
    }
    // 당첨 번호에 대한 검증 사항 종료

    private List<String> convertStringToList(String answer) {
        return Arrays.stream(answer.split(SEPARATOR))
                .collect(Collectors.toList());
    }
}
