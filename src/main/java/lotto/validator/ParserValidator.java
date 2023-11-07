package lotto.validator;

import java.util.Arrays;
import java.util.List;

public class ParserValidator {

    private final List<String> splitNumbers;

    public ParserValidator(String input) {
        this.splitNumbers = Arrays.asList(input.split(","));
    }

    public void validateAll() {
        validateSize();
        validateNumberCondition();
        validateUnique();
    }

    private void validateSize() {
        if (isWrongSize()) {
            throw new IllegalArgumentException("당첨 개수는 6개여야 합니다.");
        }
    }

    private boolean isWrongSize() {
        return splitNumbers.size() != 6;
    }

    private void validateNumberCondition() {
        splitNumbers.stream()
                .filter(number -> isNotDigit(number) || isWrongRangeNumber(Integer.parseInt(number)))
                .forEach(number -> {
                    throw new IllegalArgumentException("구분자 ','와 1 ~ 45 숫자 이외는 입력할 수 없습니다.");
                });
    }

    private boolean isNotDigit(String number) {
        return !number.matches("^\\d+$");
    }

    private boolean isWrongRangeNumber(int number) {
        return (number < 1 || number > 45);
    }

    private void validateUnique() {
        if (findUniqueNumberCount() != 6) {
            throw new IllegalArgumentException("중복된 당첨 숫자를 입력할 수 없습니다.");
        }
    }

    private long findUniqueNumberCount() {
        return splitNumbers.stream()
                .distinct()
                .count();
    }

}
