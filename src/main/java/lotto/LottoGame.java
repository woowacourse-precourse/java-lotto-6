package lotto;

import java.util.List;
import java.util.Map;
import view.Input;
import view.Output;

public class LottoGame {
    public void gameStart() {
        int purchaseAmount = Input.getPurchaseAmount();
        List<Lotto> lottoTickets = LottoGenerator.generateLottoNumbers(purchaseAmount);
        Output.printLottoNumbers(lottoTickets);
        List<Integer> winningNumber = Input.getWinningNumber();
        int bonusNumber = Input.getBonusNumber(winningNumber);

        Output.printLottoGameResult();
        Map<Rank, Long> winningCounts = Referee.countLottoRank(lottoTickets, winningNumber, bonusNumber);
        Output.printLottoResult(winningCounts);

        double profitRate = Referee.getLottoProfit(winningCounts, purchaseAmount);
        Output.printLottoProfit(profitRate);
    }
}