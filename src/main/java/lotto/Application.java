package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoStoreController;

public class Application {
    public static void main(String[] args) {
        try {
            LottoStoreController lottoStore = LottoStoreController.getLottoStore();
            lottoStore.open();
        } catch (IllegalArgumentException e) {
            throw e;
        } finally {
            Console.close();
        }
    }
}
