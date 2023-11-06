package lotto.Constant;

public class Const {
    public static final String PLZ_INPUT_PURCHASE_LOTTO_PRICE = "구매금액을 입력해주세요.";
    public static final String USER_PURCHASE_LOTTO_AMOUNT = "개를 구매했습니다.";

    public static final String PLZ_INPUT_WINNING_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
    public static final String PLZ_INPUT_BONUS_LOTTO_NUMBER = "보너스 번호를 입력해 주세요.";
    public static final String LOTTO_WINNING_RESULT_STATISTICS = "당첨 통계\n---";

    public static final String EXCEPTION_ERROR = "[ERROR] 입력은 숫자로만 이뤄져야 합니다.";
    public static final String EXCEPTION_ERROR_NOT_AVAILABLE = "[ERROR] 입력한 숫자는 1000의 배수여야 합니다.";
    public static final String EXCEPTION_NUMBER_ERROR = "[ERROR] 숫자는" + LottoNumber.NUMBER_COUNT.getLottoNumber() + "를 넘을 수 없습니다.";
    public static final String EXCEPTION_NUMBER_MULTIPLE_ERROR = "[ERROR] 숫자는 중복될 수 없습니다.";

}
