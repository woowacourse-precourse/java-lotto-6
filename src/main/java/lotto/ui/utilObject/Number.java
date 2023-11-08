package lotto.ui.utilObject;

public class Number {

    private static final Integer MAX_NUMBER_DIGITS = 9;

    private final Integer numericValue;

    public Number(String inputValue) {
        validateEmpty(inputValue);
        validateDigit(inputValue);
        validateLength(inputValue);

        Integer numericValue = convertToInteger(inputValue);
        this.numericValue = numericValue;
    }

    private Integer convertToInteger(String inputValue) {
        return Integer.parseInt(inputValue);
    }

    public void validateEmpty(String inputValue) {
        if (isBlank(inputValue)) {
            throw new IllegalArgumentException("[ERROR] 공백을 입력할 수 없습니다.");
        }
    }

    private void validateDigit(String inputValue) {
        if (!isNumber(inputValue)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    private void validateLength(String inputValue) {
        if (!isNumberWithinNineDigits(inputValue)) {
            throw new IllegalArgumentException("[ERROR] 9자리 숫자까지 입력 가능합니다.");
        }
    }

    private boolean isBlank(String inputValue) {
        return inputValue == null || inputValue.isBlank();
    }

    private boolean isNumberWithinNineDigits(String inputValue) {
        return isNumber(inputValue) && inputValue.length() <= MAX_NUMBER_DIGITS;
    }

    private boolean isNumber(String inputValue) {
        return inputValue.chars().allMatch(Character::isDigit);
    }

    public Integer getNumericValue() {
        return numericValue;
    }
}
