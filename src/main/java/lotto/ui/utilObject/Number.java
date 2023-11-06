package lotto.ui.utilObject;

public class Number {

    private final Integer numericValue;

    public Number(String inputValue) {
        validate(inputValue);
        Integer numericValue = convertToInteger(inputValue);
        this.numericValue = numericValue;
    }

    private Integer convertToInteger(String inputValue) {
        return Integer.parseInt(inputValue);
    }

    private void validate(String inputValue) {
        if (!isNumber(inputValue)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    private boolean isNumber(String inputValue) {
        return inputValue.chars().allMatch(Character::isDigit);
    }

    public Integer getNumericValue() {
        return numericValue;
    }
}
