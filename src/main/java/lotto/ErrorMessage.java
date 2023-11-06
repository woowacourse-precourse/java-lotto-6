package lotto;

import java.text.NumberFormat;

import static lotto.LottoConstants.*;

public class ErrorMessage {
    public static final String NUMBER_PARSING_ERROR_MESSAGE = "[ERROR] 숫자만 입력해주세요.";

    public static final String LOTTO_OVERSIZED_MESSAGE = "[ERROR] 로또 번호는 " + LOTTO_SIZE + "개 입니다.";
    public static final String LOTTO_DUPLICATED_MESSAGE = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    public static final String LOTTO_AND_BONUS_DUPLICATED_MESSAGE = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";
    public static final String LOTTO_PRICE_ERROR_MESSAGE =
            "[ERROR] " + NumberFormat.getInstance().format(LOTTO_PRICE) + "원 단위로 입력해주세요.";
    public static final String LOTTO_OUT_OF_RANGE_MESSAGE =
            "[ERROR] 로또 번호는 " + LOTTO_MIN + "부터 " + LOTTO_MAX + " 사이의 숫자여야 합니다.";

}
