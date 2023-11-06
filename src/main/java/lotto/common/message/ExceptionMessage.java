package lotto.common.message;

public class ExceptionMessage {
    public static final String NON_NUMBER_CHECK = "[ERROR] 로또 금액은 숫자만 입력 가능합니다.";
    public static final String ZERO_CHECK = "[ERROR] 로또 구입 금액은 0원을 입력할 수 없습니다.";
    public static final String START_ZERO_CHECK = "[ERROR] 로또 금액은 0으로 시작할 수 없습니다";

    private ExceptionMessage() {
    }
}
