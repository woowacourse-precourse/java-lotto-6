package lotto.controller;

import static lotto.view.InputView.inputBonusNumber;
import static lotto.view.InputView.inputPayment;
import static lotto.view.InputView.inputWinningNumbers;
import static lotto.view.OutputView.printBuyLottoCount;

import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;

public class LottoController {
    private Lottos lottos;
    private WinningLotto winningLotto = winningLotto = new WinningLotto();
    private LottoService lottoService = LottoServiceImpl.getInstance();

    public void run() {
        buyLottos();
        drawWinningNumbers();
        drawBonusNumber();
//        calculateLotto();
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
        printBuyLottoCount(lottos.getLottoCount());
    }

    private void drawWinningNumbers() {
        while (true) {
            try {
                winningLotto.setWinningLotto(lottoService.drawWinningNumbers(inputWinningNumbers()));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void drawBonusNumber() {
        while (true) {
            try {
                winningLotto.setBonusNumber(lottoService.drawBonusNumber(inputBonusNumber()));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
