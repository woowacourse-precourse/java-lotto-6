package lotto.domain;

public class BuyLotto {

    public int setPurchasePrice(int inputPrice) {
        return findAmount(inputPrice);
    }

    private int findAmount(int inputPrice) {
        return inputPrice / 1000;
    }
}
