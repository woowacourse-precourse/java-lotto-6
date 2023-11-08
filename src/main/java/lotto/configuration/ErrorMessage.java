package lotto.configuration;

import static lotto.configuration.GameConfig.*;

public class ErrorMessage {
    public static final String EXCESS_NUMBER_OF_LOTTOS = "로또 번호는 "
            + NUMBER_OF_LOTTO_NUMBERS
            + "개여야 합니다.";
    public static final String LOTTO_NUMBER_DUPLICATION = "로또 번호에는 중복이 존재할 수 없습니다.";
    public static final String LOTTO_NUMBER_OUT_OF_RANGE = LOTTO_NUMBER_LOWER_BOUND
            + "에서 "
            + LOTTO_NUMBER_UPPER_BOUND
            + " 사이의 정수를 입력해주십시오.";
    public static final String PURCHASE_UNIT = "구입 금액의 최소 단위는 "
            + PURCHASE_MONEY_UNIT
            + "원입니다.";
    public static final String NOT_INTEGER = "입력은 정수여야합니다.";
    public static final String BONUS_NUMBER_DUPLICATION = "당첨 번호가 보너스 번호를 포함하고 있습니다.";
}
