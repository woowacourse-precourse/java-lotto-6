package lotto.controller;

import java.math.BigDecimal;
import java.util.Map;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoTicket;
import lotto.domain.result.WinningRank;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        LottoTicket lottoTicket = createLottosTicket();
        LottoGame lottoGame = initializeLottoGame();
        Map<WinningRank, Integer> rankResult = lottoGame.calculateRanking(lottoTicket);
        BigDecimal resultRate = lottoGame.calculateResultRate(lottoTicket);
        outputView.printGameResult(rankResult, resultRate);
    }

    private LottoTicket createLottosTicket() {
        try {
            LottoTicket lottoTicket = LottoTicket.create(inputView.inputBudget());
            outputView.printTicket(lottoTicket);
            return lottoTicket;
        } catch (IllegalArgumentException exception) {
            inputView.printExceptionMessage(exception);
            return createLottosTicket();
        }
    }

    private LottoGame initializeLottoGame() {
        Lotto lotto = inputLottoNumbers();
        BonusNumber bonusNumber = getCleanBonusNumber(lotto);

        return LottoGame.by(lotto, bonusNumber);
    }

    private Lotto inputLottoNumbers() {
        try {
            return new Lotto(inputView.inputWinnerNumbers());
        } catch (IllegalArgumentException exception) {
            inputView.printExceptionMessage(exception);
            return inputLottoNumbers();
        }
    }

    private BonusNumber getCleanBonusNumber(Lotto lotto) {
        try {
            BonusNumber bonusNumber = new BonusNumber(inputView.inputBonusNumber());
            lotto.containsBonus(bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException exception) {
            inputView.printExceptionMessage(exception);
            return getCleanBonusNumber(lotto);
        }
    }
}
