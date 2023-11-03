package lotto.domain;

public class Consumer {

    private final int amount;
    private final int lottoCount;

    public Consumer(int amount) {
        this.amount = amount;
        this.lottoCount = amount / 1000;
    }

    public int getAmount() {
        return amount;
    }

    public int getLottoCount() {
        return lottoCount;
    }
}
