package lotto;

public class LottoTicket {
    private final int amount;

    public LottoTicket(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(); // 로또 구입금액은 1000원 단위로 나뉘어 떨어져야 합니다.
        }
    }
}
