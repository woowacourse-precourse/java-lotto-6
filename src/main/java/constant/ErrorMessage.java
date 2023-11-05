package constant;

public class ErrorMessage {
    private static final String ERROR = "[ERROR] ";
    public static final String PURCHASE_TYPE = ERROR + "구매 금액은 숫자로만 이루어져야 합니다.";
    public static final String PURCHASE_REMAINDER = ERROR + "구매 금액은 1000으로 나누어 떨어져야 합니다.";
    public static final String LOTTO_NUMBER_COUNT_SIX = ERROR + "당첨 번호는 6개입니다.";
    public static final String LOTTO_NUMBER_DUPLICATE = ERROR + "당첨 번호는 중복될 수 없습니다.";
    public static final String LOTTO_NUMBER_RANGE = ERROR + "당첨 번호는 1이상 45이하입니다.";
    public static final String BONUS_TYPE = ERROR + "보너스 번호는 숫자로만 이루어져야 합니다.";
}
