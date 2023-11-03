package lotto.controller;

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

    public String getUserInputLottoCost() {
        while (true) {
            try {
                String userInputLottoCost = inputView.readLine();
                lottoGameManager.validateLottoCost(userInputLottoCost);
                return userInputLottoCost;
            } catch (IllegalArgumentException e) {
                OutputView.writeLine(e.getMessage());
            }
        }
    }

    public Integer getValidatedLottoCost() {
        return lottoGameManager.parsingLottoCost(getUserInputLottoCost());
    }
}
