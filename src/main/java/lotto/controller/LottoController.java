package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.domain.BonusNumber;
import lotto.domain.Calculator;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.NumberGenerator;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final NumberGenerator numberGenerator;
    private final Calculator calculator;

    public LottoController() {
        this.numberGenerator = new NumberGenerator();
        this.calculator = new Calculator();
    }

    public void start() {
        Money money = getValidMoneyInput();
        int ticketCount = getTicketCount(money);
        OutputView.printTicketCount(ticketCount);
        List<Lotto> userLottos = createLotto(ticketCount);
        OutputView.printUserLottos(userLottos);
        WinningNumbers winningNumbers = getValidWinningNumbersInput();
        BonusNumber bonusNumber = getValidBonusNumberInput(winningNumbers);
        calculateRankCount(userLottos, winningNumbers, bonusNumber);
        OutputView.printRankCount(rankCount);
        int totalPrize = Calculator.calculateTotalPrize(rankCount); // 당첨금액 총합
        double earningRate = Calculator.calculateEarningRate(totalPrize, money);
        OutputView.printEarningRate(earningRate);
    }

    private Money getValidMoneyInput() {
        Money money = null;
        while (money == null) {
            try {
                money = new Money(InputView.getMoneyInput());
            } catch (IllegalArgumentException e) {
                OutputView.printException(e);
            }
        }
        return money;
    }

    private int getTicketCount(Money money) {
        int ticketCount = money.calculateTicketCount();
        return ticketCount;
    }

    private Lotto createValidLotto() {
        Lotto lotto = null;
        while (lotto == null) {
            try {
                List<Integer> lottoNumbers = numberGenerator.createRandomLottoNumbers();
                lotto = new Lotto(lottoNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return lotto;
    }

    private List<Lotto> createLotto(int ticketCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            Lotto lotto = createValidLotto();
            lottos.add(lotto);
        }
        return lottos;
    }

    private WinningNumbers getValidWinningNumbersInput() {
        WinningNumbers winningNumbers = null;
        while (winningNumbers == null) {
            try {
                winningNumbers = new WinningNumbers(InputView.getWinningNumbersInput());
            } catch (IllegalArgumentException e) {
                OutputView.printException(e);
            }
        }
        return winningNumbers;
    }

    private BonusNumber getValidBonusNumberInput(WinningNumbers winningNumbers) {
        BonusNumber bonusNumber = null;
        while (bonusNumber == null) {
            try {
                int bonusNumberInput = InputView.getBonusNumberInput();
                bonusNumber = new BonusNumber(bonusNumberInput, winningNumbers.getWinningNumbers());
            } catch (IllegalArgumentException e) {
                OutputView.printException(e);
            }
        }
        return bonusNumber;
    }

    private void calculateRankCount(List<Lotto> userLottos, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        for (Lotto lotto : userLottos) {
            int countOfMatch = 0;
            for (Integer number : lotto.getNumbers()) {
                if (winningNumbers.contains(number)) {
                    countOfMatch++;
                }
            }
            boolean matchBonus = lotto.getNumbers().contains(bonusNumber.getBonusNumber());
            Rank rank = Rank.calculateRank(countOfMatch, matchBonus);
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }
    }
}