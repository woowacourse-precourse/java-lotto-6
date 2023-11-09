package lotto.controller;


import lotto.config.InputConfiguration;
import lotto.domain.LottoTickets;
import lotto.domain.RankResult;
import lotto.util.handler.InputHandler;
import lotto.vo.BonusNumber;
import lotto.vo.WinningNumbers;

public class WinningController {
    private final LottoTickets lottoTickets;

    private WinningController(LottoTickets lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static WinningController from(LottoTickets lottoTickets) {
        return new WinningController(lottoTickets);
    }

    public RankResult determineResults() {
        WinningNumbers winningNumbers = processWinningNumbers();
        BonusNumber bonusNumber = processBonusNumber(winningNumbers);

        return lottoTickets.evaluateWinningStatus(winningNumbers, bonusNumber);
    }

    private WinningNumbers processWinningNumbers() {
        return InputHandler.processInput(
                InputConfiguration.createWinningNumbersInputHandler(),
                WinningNumbers::from
        );
    }

    private BonusNumber processBonusNumber(WinningNumbers winningNumbers) {
        return InputHandler.processInput(
                InputConfiguration.createBonusNumberInputHandler(winningNumbers),
                BonusNumber::from
        );
    }
}
