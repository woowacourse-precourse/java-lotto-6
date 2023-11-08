package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Player;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.util.LottoUtil;

import java.util.List;

public class LottoController {

    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void playLotto() {
        int purchaseAmount = readPurchaseAmount();
        Player player = new Player(purchaseAmount);
        int numberOfLottos = lottoService.calculateNumberOfLottos(purchaseAmount);

        lottoService.purchaseLottos(player, numberOfLottos);
        printPurchasedLottoNumbers(numberOfLottos, player);
    }

    private int readPurchaseAmount() {
        while (true) {
            try {
                String purchaseAmountInput = inputView.readPurchaseAmount();
                return LottoUtil.parseStringToInt(purchaseAmountInput);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void printPurchasedLottoNumbers(int numberOfLottos, Player player) {
        outputView.printPurchaseComplete(numberOfLottos);
        for (Lotto lotto : player.getLottos()) {
            outputView.printLottoNumbers(lotto.getNumbers());
        }
    }
}
