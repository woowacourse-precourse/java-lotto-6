package lotto.controller;

import lotto.domain.LottoMoney;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public static void run() {
        LottoMoney lottoMoney = getLottoMoney();

        Lottos newlottos = new Lottos(lottoMoney.buyLottos());
        OutputView.printLottoCountMessage(newlottos.getLottoCount());
        OutputView.printLottos(newlottos);
    }

    public static LottoMoney getLottoMoney() {
        try {
            OutputView.printLottoPurchaseMoneyMessage();
            String input = InputView.readLine();
            OutputView.printEmptyLine();
            return new LottoMoney(input);
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e);
            return getLottoMoney();
        }
    }
}
