package lotto.controller;

import java.util.List;
import lotto.model.Client;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.LottoStore;
import lotto.view.View;

public class LottoController {
    private static final View view = new View();
    private static final LottoStore lottoStore = new LottoStore();

    public void run() {
        Client client = buyLottos();
        issueLottos(client);
        LottoResult lottoResult = createWinningNumbers();
        createBonusNumber(lottoResult);
        announceLottoResults(client, lottoResult);
    }

    private Client buyLottos() {
        view.printPayAmountInputMessage();
        while (true) {
            try {
                String payAmount = view.inputValue();
                return Client.from(payAmount);
            } catch (IllegalArgumentException e) {
                view.printExceptionMessage(e);
            }
        }
    }

    private void issueLottos(Client client) {
        int purchasedLottoAmount = lottoStore.calculatePurchasedLottoAmount(client.getPayAmount());
        view.printPurchaseLottoAmount(purchasedLottoAmount);
        for (int issuedLottoCount = 1; issuedLottoCount <= purchasedLottoAmount; issuedLottoCount++) {
            Lotto lotto = lottoStore.issueRandomLotto();
            view.printIssuedLotto(lotto.toString());
            client.receiveLotto(lotto);
        }
    }

    private LottoResult createWinningNumbers() {
        view.printWinningNumbersInputMessage();
        while (true) {
            try {
                String winningNumbers = view.inputValue();
                return LottoResult.from(winningNumbers);
            } catch (IllegalArgumentException e) {
                view.printExceptionMessage(e);
            }
        }
    }

    private void createBonusNumber(LottoResult lottoResult) {
        view.printBonusNumberInputMessage();
        while (true) {
            try {
                String bonusNumber = view.inputValue();
                lottoResult.createBonusNumber(bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                view.printExceptionMessage(e);
            }
        }
    }

    private void announceLottoResults(Client client, LottoResult lottoResult) {
        List<Integer> lottoResults = lottoResult.calculateLottosResult(client.getLottos());
        view.printLottoResult(lottoResults);
        double rateOfReturn = client.calculateRateOfReturn(lottoResults);
        view.printRateOfReturn(rateOfReturn);
    }
}
