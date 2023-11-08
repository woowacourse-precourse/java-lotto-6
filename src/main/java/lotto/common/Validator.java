package lotto.common;


import static lotto.engine.LottoSystemConstant.TextMessage.ERROR_PREFIX;

public class Validator {
    public void verifyNullAndBlank(String s) {
        if (s == null || s.isBlank()) {
            throw new IllegalArgumentException(ERROR_PREFIX.getMessage() + "공백혹은 빈 문자열은 허용하지 않습니다.");
        }

        s.chars().filter(Character::isWhitespace)
                .findAny().ifPresent((character) -> {
                    throw new IllegalArgumentException(ERROR_PREFIX.getMessage() + "공백이 포함될 수 없습니다.");
                });
    }

    public void verifyInRangeClosed(int start, int end, int value) {
        if (value < start || value > end) {
            throw new IllegalArgumentException(ERROR_PREFIX.getMessage() + "범위안에 속하지 않습니다.");
        }
    }

    public void verifyDivisible(Integer target, Integer unit) {
        if (target % unit != 0) {
            throw new IllegalArgumentException(ERROR_PREFIX.getMessage() + "나누어지지 않는 단위 이거나 또는 대상이 잘못 입력되었습니다.");
        }
    }

    public void verifyNumber(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ERROR_PREFIX.getMessage() + "숫자형식이 아닙니다.");
        }
    }
}
