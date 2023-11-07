package lotto.constant;

public class LottoConstant {
    public static final int LOTTO_NUMBER_SIZE = 6;
    public static final int LOTTO_START_RANGE = 1;
    public static final int LOTTO_END_RANGE = 45;
    public static final int AMOUNT_UNIT = 1000;
    public static final int ZERO = 0;
    public static final String REGEX_INPUT_FORMAT = "^[0-9,]+$";
    public static final String LOTTO_WINNING_STATICS_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개";
    public static final String LOTTO_WINNING_STATICS_RESULT_MESSAGE = "%d개 일치 (%,d원) - %d개";
    public static final String DELIMITER = ",";

    private LottoConstant() {
    }
}
