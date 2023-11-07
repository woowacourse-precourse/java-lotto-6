package lotto.domain;

public class Deposit {

    private final int deposit;
    public static String DEPOSIT_UNIT_EXCEPTION = "금액은 1000원 단위로 입력해주세요.";

    public Deposit(int deposit) {
        if (deposit % 1000 != 0) {
            throw new IllegalArgumentException(DEPOSIT_UNIT_EXCEPTION);
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
