package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoShop;
import lotto.domain.ProfitCalculator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoService {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoShop lottoShop = new LottoShop();

    public void serviceStart() {
        int money = inputView.inputPurchaseAmount();
        int lottoCount = lottoShop.buyLotto(money);

        List<Lotto> lottoTickets = getLottoTickets(lottoCount);
        int[] prizeGradeCounts = countWinningLotto(lottoTickets);
        outputView.printWinningState(prizeGradeCounts);

        ProfitCalculator profitCalculator = new ProfitCalculator();
        double revenueRate = profitCalculator.getRevenueRate(prizeGradeCounts, money);
        outputView.printRevenueRate(revenueRate);
    }

    public List<Lotto> getLottoTickets(int count) {
        List<Lotto> lottoSets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoSets.add(lottoShop.generateLottoTicket());
        }
        outputView.printLottoTickets(lottoSets);
        return lottoSets;
    }

    public int[] countWinningLotto(List<Lotto> lottoTickets) {
        List<Integer> winningNumbers = inputView.inputWinningNumbers();
        int bonusNumber = inputView.inputBonusNumber(winningNumbers);

        int[] prizeGradeCounts = new int[6];
        for (Lotto lotto : lottoTickets) {
            int matchedNumbersCount = countDuplicateNumber(lotto, winningNumbers);
            boolean isBonusNumberMatched = isBonusNumberMatched(lotto, bonusNumber);
            int prizeGrade = determinePrizeGrade(matchedNumbersCount, isBonusNumberMatched);
            prizeGradeCounts[prizeGrade]++;
        }
        return prizeGradeCounts;
    }

    private static int countDuplicateNumber(Lotto lotto, List<Integer> winningNumbers) {
        List<Integer> numbers =  lotto.getNumbers();
        numbers.retainAll(winningNumbers);
        return numbers.size();
    }

    public static int determinePrizeGrade(int matchedNumbersCount, boolean isBonusNumberMatched) {
        if (matchedNumbersCount == 6) {
            return 1;
        }
        if (matchedNumbersCount == 5 && isBonusNumberMatched) {
            return 2;
        }
        if (matchedNumbersCount == 5) {
            return 3;
        }
        if (matchedNumbersCount == 4) {
            return 4;
        }
        if (matchedNumbersCount == 3) {
            return 5;
        }
        return 0;
    }

    public static boolean isBonusNumberMatched(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}

