package lotto.controller;

import lotto.domain.LottoService;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.NumberCandidateString;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        LottoService lottoService = initLottoService();
        String winningNumber = InputView.receiveWinningNumber();

    }

    private LottoService initLottoService() {
        NumberCandidateString numberCandidateString = new NumberCandidateString(InputView.collectionOfMoney());
        Money money = Money.of(numberCandidateString.getNumber());

        Lottos lottos = Lottos.from(money.calcBillCount());
        LottoService service = new LottoService(lottos);

        OutputView.printPurchaseHistory(lottos.getList());
        return service;
    }

}
