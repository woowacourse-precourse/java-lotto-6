package lotto.model;

public class LottoGameManager {

    public static int calculateLottoCount(Amount amount) {
        return amount.getAmount() / 1000;
    }
}
