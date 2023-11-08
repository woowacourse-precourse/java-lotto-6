package lotto.model;

public class PlayerPurchase {
    private static final int Lotto_Price = 1000;
    private final int inputPrice;

    public PlayerPurchase(String amount) {
        int lotto_Price = validateNumber(amount);
//        validateLottoPrice(lotto_Price);
        this.inputPrice = lotto_Price;
    }


    public int calculateLottoCount() {
        return inputPrice / Lotto_Price;
    }

    private static int validateNumber(String amount) throws IllegalArgumentException {
        return Integer.parseInt(amount);
    }


}
