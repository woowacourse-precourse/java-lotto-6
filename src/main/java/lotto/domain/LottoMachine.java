package lotto.domain;

import java.util.List;
import lotto.controller.LottoController;
import lotto.controller.PlayerController;
import lotto.view.View;

public class LottoMachine {

    private final PlayerController playerController;
    private final LottoController lottoController;

    public LottoMachine(PlayerController playerController, LottoController lottoController) {
        this.playerController = playerController;
        this.lottoController = lottoController;
    }

    public void start() {
        List<Lotto> purchaseLotto = purchaseLottoFromPlayer();
        printPurchaseDetails(purchaseLotto);

        MatchedLottoCount matchedLottoCount = getInputNumbers();
        printLottoResult(matchedLottoCount);

        printRateOfReturn();
    }

    private List<Lotto> purchaseLottoFromPlayer() {
        while (true) {
            try {
                View.printStartMessage();
                List<Lotto> purchaseLotto = playerController.purchaseLotto(View.input());
                return purchaseLotto;
            } catch (IllegalArgumentException e) {
                View.printErrorMessage(e.getMessage());
            }
        }
    }

    private void printPurchaseDetails(List<Lotto> purchaseLotto) {
        View.printPurchaseMessage(purchaseLotto.size());
        View.printPurchasedLotto(purchaseLotto);
    }

    private MatchedLottoCount getInputNumbers() {
        while (true) {
            try {
                return lottoController.inputNumbers(View.printInputNumbersMessage());
            } catch (IllegalArgumentException e) {
                View.printErrorMessage(e.getMessage());
            }
        }
    }

    private void printLottoResult(MatchedLottoCount matchedLottoCount) {
        View.printLottoResult(matchedLottoCount);
    }

    private void printRateOfReturn() {
        View.printRateOfReturn(playerController.calculateRateOfReturn());
    }


}
