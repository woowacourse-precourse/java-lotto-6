package lotto.util;

public class ErrorMessage {

    public final static String HEAD = "[ERROR] ";
    public final static String NUMBERS_WRONG_SIZE = HEAD + "번호는 6개여야 합니다.";
    public final static String NUMBERS_DUPLICATE = HEAD + "번호는 중복될 수 없습니다.";
    public final static String NUMBER_WRONG_RANGE = HEAD + "번호는 1이상 45이하 자연수여야 합니다.";
    public final static String NUMBER_WRONG_FORMAT = HEAD + "숫자는 자연수여야 합니다.";
    public final static String BONUS_AND_WINNING_DUPLICATE = HEAD + "당첨 번호와 중복될 수 없습니다.";
    public final static String MONEY_WRONG_UNIT = HEAD + "금액은 1000원 단위여야 합니다.";

    private ErrorMessage() {
    }
}
