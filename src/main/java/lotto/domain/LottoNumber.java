package lotto.domain;

public class LottoNumber {

    private static final String prefix = "[ERROR]";
    private static final String MIN_MONEY_ERROR = "최소 입력 금액은 1,000원 입니다.";
    private static final String DIVISION_MONEY_ERROR = "입력 금액은 1,000원 단위로 입력 해야 합니다.";
    private static final int LOTTO_PRICE = 1000;
    private long lottoNumber;
    public LottoNumber(long money) {
        validateMoney(money);
        this.lottoNumber = money / LOTTO_PRICE;
    }

    public static void validateMoney(long money) {
        validateMinMoney(money);
        validateDivisionMoney(money);
    }

    private static void validateMinMoney(long money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException(prefix + MIN_MONEY_ERROR);
        }
    }

    private static void validateDivisionMoney(long money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(prefix + DIVISION_MONEY_ERROR);
        }
    }
    public long getLottoNumber() {
        return lottoNumber;
    }
}
