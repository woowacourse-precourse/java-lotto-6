package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoGameManager;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputMessage;
import lotto.view.OutputView;

public class LottoGameController {
    private final InputView inputView;
    private final LottoGameManager lottoGameManager;

    private Lotto winningLotto;
    private int lottoCost;

    public LottoGameController(InputView inputView, LottoGameManager lottoGameManager) {
        this.inputView = inputView;
        this.lottoGameManager = lottoGameManager;
    }

    public void gameStart() {
        getLottoCost();
        getWiningLotto();
        getWiningLottoAddBonusNumber();
    }

    private void getLottoCost() {
        while (true) {
            try {
                OutputView.writeLine(OutputMessage.REQUEST_LOTTO_COST.message());
                String userInputLottoCost = inputView.readLine();
                lottoCost = lottoGameManager.parsingLottoCost(userInputLottoCost);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.writeLine(e.getMessage());
            }
        }
    }

    private void getWiningLotto() {
        while (true) {
            try {
                OutputView.writeLine(OutputMessage.REQUEST_WINNING_NUMBER.message());
                String userInputWinningNumbers = inputView.readLine();
                winningLotto = lottoGameManager.createWinningLotto(userInputWinningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.writeLine(e.getMessage());
            }
        }
    }

    private WinningLotto getWiningLottoAddBonusNumber() {
        while (true) {
            try {
                OutputView.writeLine(OutputMessage.REQUEST_BONUS_NUMBER.message());
                String userInputBonusNumbers = inputView.readLine();
                return lottoGameManager.createWinningLottoAddBonusNumber(winningLotto, userInputBonusNumbers);
            } catch (IllegalArgumentException e) {
                OutputView.writeLine(e.getMessage());
            }
        }
    }
}
