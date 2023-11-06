package lotto;

public class LottoGenerator {
    private final int amount;

    private LottoGenerator(int amount) {
        this.amount = amount;
    }

    public static LottoGenerator from(int amount) {
        if (amount%1000 != 0) {
            throw new IllegalArgumentException();
        }
        return new LottoGenerator(amount);
    }


}
