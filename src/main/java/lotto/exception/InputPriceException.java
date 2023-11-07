package lotto.exception;

import lotto.util.ParseString;

public class InputPriceException {
    private static final String REG_INPUT = "[0-9]+";
    private static final String ERROR = "[ERROR] ";
    ParseString parse = new ParseString();

    public void validateAll(String price) {
        validateZero(price);
        validateNumber(price);
        validateUnit(price);
    }

    public void validateNumber(String price) {
        if (!isNumber(price)) {
            throw new IllegalArgumentException(ERROR + "숫자만 입력해주세요.");
        }
    }

    public void validateUnit(String price) {
        if (!isDevided(price)) {
            throw new IllegalArgumentException(ERROR + "1000 단위의 금액을 입력해주세요.");
        }
    }

    public void validateZero(String price) {
        if (isZero(price)) {
            throw new IllegalArgumentException(ERROR + "0이 아닌 값을 입력해주세요.");
        }
    }

    public boolean isDevided(String price) {
        return parse.parseToInt(price)%1000 == 0;
    }

    public boolean isNumber(String price) {
        return price.matches(REG_INPUT);
    }

    public boolean isZero(String price) {
        return price.equals("0");
    }
}
