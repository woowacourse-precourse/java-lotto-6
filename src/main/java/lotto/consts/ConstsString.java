package lotto.consts;

import java.math.BigDecimal;

public class ConstsString {
    public static final String INPUT_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    public static final String INPUT_WIN_NUMBER = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public static final String MATCH_FORMAT = "%d개 일치%s (%s원) - %d개\n";
    public static final String BONUS_CHECK = ", 보너스 볼 일치";
    public static final String MISS = "MISS";
    public static final String EMPTY = "";
    public static final String PRIZE_FORMAT = "%,d";

    public static final int SCALE = 4;
    public static final int FINAL_SCALE = 1;
    public static final int ZERO_TICKET = 0;
    public static final BigDecimal HUNDRED = new BigDecimal(100);

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int LOTTO_NUMBERS = 6;
    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int INITIAL_MATCH_COUNT = 0;
    public static final int TICKET_PRICE = 1000;
    public static final String DELIMETER =",";
    public static final String TICKET_COUNT = "%d개를 구매했습니다.";

}
