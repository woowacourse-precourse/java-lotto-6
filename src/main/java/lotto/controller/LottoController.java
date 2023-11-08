package lotto.controller;

import static lotto.view.InputView.inputBonusNumber;
import static lotto.view.InputView.inputPayment;
import static lotto.view.InputView.inputWinningNumbers;
import static lotto.view.OutputView.printBuyLottoCount;
import static lotto.view.OutputView.printLottoNumbers;

import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResult;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;
import lotto.view.OutputView;

public class LottoController {
    private Lottos lottos;
    private final WinningLotto winningLotto = new WinningLotto();
    private final LottoService lottoService = LottoServiceImpl.getInstance();

    public void run() {
        buyLottos();
        drawWinningNumbers();
        drawBonusNumber();
        calculateLotto();
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
        printLottoNumbers(lottos);
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

    private void calculateLotto() {
        WinningResult winningResult = lottoService.calculateWinning(lottos, winningLotto);
        double rateOfReturn = lottoService.calculateRateOfReturn(winningResult, lottos.getPayment());
        OutputView.printWinningStatic(winningResult, rateOfReturn);
    }
}
