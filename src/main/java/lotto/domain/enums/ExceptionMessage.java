package lotto.domain.enums;

import static lotto.domain.enums.LottoConstants.LOTTO_SIZE;
import static lotto.domain.enums.LottoConstants.MIN_PLAYER_AMOUNT;

public class ExceptionMessage {
    private static final String ERROR = "[ERROR] ";
    public static final String INPUT_IS_BLANK = ERROR + "빈값을 입력하면 안됩니다.";
    public static final String DUPLICATED_LOTTO_NUMBER = ERROR + "로또번호는 중복되어서 안됩니다.";
    public static final String INVALID_LOTTO_RANGE = ERROR + "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String INVALID_LOTTO_SIZE = String.format(ERROR + "로또의 숫자가 %d개 여야합니다.", LOTTO_SIZE);
    public static final String INVALID_PLAYER_AMOUNT = String.format(ERROR + "구매금액이 %d원 이상이어야 합니다.",
            MIN_PLAYER_AMOUNT);
    public static final String INPUT_NON_NUMBER = ERROR + "입력값이 숫자가 아닙니다.";
    public static final String NON_DIVISIBLE_MESSAGE = ERROR + "나누어 떨어지지 않는 금액입니다.";
}
