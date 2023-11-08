package lotto.constant;

public final class MessageConstants {

    private MessageConstants() {
        throw new AssertionError(CANNOT_INSTANTIATE);
    }

    public static final String ERROR = "[ERROR]: ";
    public static final String CANNOT_INSTANTIATE = "인스턴스화 불가능";
    public static final String ONLY_NUMBER = "숫자만 입력할 수 있습니다.";
    public static final String OVER_MAX = "입력할 수 있는 금액의 최댓값 그 이상입니다.";
    public static final String MONEY_RANGE = "1000 이상, 1000 단위의 금액을 입력하세요.";
    public static final String REQUEST_INPUT_MONEY = "구입금액을 입력해 주세요.";
    public static final String REQUEST_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    public static final String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public static final String PURCHASE_SUCCESS = "개를 구매했습니다.";
    public static final String WINNING_STATISTICS = "당첨 통계";
    public static final String DIVIDER = "---";
    public static final String TOTAL_EARNING_RATE_FORMAT = "총 수익률은 %.1f%%입니다.%n";
    public static final String RANK_COUNT_FORMAT = "%s%d개%n";
    public static final String LOTTO_NUMBER_RANGE = "1 ~ 45 사이의 숫자만 가능합니다.";
    public static final String NUMBER_FORMAT_AND_RANGE = "구분자 ','와 1 ~ 45 숫자 이외는 입력할 수 없습니다.";
    public static final String CANNOT_DUPLICATE_LOTTO_AND_BONUS = "보너스 번호는 로또 번호와 중복될 수 없습니다.";
    public static final String CANNOT_DUPLICATE_LOTTO = "로또 번호는 중복될 수 없습니다.";
    public static final String CANNOT_DUPLICATE = "중복된 당첨 숫자를 입력할 수 없습니다.";
    public static final String LOTTO_COUNT = "로또는 6개여야 합니다.";
    public static final String WINNING_COUNT = "당첨 개수는 6개여야 합니다.";

}
