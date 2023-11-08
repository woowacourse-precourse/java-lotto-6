package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;
import lotto.view.InputView;

public class LottoController {
    private Lottos lottos;
    private LottoService lottoService = LottoServiceImpl.getInstance();

    public void run() {
        buyLottos();
    }

    private void buyLottos() {
        while (true) {
            try {
                lottos = lottoService.buyLottos(InputView.inputPayment());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
