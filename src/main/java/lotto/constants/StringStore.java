package lotto.constants;

public class StringStore {
    public static final String PURCHASE_START = "구입금액을 입력해 주세요.";
    public static final String PURCHASE = "개를 구매했습니다.";
    public static final String WINNER_NUMBERS_REQUEST = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_REQUEST = "보너스 번호를 입력해 주세요.";
    public static final String THREE_MATCHES = "3개 일치 (5,000원) - ";
    public static final String FOUR_MATCHES = "4개 일치 (50,000원) - ";
    public static final String FIVE_MATCHES_NO_BONUS = "5개 일치 (1,500,000원) - ";
    public static final String FIVE_MATCHES_BONUS = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    public static final String SIX_MATCHES = "6개 일치 (2,000,000,000원) - ";

    public static final String STATISTICS = "당첨 통계\n---";
    public static final String[] LOTTO_RANK = {SIX_MATCHES,FIVE_MATCHES_BONUS,FIVE_MATCHES_NO_BONUS,FOUR_MATCHES,THREE_MATCHES};
    public static final String INPUT_NUMBER_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    public static final String INPUT_PRICE_ERROR_MESSAGE = "[ERROR] 구매 금액은 숫자여야 합니다.";
}
