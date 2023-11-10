package controller;

import java.util.List;
import message.InputSign;
import model.Lotto;
import model.LottoWinningNumbers;
import service.LottoService;
import utils.Converter;
import view.InputView;
import view.OutputView;

public class LottoController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    LottoService lottoService = new LottoService();
    LottoWinningNumbers lottoWinningNumbers;
    Lotto winningLotto;

    public void run() {
        inputPurchaseCount();
        inputWinningNumber();
        inputBonusNumber();
        logic();
        result();
    }

    public void outputPurchaseLottos() {
        outputView.printPurchaseLotto(lottoService.getLottoRepository().getLottos());
    }

    public void inputPurchaseCount() {
        while (true) {
            try {
                String purchaseAmount = inputView.inputPurchaseAmount();
                lottoService.createLottos(purchaseAmount);
                outputPurchaseLottos();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void inputBonusNumber() {
        while (true) {
            try {
                String bonusNumber = inputView.inputBonusNumber();
                lottoWinningNumbers = new LottoWinningNumbers(winningLotto, bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void inputWinningNumber() {
        while (true) {
            try {
                String winningNumber = inputView.inputWinningNumber();
                String[] winningNumbers = Converter.splitByDelimiter(winningNumber, InputSign.DELIMITER);
                winningLotto = new Lotto(Converter.stringArrayToList(winningNumbers));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public void logic() {
        lottoService.compareToLotto(lottoWinningNumbers);
    }

    public void result() {
        outputView.printAllWinningStatistics(lottoService.getLottoRepository().getWinningLotto(lottoWinningNumbers));
        outputView.printEarningRate(lottoService.getEarningRate());
    }

}
