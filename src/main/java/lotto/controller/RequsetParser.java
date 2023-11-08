package lotto.controller;

public class RequsetParser {
    public static int requestPurchase() {
        private static final String ERROR_MESSAGE = "숫자로 변환할 수 없습니다. 입력: %s";

        try {
            return Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(ERROR_MESSAGE, target), e);
        }
    }
}