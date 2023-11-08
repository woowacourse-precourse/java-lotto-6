package lotto.error;

import lotto.domain.Lotto;

public class ErrorMessage {
    public static final String INVALID_RANGE = "[ERROR] 로또 번호는 1에서 45 사이의 숫자입니다";
    public static final String INVALID_LENGTH = "[ERROR] 로또 번호는 6개 입력해야 합니다.";
    public static final String INVALID_LOTTO_NUMBERS = "[ERROR] 중복된 로또 번호가 있습니다.";
    public static final String INVALID_BONUS_NUMBERS = "[ERROR] 보너스 번호가 중복됩니다.";

    public static final String INVALID_NUMBER_INPUT= "[ERROR] 올바른 번호를 입력해주세요.";

    public static final String NOT_POSITIVE = "[ERROR] 양수를 입력해주세요";
    public static final String NOT_DIVISIBLE_BY_PRICE = "[ERROR] "+ Lotto.PRICE +"의 배수를 입력해주세요";
    public static final String NOT_NUMERIC = "[ERROR] 숫자를 입력해주세요";
}
