package lotto;



public class LottoMachine {
    private final int LOTTO_PRICE = 1_000;

    public int calculateLottoQuantity(int amount) {
        return amount / LOTTO_PRICE;
    }
}
