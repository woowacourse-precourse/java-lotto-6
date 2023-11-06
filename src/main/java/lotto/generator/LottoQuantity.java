package lotto.generator;

import lotto.io.Read;

public class LottoQuantity {
    public static int Quantity() {
        int cnt = Read.reader() / 1000;
        return cnt;
    }
}
