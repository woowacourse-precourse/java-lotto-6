package lotto.domain;

public class Constants {
    public static final int LOTTO_NUMBER = 6;
    public static final int ZERO_NUMBER = 0;

    public static final String AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String LOTTO_NUMBER_OUTPUT_MESSAGE = "\n%s개를 구매했습니다.\n";
    public static final String WINNING_NUMBER_INPUT_MESSAGE ="\n당첨 번호를 입력해 주세요.\n";
    public static final String BONUS_NUMBER_INPUT_MESSAGE ="\n보너스 번호를 입력해 주세요.\n";

    public static final String LOTTO_PRICE_NOT_NUMBER_ERROR = "[ERROR] 로또 구입 금액은 숫자만 입력하세요.\n\n";
    public static final String LOTTO_PRICE_NOT_POSITIVE_ERROR = "[ERROR] 로또 구입 금액은 양수만 입력하세요.\n\n";
    public static final String LOTTO_PRICE_NOT_DIVIDED_ERROR = "[ERROR] 로또 구입 금액은 1000원 단위로 입력하세요.\n\n";

    public static final String WINNING_NUMBER_DUPLICATED_ERROR = "[ERROR] 로또 번호는 중복이 될 수 없습니다.";

    public static final String BONUS_NUMBER_DUPLICATED_ERROR = "[ERROR] 보너스 숫자는 로또 번호 중복이 될 수 없습니다.";

}
