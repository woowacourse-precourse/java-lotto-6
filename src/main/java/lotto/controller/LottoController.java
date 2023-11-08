package lotto.controller;

import static lotto.view.InputView.inputPayment;
import static lotto.view.OutputView.printBuyLottoCount;

import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private Lottos lottos;
    private LottoService lottoService = LottoServiceImpl.getInstance();

    public void run() {
        buyLottos();
        printBuyLottoCount(lottos.getLottoCount());
    }

    private void buyLottos() {
        while (true) {
            try {
                lottos = lottoService.buyLottos(inputPayment());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
