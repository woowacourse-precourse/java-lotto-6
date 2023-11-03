package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoGameManager;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private final InputView inputView;
    private final LottoGameManager lottoGameManager;

    public LottoGameController(InputView inputView, LottoGameManager lottoGameManager) {
        this.inputView = inputView;
        this.lottoGameManager = lottoGameManager;
    }

    public Integer getLottoCost() {
        while (true) {
            try {
                String userInputLottoCost = inputView.readLine();
                return lottoGameManager.parsingLottoCost(userInputLottoCost);
            } catch (IllegalArgumentException e) {
                OutputView.writeLine(e.getMessage());
            }
        }
    }

    public Lotto getWiningLotto() {
        while (true) {
            try {
                String userInputWinningNumbers = inputView.readLine();
                return lottoGameManager.createWinningLotto(userInputWinningNumbers);
            } catch (IllegalArgumentException e) {
                OutputView.writeLine(e.getMessage());
            }
        }
    }
}
