package lotto.domain;

public class User {

    private static final int LOTTO_PRICE = 1000;
    private static final int MAX_LOTTO_PURCHASE_AMOUNT = 1000000000;
    private static final int ZERO_VALUE = 0;
    private static final String PURCHASE_AMOUNT_WRONG_RANGE_EXCEPTION_MESSAGE = "구입 금액은 1000원 이상, 10억원 이하입니다";
    private static final String PURCHASE_AMOUNT_WRONG_UNIT_EXCEPTION_MESSAGE = "구입 금액은 1000원 단위여야 합니다";

    private int balance;
    private int lottoCount;

    public User(int balance) {
        validateBalance(balance);
        this.balance = balance;
        this.lottoCount = balance / LOTTO_PRICE;
    }

    private void validateBalance(int balance) {
        validateCorrectRange(balance);
        validateThousandUnit(balance);
    }

    private void validateCorrectRange(int balance) {
        if(balance < LOTTO_PRICE || balance > MAX_LOTTO_PURCHASE_AMOUNT){
            throw new IllegalArgumentException(PURCHASE_AMOUNT_WRONG_RANGE_EXCEPTION_MESSAGE);
        }
    }

    private void validateThousandUnit(int balance) {
        if(balance % LOTTO_PRICE != ZERO_VALUE){
            throw new IllegalArgumentException(PURCHASE_AMOUNT_WRONG_UNIT_EXCEPTION_MESSAGE);
        }
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public int getBalance() {
        return balance;
    }
}
