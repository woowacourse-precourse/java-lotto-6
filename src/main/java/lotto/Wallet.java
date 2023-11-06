package lotto;

public class Wallet {

    private static final int MIN_AMOUNT_OF_LOTTO = LottoConstant.MIN_AMOUNT_OF_LOTTO.getPrice();
    private static final int MAX_AMOUNT_OF_LOTTO = LottoConstant.MAX_AMOUNT_OF_LOTTO.getPrice();

    private int balance = 0;

    public int getBalance() {
        return balance;
    }

    void addBalance(int money) {
        validateNumber(money);
        this.balance += money;
    }

    private void validateNumber(int number) {
        validateNumberByMultiplesOfThousand(number);
        validateNumberRange(number);
    }

    private void validateNumberByMultiplesOfThousand(int number) {
        if (number % MIN_AMOUNT_OF_LOTTO != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000 원 단위어야 합니다.");
        }
    }

    private void validateNumberRange(int number) {
        if (number < MIN_AMOUNT_OF_LOTTO || number > MAX_AMOUNT_OF_LOTTO) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000 ~ 100,000 원 이어야 합니다.");
        }
    }
}
