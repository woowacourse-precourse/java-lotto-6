package lotto.view;

import lotto.config.LottoConstants;

public class Messages {
    public static final String ENTER_PURCHASE_AMOUNT = "구입금액을 입력해 주세요: ";
    public static final String PURCHASE_COUNT_MESSAGE = "%d개를 구매했습니다.";
    public static final String LOTTO_NUMBERS_HEADER = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    public static final String WINNING_STATISTICS_HEADER = "당첨 통계\n---";
    public static final String WINNING_MESSAGE_FORMAT = "%s (%s원) - %d개";
    public static final String TOTAL_PROFIT_MESSAGE_FORMAT = "총 수익률은 %.1f%%입니다.";

    public static final String LOTTO_NUMBER_OUT_OF_RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는"
            + LottoConstants.LOTTO_MIN_NUMBER
            +"부터 "+ LottoConstants.LOTTO_MAX_NUMBER +" 사이의 숫자여야 합니다.";
    public static final String LOTTO_NUMBER_SIZE_ERROR_MESSAGE = "[ERROR] 로또는 총 " + LottoConstants.LOTTO_SIZE + "개의 숫자여야 합니다.";
    public static final String LOTTO_STATE_ERROR_MESSAGE = "[ERROR] 숫자를 입력해 주세요.";
    public static final String LOTTO_BONUS_DUPLICATE_MESSAGE = "[ERROR] 보너스 번호는 이미 당첨 번호에 포함되어 있습니다.";
    public static final String LOTTO_PRICE_ERROR_MESSAGE = "[ERROR] 로또 구입 금액은 로또 금액보다 높아야 합니다.";
    public static final String LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE = "[ERROR] 로또 번호는 서로 중복일 수 없습니다.";
}
