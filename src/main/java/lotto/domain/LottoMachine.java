package lotto.domain;

public class LottoMachine {
    public int getLottoCount(int userMoney) {
        if (userMoney % Lotto.PRICE != 0) {
            throw new IllegalArgumentException("[ERROR]");
        }

        return userMoney / Lotto.PRICE;
    }
}
