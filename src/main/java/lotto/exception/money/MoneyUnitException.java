package lotto.exception.money;

public class MoneyUnitException extends IllegalArgumentException {
    private static final String THOUSAND_UNIT_ONLY_MSG = "금액은 1,000원 단위로 입력해 주세요.";

    public MoneyUnitException() {
        super(THOUSAND_UNIT_ONLY_MSG);
    }
}
