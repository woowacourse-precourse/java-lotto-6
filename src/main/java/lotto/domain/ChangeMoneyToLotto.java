package lotto.domain;

public class ChangeMoneyToLotto {

    private final static int DIVIDE_BY_1000_UNITS = 1000;
    public static int purchaseMoney;

    public int changeMoneyToLotto(String purchaseAmount) {
        purchaseMoney = Integer.parseInt(purchaseAmount);
        return purchaseMoney / DIVIDE_BY_1000_UNITS;
    }
}
