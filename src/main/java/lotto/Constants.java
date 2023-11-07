package lotto;

public class Constants {
    public static final String BUYING_PRICE = "구입금액을 입력해 주세요.";
    public static final String BUYING_COUNT = "개를 구매했습니다.";
    public static final String WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public static final String WINNING_STATISTICS = "당첨 통계\n---";
    public static final String UNIT = "개";
    public static final String RATE_OF_RETURN = "총 수익률은 ";
    public static final String PERCENT = "%입니다.";

    public static Integer MIN_NUMBER = 1;
    public static Integer MAX_NUMBER = 45;
    public static Integer COUNT = 6;
    public static Integer ROUND_UNIT = 2;

    public static final String NUMBER_TYPE_ERROR = "[ERROR] 번호는 숫자만 입력되어야 합니다.";
    public static final String NUMBER_BOUNDARY_ERROR = "[ERROR] 번호는 1~45 범위 내에 해당해야 합니다.";
    public static final String BONUS_DUPLICATION_ERROR = "[ERROR] 보너스 번호는 당첨 번호와 중복되어서는 안 됩니다.";
    public static final String BUYING_PRICE_DIGIT_ERROR = "[ERROR] 구입 금액은 6자리 이하여야 합니다.";
    public static final String BUYING_PRICE_BOUNDARY_ERROR = "[ERROR] 구입 금액은 1000원 이상, 100000원 이하여야 합니다.";
    public static final String BUYING_PRICE_REST_ERROR = "[ERROR] 구입 금액은 1000원 단위여야 합니다.";
    public static final String LOTTO_SIZE_ERROR = "[ERROR] 번호는 6개여야 합니다.";
    public static final String NUMBER_DUPLICATE_ERROR = "[ERROR] 모든 번호는 중복이지 않아야 합니다.";
    public static final String WINNING_NUMBER_TYPE_ERROR = "[ERROR] 당첨 번호는 숫자와 쉼표(,)만이 입력 가능합니다.";


    public static final String SIX_CORRECTNESS_CASE = "6개 일치 (2,000,000,000원) - ";
    public static final String FIVE_AND_BONUS_CORRECTNESS_CASE = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    public static final String FIVE_CORRECTNESS_CASE = "5개 일치 (1,500,000원) - ";
    public static final String FOUR_CORRECTNESS_CASE = "4개 일치 (50,000원) - ";
    public static final String THREE_CORRECTNESS_CASE = "3개 일치 (5,000원) - ";
}
