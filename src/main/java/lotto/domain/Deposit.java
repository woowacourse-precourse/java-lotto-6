package lotto.domain;

public class Deposit {

    private final int deposit;

    public Deposit(int deposit) {
        if (deposit % 1000 != 0) {
            throw new IllegalArgumentException("금액은 1000 원 단위이어야 합니다.");
        }
        this.deposit = deposit;
    }

    public int getDeposit() {
        return deposit;
    }

    public int getLottoTicketsCount() {
        return deposit / 1000;
    }
}
