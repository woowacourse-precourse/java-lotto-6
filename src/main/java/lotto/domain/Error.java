package lotto.domain;

public class Error {
    public static final String INVALID_NUMBER_INPUT = "숫자만 입력 가능합니다.";
    public static final String INVALID_LOTTO_NUMBER_RANGE = String.format("로또 숫자 범위가 올바르지 않습니다. 숫자는 %d ~ %d 사이의 숫자만 가능합니다.", Lotto.LOTTO_MIN_NUMBER, Lotto.LOTTO_MAX_NUMBER);
    public static final String DUPLICATE_LOTTO_NUMBER = "중복된 로또 숫자는 사용할 수 없습니다.";
    public static final String INVALID_LOTTO_NUMBER_SIZE = String.format("로또 숫자의 개수가 올바르지 않습니다. 숫자는 %d개만 가능합니다.", Lotto.LOTTO_SIZE);
    public static final String INVALID_LOTTO_MONEY = String.format("로또 구입 금액이 올바르지 않습니다. 금액은 %d원 이상만 가능합니다.", Lotto.LOTTO_PRICE);
    public static final String INVALID_LOTTO_MONEY_UNIT = String.format("로또 구입 금액이 올바르지 않습니다. 금액은 %d원 단위로만 가능합니다.", Lotto.LOTTO_PRICE);
}
