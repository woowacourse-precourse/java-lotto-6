package lotto.validation;

public class PriceInputValidator {
    private static final String NOT_ALONE_EXCEPTION_MESSAGE = "입력값이 한 개가 아닙니다.";
    private static final String NOT_THOUSAND_EXCEPTION_MESSAGE = "입력값을 천 단위로 입력해주세요.";
    private static final String NOT_DIGIT_EXCEPTION_MESSAGE = "입력값이 숫자가 아닙니다.";

    public static void validate(String totalPrice) {
        checkInputOnlyOne(totalPrice);
        checkInputDigit(totalPrice);
        checkInputIsThousand(totalPrice);
    }

    private static void checkInputOnlyOne(String totalPrice) {
        if (totalPrice.trim().chars().filter(ch -> ch == ' ').count() > 0) {
            throw new IllegalArgumentException(NOT_ALONE_EXCEPTION_MESSAGE);
        }
    }

    private static void checkInputDigit(String totalPrice) {
        for (int i = 0; i < totalPrice.length(); i++) {
            if (!Character.isDigit(totalPrice.charAt(i))) {
                throw new IllegalArgumentException(NOT_DIGIT_EXCEPTION_MESSAGE);
            }
        }
    }

    private static void checkInputIsThousand(String totalPrice) {
        if (totalPrice.length() < 4 || Integer.parseInt(totalPrice) % 1000 != 0) {
            throw new IllegalArgumentException(NOT_THOUSAND_EXCEPTION_MESSAGE);
        }
    }

}
