package lotto.controller;

import java.util.List;
import lotto.model.Client;
import lotto.model.Lotto;
import lotto.model.LottoResultChecker;
import lotto.model.LottoStore;
import lotto.view.View;

public class LottoController {
    View view = new View();
    LottoStore lottoStore = new LottoStore();

    public void run() {
        Client client = newClient();
        issueLotto(client);
        LottoResultChecker lottoResultChecker = new LottoResultChecker();
        drawWinningNumbers(lottoResultChecker);
        announceLottoResults(client, lottoResultChecker);
    }

    private Client newClient() {
        view.printPayAmountInputMessage();
        while (true) {
            try {
                String payAmount = view.inputValue();
                return Client.of(payAmount);
            } catch (IllegalArgumentException e) {
                view.printExceptionMessage(e);
            }
        }
    }

    private void issueLotto(Client client) {
        int purchasedLottoAmount = lottoStore.calculatePurchasedLottoAmount(client.getPayAmount());
        view.printPurchaseLottoAmount(purchasedLottoAmount);
        for (int issuedLottoCount = 1; issuedLottoCount <= purchasedLottoAmount; issuedLottoCount++) {
            Lotto lotto = lottoStore.createRandomLotto();
            view.printIssuedLotto(lotto.toString());
            client.addLotto(lotto);
        }
    }

    private void drawWinningNumbers(LottoResultChecker lottoResultChecker) {
        createWinningNumbers(lottoResultChecker);
        createBonusNumber(lottoResultChecker);
    }

    private void createWinningNumbers(LottoResultChecker lottoResultChecker) {
        view.printWinningNumbersInputMessage();
        while (true) {
            try {
                String winningNumbers = view.inputValue();
                lottoResultChecker.createWinningNumbers(winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                view.printExceptionMessage(e);
            }
        }
    }

    private void createBonusNumber(LottoResultChecker lottoResultChecker) {
        view.printBonusNumberInputMessage();
        while (true) {
            try {
                String bonusNumber = view.inputValue();
                lottoResultChecker.createBonusNumber(bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                view.printExceptionMessage(e);
            }
        }
    }

    private void announceLottoResults(Client client, LottoResultChecker lottoResultChecker) {
        List<Integer> lottoResults = lottoResultChecker.showLottoResults(client.getLottos());
        view.printLottoResult(lottoResults);
        double rateOfReturn = client.calculateRateOfReturn(lottoResults);
        view.printRateOfReturn(rateOfReturn);
    }
}
