package lotto.domain;

public class LottoGameMessage {

    public static final String LOTTO_NUMBER_SIZE_ERROR = "[ERROR] 로또 번호는 6자리를 넘어갈 수 없습니다.";
    public static final String REQUEST_PURCHASE_AMOUNT = "구매 금액을 입력해 주세요.";
    public static final String PURCHASE_COMPLETED_MESSAGE = "개를 구매했습니다.";
    public static final String REQUEST_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String REQUEST_BONUS_NUMBERS = "보너스 번호를 입력해 주세요.";
    public static final String WINNING_STATISTICS = "당첨 통계";
    public static final String RATE_OF_RETURN = "총 수익률은 %s%%입니다.";
    public static final String DUPLICATED_NUMBER_ERROR = "[ERROR] 중복된 숫자가 있습니다.";
    public static final String NOT_VALID_INPUT = "[ERROR] 올바른 입력 값이 아닙니다.";
    public static final String CONTOUR = "---";

    private LottoGameMessage() {}
}
