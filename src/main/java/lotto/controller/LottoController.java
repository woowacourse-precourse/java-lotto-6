package lotto.controller;

import java.util.Map;
import lotto.domain.BonusNumber;
import lotto.domain.LottoManager;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoManager lottoManager;

    public LottoController(final LottoManager lottoManager) {
        this.lottoManager = lottoManager;
    }

    public void start() {
        Money money = getValidMoneyInput();
        int ticketCount = money.calculateTicketCount();
        OutputView.printTicketCount(ticketCount);
        Lottos userLottos = lottoManager.generateUserLottos(ticketCount);
        OutputView.printUserLottos(userLottos.getLottos());
        WinningNumbers winningNumbers = getValidWinningNumbersInput();
        BonusNumber bonusNumber = getValidBonusNumberInput(winningNumbers);
        Map<Rank, Integer> rankCount = lottoManager.calculateRankCount(userLottos, winningNumbers, bonusNumber);
        OutputView.printWinningStatistics();
        OutputView.printRankCount(rankCount);
        lottoManager.printRateOfReturn(rankCount, money);
    }

    private Money getValidMoneyInput() {
        return lottoManager.getValidInput(() -> new Money(InputView.getMoneyInput()));
    }

    private WinningNumbers getValidWinningNumbersInput() {
        return lottoManager.getValidInput(() -> new WinningNumbers(InputView.getWinningNumbersInput()));
    }

    private BonusNumber getValidBonusNumberInput(WinningNumbers winningNumbers) {
        return lottoManager.getValidInput(() -> new BonusNumber(InputView.getBonusNumberInput(), winningNumbers));
    }
}