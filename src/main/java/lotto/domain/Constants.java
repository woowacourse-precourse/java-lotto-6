package lotto.domain;

public class Constants {
    public static final int LOTTO_NUMBER = 6;
    public static final int ZERO_NUMBER = 0;
    public static final int LOTTO_NUMBER_MIN = 1;
    public static final int LOTTO_NUMBER_MAX = 45;

    public static final String AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String LOTTO_NUMBER_OUTPUT_MESSAGE = "\n%s개를 구매했습니다.\n";
    public static final String WINNING_NUMBER_INPUT_MESSAGE ="\n당첨 번호를 입력해 주세요.\n";
    public static final String BONUS_NUMBER_INPUT_MESSAGE ="\n보너스 번호를 입력해 주세요.\n";
    public static final String TOTAL_PROFIT_OUTPUT_MESSAGE ="총 수익률은 %.1f%%입니다.\n";
    public static final String RESULT_OUTPUT_MESSAGE="\n당첨 통계\n---\n";

    public static final String LOTTO_PRICE_NOT_NUMBER_ERROR = "[ERROR] 로또 구입 금액은 숫자만 입력하세요.\n\n";
    public static final String LOTTO_PRICE_NOT_POSITIVE_ERROR = "[ERROR] 로또 구입 금액은 양수만 입력하세요.\n\n";
    public static final String LOTTO_PRICE_NOT_DIVIDED_ERROR = "[ERROR] 로또 구입 금액은 1000원 단위로 입력하세요.\n\n";

    public static final String WINNING_NUMBER_NOT_VALID_ERROR = "[ERROR] 올바른 로또 입력 형식이 아닙니다.\n";
    public static final String WINNING_NUMBER_NOT_SIX_ERROR = "[ERROR] 로또는 6개의 번호를 입력해야 합니다.\n";
    public static final String WINNING_NUMBER_NOT_NUMBER_ERROR = "[ERROR] 로또 번호는 정수만 입력하세요.\n";
    public static final String WINNING_NUMBER_RANGE_ERROR = "[ERROR] 로또 번호는 1부터 45까지만 입력하세요.\n";
    public static final String WINNING_NUMBER_DUPLICATED_ERROR = "[ERROR] 로또 번호는 중복이 될 수 없습니다.\n";

    public static final String BONUS_NUMBER_NOT_NUMBER_ERROR = "[ERROR] 보너스 번호는 숫자만 입력하세요.\n";
    public static final String BONUS_NUMBER_DUPLICATED_ERROR = "[ERROR] 보너스 숫자는 로또 번호 중복이 될 수 없습니다.\n";
    public static final String BONUS_NUMBER_RANGE_ERROR = "[ERROR] 보너스 번호는 1부터 45까지만 입력하세요.\n";

}
