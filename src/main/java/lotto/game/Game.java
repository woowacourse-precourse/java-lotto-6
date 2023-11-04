package lotto.game;

import lotto.domain.LottoBundle;
import lotto.global.Store;
import lotto.ui.Input;
import lotto.ui.Output;

public class Game {
    public void run() {
        int count = Store.convertPriceToCount(Input.getPurchasePrice());
        Output.printPurchaseCount(count);
        LottoBundle lottoBundle = Store.generateLottoBundle(count);
        Output.printLottoBundle(lottoBundle);
    }
}
