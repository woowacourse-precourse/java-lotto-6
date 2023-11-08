package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.WinningResult;
import lotto.service.GameService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

import static lotto.domain.Message.*;

public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void play() {
        inputLottoDatas();
        finishGame();
    }

    private void inputLottoDatas() {
        inputPurchaseAmount();
        publishLotto();
        List<Integer> winningNumbers = inputWinningNumbers();
        inputBonusNumber(winningNumbers);
    }

    private void inputPurchaseAmount() {
        try {
            OutputView.println(PURCHASE_AMOUNT_INPUT_MESSAGE.getMessage());
            gameService.setPurchaseAmount(InputView.readPurchaseAmount());
            OutputView.println(BLANK.getMessage());
        } catch (IllegalArgumentException e) {
            OutputView.println(e.getMessage());
            inputPurchaseAmount();
        }
    }

    private void publishLotto() {
        List<Lotto> lottos = createLottos();
        printPublishedLottoNumber(lottos);
    }

    private List<Lotto> createLottos() {
        List<Lotto> lottos = gameService.publishLottoNumbers();
        OutputView.println(PURCHASE_AMOUNT_BUY_MESSAGE.getBuyMessage(lottos.size()));

        return lottos;
    }

    private void printPublishedLottoNumber(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            OutputView.println(PUBLISHED_LOTTO_NUMBER_MESSAGE.getPublishedLottoMessage(lotto.getNumbers()));
        }
        OutputView.println(BLANK.getMessage());
    }

    private List<Integer> inputWinningNumbers() {
        Lotto winningLotto;
        try {
            OutputView.println(WINNING_NUMBER_INPUT_MESSAGE.getMessage());
            winningLotto = gameService.createWinningLotto(InputView.readWinningNumbers());
            OutputView.println(BLANK.getMessage());
        } catch (IllegalArgumentException e) {
            OutputView.println(e.getMessage());
            return inputWinningNumbers();
        }

        return winningLotto.getNumbers();
    }

    private void inputBonusNumber(List<Integer> winningNumbers) {
        try {
            OutputView.println(BONUS_NUMBER_INPUT_MESSAGE.getMessage());
            gameService.setBonusNumber(InputView.readBonusNumber(winningNumbers));
            OutputView.println(BLANK.getMessage());
        } catch (IllegalArgumentException e) {
            OutputView.println(e.getMessage());
            inputBonusNumber(winningNumbers);
        }
    }

    private void finishGame() {
        WinningResult winningResult = gameService.createWinningResult();
        OutputView.println(WINNING_RESULT_MESSAGE.getWinningResultMessage(winningResult));
    }
}
