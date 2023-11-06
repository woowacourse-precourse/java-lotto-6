package lotto;

import java.util.List;
import view.Input;
import view.Output;

public class LottoGame {
    public void gameStart() {
        int purchaseAmount = Input.getPurchaseAmount();
        List<Lotto> lottoTickets = LottoGenerator.generateLottoNumbers(purchaseAmount);
        Output.getLottoNumbers(lottoTickets);
        List<Integer> winningNumber = Input.getWinningNumber();
        int bonusNumber = Input.getBonusNumber(winningNumber);
        Referee.calculateLottoResultAndProfit(lottoTickets, winningNumber, bonusNumber, purchaseAmount);
    }
}