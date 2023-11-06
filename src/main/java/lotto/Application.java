package lotto;

import lotto.core.LottoStore;

public class Application {
    public static void main(String[] args) {
        LottoStore lottoStore = LottoStore.createStore();
        lottoStore.start();
    }
}
