package lotto.constant;

public class ExceptionMessage {

    public static final String NO_DUPLICATE_WINNING_NUMBER_ERROR_MESSAGE = "당첨 번호와 중복된 보너스 번호는 입력할 수 없습니다.";
    public static final String NO_DUPLICATE_ERROR_MESSAGE = "중복된 숫자는 입력할 수 없습니다.";
    public static final String OUT_OF_RANGE_ERROR_MESSAGE = "1 ~ 45사이의 숫자만 입력할 수 있습니다.";
    public static final String DIVISION_ERROR_MESSAGE = "1000원으로 나눌 수 있는 금액만 입력 가능합니다.";

    private ExceptionMessage() {
    }
}
