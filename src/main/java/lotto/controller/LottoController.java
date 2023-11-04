package lotto.controller;

import lotto.domain.GenerateLotto;
import lotto.domain.Lotto;
import lotto.domain.PurchaseLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    public static void run() {
        try {
            int lottoCount = getPurChaseAmount();
            System.out.println("\n" + lottoCount + OutputView.printPurchaseLottoCount());
            printLottoTickets(lottoCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            run();
        }
    }

    private static int getPurChaseAmount() {
        OutputView.printInputPurchaseAmount();
        String lottoCount = InputView.inputPurchaseAmount();
        return PurchaseLotto.getLottoCount(lottoCount);
    }

    private static void printLottoTickets(int lottoCount) {
        List<Lotto> lottos = GenerateLotto.generateLottoGroup(lottoCount);

        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
