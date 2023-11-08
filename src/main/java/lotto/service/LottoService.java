package lotto.service;

import java.util.List;
import lotto.model.LottoTicket;
import lotto.model.WinningStatistics;
import lotto.util.Convert;
import lotto.util.LottoGenerator;
import lotto.util.Sorting;

public class LottoService {

    private static final int PERCENTAGE = 100;

    private final List<List<Integer>> lottoTickets;
    private final WinningStatistics winningStatistics;

    public LottoService(List<List<Integer>> lottoTickets, WinningStatistics winningStatistics) {
        this.lottoTickets = lottoTickets;
        this.winningStatistics = winningStatistics;
    }

    public void getLottoList(int lottoCount) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lotto = lottoGenerator.generateLotto();
            List<Integer> orderedLotto = Sorting.getListNaturalOrder(lotto);
            lottoTickets.add(orderedLotto);
        }
    }

    public void getResult(List<Integer> winningNumbers, int bonusNumber) {
        for (List<Integer> lottoTicket : lottoTickets) {
            LottoTicket currentLottoTicket = new LottoTicket(lottoTicket);
            int winningNumbersMatchingCount = currentLottoTicket.getMatchCountWithWinningNumbers(winningNumbers);
            boolean isBonusNumberMatch = currentLottoTicket.isMatchWithBonusNumber(bonusNumber);
            winningStatistics.checkWinningResult(winningNumbersMatchingCount, isBonusNumberMatch);
        }
    }

    public String calculateTotalYield(int purchaseAmount) {
        int totalWinningAmount = winningStatistics.getTotalWinningAmount();
        double totalYield = ((double) totalWinningAmount / (double) purchaseAmount) * PERCENTAGE;
        return Convert.formatDoubleWithCommaAndRound(totalYield);
    }
}
