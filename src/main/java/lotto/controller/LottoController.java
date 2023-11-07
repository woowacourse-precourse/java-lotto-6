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
        int ticketCount = BuyLotto(money);
        Lottos userLottos = generateLottoNumbers(ticketCount);
        WinningNumbers winningNumbers = generateWinningNumbers();
        BonusNumber bonusNumber = generateBonusNumber(winningNumbers);
        Map<Rank, Integer> rankCount = checkLottoGameResult(userLottos, winningNumbers, bonusNumber);
        printWinningStatistics(rankCount, money);
    }

    private int BuyLotto(Money money) {
        int ticketCount = money.calculateTicketCount();
        OutputView.printTicketCount(ticketCount);
        return ticketCount;
    }

    private Lottos generateLottoNumbers(int ticketCount) {
        Lottos userLottos = lottoManager.generateUserLottos(ticketCount);
        OutputView.printUserLottos(userLottos.getLottos());
        return userLottos;
    }

    private WinningNumbers generateWinningNumbers() {
        WinningNumbers winningNumbers = getValidWinningNumbersInput();
        return winningNumbers;
    }

    private BonusNumber generateBonusNumber(WinningNumbers winningNumbers) {
        BonusNumber bonusNumber = getValidBonusNumberInput(winningNumbers);
        return bonusNumber;
    }

    private Map<Rank, Integer> checkLottoGameResult(Lottos userLottos, WinningNumbers winningNumbers,
                                                    BonusNumber bonusNumber) {
        Map<Rank, Integer> rankCount = lottoManager.calculateRankCount(userLottos, winningNumbers, bonusNumber);
        OutputView.printWinningStatistics();
        return rankCount;
    }

    private void printWinningStatistics(Map<Rank, Integer> rankCount, Money money) {
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