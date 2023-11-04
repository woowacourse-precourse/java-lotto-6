package lotto.constant;

public class ErrorMessage {
    public static final String EMPTY_PURCHASE_AMOUNT = "[ERROR] 빈 구입 금액은 불가능합니다.";
    public static final String NOT_NUMBER_PURCHASE_AMOUNT = "[ERROR] 구입금액은 숫자만 입력 가능합니다.";
    public static final String NEGATIVE_PURCHASE_AMOUNT = "[ERROR] 구입금액에 음수는 불가능합니다.";
    public static final String UNDER_1000_PURCHASE_AMOUNT = "[ERROR] 로또 1장의 가격은 1,000원입니다. 구입이 불가능합니다.";
    public static final String NOT_1000_UNIT_PURCHASE_AMOUNT = "[ERROR] 구입금액은 1,000원 단위로 입력 가능합니다.";

    public static final String NOT_NUMBER_WINNING_NUMBER = "[ERROR] 당첨 번호는 (빈)문자가 아닌 숫자여야 합니다.";
}
