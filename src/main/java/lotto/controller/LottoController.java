package lotto.controller;

import java.util.List;
import lotto.service.LottoService;
import lotto.util.Converter;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService = new LottoService();

    public void investInLotto() {
        while (true) {
            try {
                int purchaseAmount = Converter.convertPurchaseAmount(InputView.readPurchaseAmount());
                lottoService.buyLotto(purchaseAmount);
                OutputView.printBuyResults(lottoService.createBuyResults());
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public void drawLottoNumbers() {
        while (true) {
            try {
                List<Integer> winningNumbers = Converter.convertWinningNumbers(InputView.readWinningNumbers());
                int bonusNumber = Converter.convertBonusNumber(winningNumbers, InputView.readBonusNumber());
                lottoService.makeWinningLotto(winningNumbers, bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
