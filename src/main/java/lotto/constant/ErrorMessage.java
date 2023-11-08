package lotto.constant;

import static lotto.constant.Config.*;

public class ErrorMessage {
    public static final String PREFIX = "[ERROR] ";

    public static final String PRICE_NOT_NUMERIC = "금액은 숫자 형식 이어야 합니다.";
    public static final String PRICE_NEGATIVE = "금액은 0 또는 양수 이어야 합니다.";
    public static final String PRICE_NOT_DIVIDED = String.format("금액은 %d으로 나누어 떨어져야 합니다.", PRICE_PER_LOTTO);

    public static final String LOTTO_NOT_NUMERIC = "로또 번호는 숫자 형식 이어야 합니다.";
    public static final String LOTTO_DUPLICATED = "중복된 로또 번호가 존재합니다.";
    public static final String LOTTO_COUNT_NOT_MATCHED = String.format("로또 번호가 %d개가 아닙니다.", LOTTO_COUNT);
    public static final String LOTTO_NOT_IN_RANGE = String.format("로또 번호는 %d부터 %d 사이의 숫자여야 합니다.", LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX);
    public static final String LOTTO_NOT_ASCENDING = "로또 번호가 오름차순으로 정렬되지 않았습니다.";

    public static final String BONUS_DUPLICATED = "보너스 번호는 당첨 번호에 포함 되어있지 않아야 합니다.";
}
