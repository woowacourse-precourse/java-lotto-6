package lotto.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.enums.ErrorMessages;
import lotto.enums.GlobalConstant;

public class InputValidator {
    private static final int REMAINDER_CRITERION = 0;
    private static final String regEx = "^[0-9]*$";
    private static final String SEPARATOR = ",";

    public int validatePrice(String price) {
        validateInputEmpty(price);
        validateInputBlank(price);
        validateNonNumberInput(price);
        validatePriceDivideBy1000(price);

        return Integer.parseInt(price);
    }

    public List<String> validateAnswerNumbers(String answer) {
        validateInputEmpty(answer);
        validateInputBlank(answer);
        validateInputForm(answer);

        List<String> splitAnswer = convertStringToList(answer);
        validateAnswerCount(splitAnswer.size());
        validateAnswerElements(splitAnswer);
        Set<String> duplicateRemovedAnswer = convertListToSet(splitAnswer);
        validateDuplicatedNumber(duplicateRemovedAnswer);

        return splitAnswer;
    }

    public int validateBonusNumber(String input, boolean duplicatedFlag) {
        validateInputEmpty(input);
        validateInputBlank(input);
        validateNonNumberInput(input);

        int convertedNumber = Integer.parseInt(input);
        validateNumberInRange(convertedNumber);
        validateBonusNumberConflictWithAnswer(duplicatedFlag);

        return convertedNumber;
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
    private void validateNumberInRange(int number) {
        if (number < GlobalConstant.NUMBER_MIN.getValue() || number > GlobalConstant.NUMBER_MAX.getValue()) {
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

    private void validateAnswerCount(int numberCount) {
        if (numberCount != GlobalConstant.NUMBER_AMOUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessages.ANSWER_AMOUNT_EXCEPTION_MSG.getMsg());
        }
    }

    private void validateAnswerElements(List<String> splitAnswer) {
        for (String element : splitAnswer) {
            validateNonNumberInput(element);
            validateNumberInRange(Integer.parseInt(element));
        }
    }

    private void validateDuplicatedNumber(Set<String> duplicateRemovedAnswer) {
        if (duplicateRemovedAnswer.size() != GlobalConstant.NUMBER_AMOUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessages.ANSWER_DUPLICATED_EXCEPTION_MSG.getMsg());
        }
    }
    // 당첨 번호에 대한 검증 사항 종료

    // 보너스 번호에 대한 검증 사항 시작
    private void validateBonusNumberConflictWithAnswer(boolean duplicatedFlag) {
        if (duplicatedFlag) {
            throw new IllegalArgumentException(ErrorMessages.BONUS_NUMER_CONFLICT_EXCEPTION_MSG.getMsg());
        }
    }
    // 보너스 번호에 대한 검증 사항 종료

    private List<String> convertStringToList(String answer) {
        return Arrays.stream(answer.split(SEPARATOR))
                .collect(Collectors.toList());
    }

    private Set<String> convertListToSet(List<String> splitAnswer) {
        return new HashSet<>(splitAnswer);
    }
}
