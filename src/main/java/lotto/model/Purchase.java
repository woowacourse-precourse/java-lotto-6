package lotto.model;

public class Purchase {

    private static final int PURCHASE_MONEY_UNIT = 1000;
    public static final int ZERO = 0;

    public static final String ERROR_NOT_BIGGER_THAN_ZERO = "[ERROR] 구입금액은 0보다 큰 숫자여야 합니다.";
    public static final String ERROR_NOT_MULTIPLE_OF_1000 = "[ERROR] 구입금액은 1000원 단위로 입력해야 합니다.";

    private final int lottoAmount;

    public Purchase(int purchaseMoney) {
        validate(purchaseMoney);

        this.lottoAmount = purchaseMoney / PURCHASE_MONEY_UNIT;
    }

    private void validate(int purchaseMoney) {
        validateBiggerThanZero(purchaseMoney);
        validateMultipleOf1000(purchaseMoney);
    }

    private void validateBiggerThanZero(int purchaseMoney) {
        if (purchaseMoney <= ZERO) {
            throw new IllegalArgumentException(ERROR_NOT_BIGGER_THAN_ZERO);
        }
    }

    private void validateMultipleOf1000(int purchaseMoney) {
        if (purchaseMoney % PURCHASE_MONEY_UNIT != 0) {
            throw new IllegalArgumentException(ERROR_NOT_MULTIPLE_OF_1000);
        }
    }

    public int getLottoAmount() {
        return lottoAmount;
    }
}