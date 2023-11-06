package lotto.constant.message;

public class ErrorMessage {
    private static final String prefix = "[Error] ";
    public static final String DUPLICATE_NUMBER = prefix + "중복되지 않는 번호를 입력해주세요.";
    public static final String INVALID_PURCHASE_AMOUNT = prefix + "%d원 단위의 금액을 입력해주세요.";
    public static final String INVALID_WINNING_NUMBER = prefix + "로또 번호는 %d부터 %d 사이의 숫자여야 합니다.";
    public static final String INVALID_BONUS_NUMBER = prefix + "보너스 번호는 %d부터 %d 사이의 숫자여야 합니다.";

}
