package lotto.domain.constant;

public abstract class ErrorConst {

    public static final String LOTTO_OUT_OF_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String LOTTO_COUNT_NOT_SIX = "[ERROR] 로또 번호는 총 6개여야 합니다.";
    public static final String LOTTO_HAS_DUPLICATE = "[ERROR] 로또 번호에 중복이 있으면 안됩니다.";

    public static final String PRICE_LESS_THAN_THOUSAND = "[ERROR] 구입 금액은 1000원 이상이어야 합니다.";
    public static final String PRICE_NOT_DIVIDED_BY_THOUSAND = "[ERROR] 구입 금액은 1000의 배수여야 합니다.";

    public static final String WINNING_HAS_DUPLICATE = "[ERROR] 당첨 번호와 보너스 번호 사이에 중복이 있으면 안됩니다.";
}
