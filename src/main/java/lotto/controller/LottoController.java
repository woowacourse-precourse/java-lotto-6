package lotto.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
    NumberGenerator numberGenerator = new NumberGenerator();
    Map<Rank, Integer> rankCount = new HashMap<>();

    public void start() {
        Money money = getValidMoneyInput();
        int ticketCount = getTicketCount(money);
        OutputView.printTicketCount(ticketCount);
        List<Lotto> userLottos = createLotto(ticketCount);
        OutputView.printUserLottos(userLottos);
        WinningNumbers winningNumbers = getValidWinningNumbersInput();
        BonusNumber bonusNumber = getValidBonusNumberInput();
        calculateRankCount(userLottos, winningNumbers, bonusNumber);
        OutputView.printRankCount(rankCount);
        int totalPrize = Calculator.calculateTotalPrize(); // 당첨금액 총합
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

    private List<Lotto> createLotto(int ticketCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            Lotto lotto = createUniqueLotto();
            lottos.add(lotto);
        }
        return lottos;
    }

    private Lotto createUniqueLotto() {
        List<Integer> lottoNumbers = numberGenerator.createRandomLottoNumbers();
        while (hasDuplicates(lottoNumbers)) {
            lottoNumbers = numberGenerator.createRandomLottoNumbers();
        }
        return new Lotto(lottoNumbers);
    }

    private boolean hasDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() != numbers.size();
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

    private BonusNumber getValidBonusNumberInput() {
        BonusNumber bonusNumber = null;
        while (bonusNumber == null) {
            try {
                bonusNumber = new BonusNumber(InputView.getBonusNumberInput());
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