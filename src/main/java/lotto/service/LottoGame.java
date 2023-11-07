package lotto.service;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private LottoWinResultService lottoWinResultService = new LottoWinResultService();

    public void playGame() {
        PurchasePrice purchasePrice = inputPurchasePrice();

        int lottoAmount = purchasePrice.getLottoAmount();
        outputView.printLottoAmount(lottoAmount);

        List<Lotto> lottos = generateUserLottos(lottoAmount);
        WinningLotto winningLotto = inputWinLotto();

        inputBonusNumber(winningLotto);

        WinResult winResult = lottoWinResultService.getWinResult(lottos, winningLotto);
        double profitRate = lottoWinResultService.calculateProfitRate(purchasePrice);

        printWinResult(winResult);
        printProfitRate(profitRate);
    }

    private PurchasePrice inputPurchasePrice() {
        outputView.printMoneyInputGuideMessage();
        PurchasePrice purchasePrice = inputView.inputPrice();

        return purchasePrice;
    }

    private List<Lotto> generateUserLottos(int lottoAmount) {
        RandomNumber randomNumber = new RandomNumber();
        List<Lotto> lottos = new ArrayList<>();

        while (lottoAmount > 0) {
            List<Integer> randomNumbers = randomNumber.generateRandomNumbers();
            outputView.printUserLottos(randomNumbers);
            lottos.add(new Lotto(randomNumbers));
            lottoAmount--;
        }

        return lottos;
    }

    private WinningLotto inputWinLotto() {
        outputView.printWinLottoNumbersInputGuide();
        Lotto winLotto = inputView.inputWinLotto();

        return new WinningLotto(winLotto);
    }

    private void inputBonusNumber(WinningLotto winningLotto) {
        outputView.printBonusNumbersInputGuide();
        validateBonusLottoNumber(winningLotto);
    }

    private void validateBonusLottoNumber(WinningLotto winningLotto) {
        try {
            winningLotto.setBonusLottoNum(inputView.inputBonusNumber());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            validateBonusLottoNumber(winningLotto);
        }
    }

    private void printWinResult(WinResult winResult) {
        outputView.printWinningResultGuideMessage();
        outputView.printWinResult(winResult);
    }

    private void printProfitRate(double profitRate) {
        outputView.printProfitRate(profitRate);
    }
}