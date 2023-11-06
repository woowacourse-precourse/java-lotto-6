package lotto.constant;

public class ExceptionMessage {
    public static final String INVALID_LOTTO_NUMBER = "[ERROR] 로또 번호는 정수여야 합니다.";
    public static final String OUT_OF_RANGE_LOTTO_NUMBER = "[ERROR] 로또 번호는 1 이상 45 이하의 정수여야 합니다.";
    public static final String DUPLICATED_LOTTO_NUMBER = "[ERROR] 로또 번호에는 중복이 있을 수 없습니다";

    public static final String INVALID_BUYING_PRICE = "[ERROR] 구매 가격은 정수여야 합니다";
    public static final String NEGATIVE_BUYING_PRICE = "[ERROR] 구매 가격은 양의 정수여야 합니다.";
    public static final String BUYING_PRICE_NOT_DIVISIBLE = "[ERROR] 구매 가격은 1000의 배수여야 합니다.";

    public static final String INVALID_BONUS_NUMBER = "[ERROR] 보너스 번호는 정수여야 합니다.";
    public static final String OUT_OF_RANGE_BONUS_NUMBER = "[ERROR] 보너스 번호는 1 이상 45 이하의 정수여야 합니다.";
}
