package lotto.constant;

public class ErrorMessage {
    public static final String NOT_NUMBER_PURCHASE_AMOUNT = "구입금액은 (빈)문자가 아닌 숫자여야 합니다.";
    public static final String NEGATIVE_PURCHASE_AMOUNT = "구입금액에 음수는 불가능합니다.";
    public static final String UNDER_1000_PURCHASE_AMOUNT = "로또 1장의 가격은 1,000원입니다. 구입이 불가능합니다.";
    public static final String NOT_1000_UNIT_PURCHASE_AMOUNT = "구입금액은 1,000원 단위로 입력 가능합니다.";

    public static final String NOT_NUMBER_WINNING_NUMBER = "당첨 번호는 (빈)문자가 아닌 숫자여야 합니다.";
    public static final String NOT_SIX_COUNT_WINNING_NUMBER = "당첨 번호는 6개여야 합니다.";
    public static final String DUPLICATE_WINNING_NUMBER = "당첨 번호는 중복이 없어야 합니다.";
    public static final String OUT_RANGE_WINNING_NUMBER = "당첨 번호는 1부터 45 사이의 숫자여야 합니다.";

    public static final String NOT_NUMBER_BONUS_NUMBER = "보너스 번호는 (빈)문자가 아닌 숫자여야 합니다.";
    public static final String OVERLAP_BONUS_NUMBER = "보너스 번호는 당첨 번호와 겹쳐서는 안됩니다.";
    public static final String OUT_RANGE_BONUS_NUMBER = "보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
}
