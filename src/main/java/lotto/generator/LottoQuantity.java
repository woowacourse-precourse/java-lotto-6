package lotto.generator;

import lotto.io.MoneyReader;

public class LottoQuantity {
    public static int Quantity() {
        int cnt = MoneyReader.money_reader() / 1000;
        return cnt;
    }
}
