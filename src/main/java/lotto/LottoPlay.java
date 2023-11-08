package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoPlay {
    Print print = new Print();
    LottoPurchase lottoPurchase = new LottoPurchase();
    LottoInput lottoInput = new LottoInput();
    LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
    BonusNumber bonusNumber = new BonusNumber();
    LottoResult lottoResult = new LottoResult();

    public void start() {
        print.purchaseAmount();
        int amount = lottoPurchase.inputAndValidatePurchaseAmount();
        int ticket = amount / 1000;
        print.ticketCount(ticket);
        List<Lotto> lottoTickets = lottoNumberGenerator.generateLottoTickets(ticket);
        print.lottoTickets(lottoTickets);
        print.inputWinningNumber();
        List<Integer> winningNumbers = new ArrayList<>();
        winningNumbers = lottoInput.inputWinningNumbers();
        print.inputBonusNumber();
        int bonusNum = bonusNumber.bonusNumber();
        Map<String, Integer> matchCounts = lottoResult.checkResults(lottoTickets, winningNumbers, bonusNum);
        print.printWinningResult(matchCounts, LottoResult.getPrizeMoney());
        int winnings = calculateWinnings(matchCounts, LottoResult.getPrizeMoney());
        print.rateOfReturn(amount, winnings);
    }

    private int calculateWinnings(Map<String, Integer> matchCounts, Map<String, Integer> prizeMoney) {
        int totalWinnings = 0;
        for (Map.Entry<String, Integer> entry : matchCounts.entrySet()) {
            String key = entry.getKey();
            Integer count = entry.getValue();
            totalWinnings += prizeMoney.getOrDefault(key, 0) * count;
        }
        return totalWinnings;
    }
}
