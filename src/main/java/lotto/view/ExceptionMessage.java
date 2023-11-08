package lotto.view;

public class ExceptionMessage {
    private static final String WRONG_PRICE_MESSAGE = "[ERROR] 금액을 1,000원 단위로 입력해주세요.";
    private static final String WRONG_VALUE_MESSAGE = "[ERROR] 잘못된 값이 입력되었습니다.";
    public static void wrongValueException() {
        System.out.println(WRONG_VALUE_MESSAGE);
    }
    public static void divisionException() {
        System.out.println(WRONG_PRICE_MESSAGE);
    }

}
