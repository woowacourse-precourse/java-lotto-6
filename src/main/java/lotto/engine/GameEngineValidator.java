package lotto.engine;

public class GameEngineValidator {
    private static final String NOT_NUMBER_EXCEPTION_MESSAGE = "%s는 숫자가 아닙니다.";
    private static final String NOT_POSITIVE_NUMBER_EXCEPTION_MESSAGE = "%s는 양수가 아닙니다.";
    private static final String NOT_THOUSAND_RATIO_NUMBER_EXCEPTION_MESSAGE = "%s는 천의 배수가 아닙니다.";
    private static final Long THOUSAND = 1_000L;
    private static final Long ZERO = 0L;

    void checkPrice(String price) {
        checkIsNumber(price);
        checkIsPositive(Long.parseLong(price));
        checkIsThousandRatio(Long.parseLong(price));
    }

    private void checkIsNumber(String price) {
        try {
            Long.parseLong(price);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(NOT_NUMBER_EXCEPTION_MESSAGE, price));
        }
    }

    private void checkIsPositive(Long number) {
        if (number <= ZERO) {
            throw new IllegalArgumentException(String.format(NOT_POSITIVE_NUMBER_EXCEPTION_MESSAGE, number));
        }
    }

    private void checkIsThousandRatio(Long number) {
        if (number % THOUSAND != 0) {
            throw new IllegalArgumentException(String.format(NOT_THOUSAND_RATIO_NUMBER_EXCEPTION_MESSAGE, number));
        }
    }
}
