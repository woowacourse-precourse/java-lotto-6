package lotto.validator;

public class InputValidator {
    private boolean isNotInteger(String number) {
        try {
            Integer.parseInt(number);
            return false;
        } catch (NumberFormatException ex) {
            return true;
        }
    }

    public void checkInteger(String number) {
        if(isNotInteger(number)) {
            throw new IllegalArgumentException("[ERROR] 정수를 입력 해야 합니다.");
        }
    }

    private boolean hasBlank(String numbers) {
        return numbers.contains(" ");
    }

    public void checkBlank(String numbers) {
        if(hasBlank(numbers)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 입력에 공백은 허용되지 않습니다.");
        }
    }

    private boolean hasNotOnlyNumberAndDelimiterComma(String numbers) {
        String numbersInputRegex = "([0-9]+,)+[0-9]+";

        return !numbers.matches(numbersInputRegex);
    }

    public void checkOnlyNumberAndDelimiterCommaContain(String numbers) {
        if(hasNotOnlyNumberAndDelimiterComma(numbers)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 입력은 숫자와 ,로만 이루어 져야 합니다.");
        }
    }
}
