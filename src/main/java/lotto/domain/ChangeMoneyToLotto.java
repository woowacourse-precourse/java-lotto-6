package lotto.domain;

public class ChangeMoneyToLotto {

    private final static int DIVIDE_BY_1000_UNITS = 1000;

    public int changeMoneyToLotto(String purchaseAmount) {

        return Integer.parseInt(purchaseAmount) / DIVIDE_BY_1000_UNITS;
    }
}
