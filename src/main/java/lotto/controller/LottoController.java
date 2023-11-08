package lotto.controller;

import lotto.domain.Lotto;

import java.util.List;

import static lotto.view.OutputView.*;

public class LottoController {

    public static void printGenerateLotto(int purchaseLottoCnt, List<Lotto> purchaseLottos) {
        printEmptyLine();
        printLottoCnt(purchaseLottoCnt);

        for (Lotto lotto : purchaseLottos) {
            printLottoNumbers(lotto);
        }
    }

}
