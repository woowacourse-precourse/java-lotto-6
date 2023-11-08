package lotto.utils;

public class Parser {

    public Integer parseLottoCount(String input) {
        validateCount(input);
        return Integer.valueOf(input) / 1000;
    }

    private void checkEmpty(String input) throws IllegalArgumentException {
        if(input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 빈 값입니다.");
        }
    }

    public void checkDigit(String input) throws IllegalArgumentException {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 입력 금액은 숫자여야합니다.");
        }
    }

    public void checkThousand(int number) throws IllegalArgumentException {
        if((number % 1000) != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 입력 금액은 1000원 단위여야 합니다.");
        }
    }

    public void validateCount(String input) {
        checkEmpty(input);
        checkDigit(input);
        checkThousand(Integer.valueOf(input));
    }
}
