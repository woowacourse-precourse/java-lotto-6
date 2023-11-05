package lotto;

import lotto.core.LottoStore;

public class Application {
    public static void main(String[] args) {
        LottoStore lottoStore = new LottoStore();
        lottoStore.start();
    }
}
