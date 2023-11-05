package lotto;

public class Wallet {

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
        if (number % 1_000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000 원 단위어야 합니다.");
        }
    }

    private void validateNumberRange(int number) {
        if (number < 1_000 || number > 100_000) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000 ~ 100,000 원 이어야 합니다.");
        }
    }

}
