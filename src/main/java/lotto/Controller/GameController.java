package lotto.Controller;

import lotto.Lotto;
import lotto.View.*;
import lotto.Model.*;

import java.util.List;

public class GameController {

    public void run(){
        int purchaseAmount = this.readPurchaseAmount();
        List<Lotto> lottoTickets = LottoTicket.generateLottoTickets(purchaseAmount);
        output.printLotto(lottoTickets);
        //List<Integer> winningNumbers = Console.readWinningNumbers();
        //int bonusNumber = Console.readBonusNumber();

        //Result result = lottoService.calculateResult(lottoTickets, winningNumbers, bonusNumber);

        //Console.printResults(result);
    }

    private int readPurchaseAmount(){
        while (true) {
            try {
                String purchaseAmountString = input.readPurchaseAmount();
                int purchaseAmount = Integer.parseInt(purchaseAmountString);
                if (purchaseAmount % 1000 == 0) {
                    return purchaseAmount;
                }
                error.not_valid_purchaseAmount();
            } catch (NumberFormatException e) {
                error.NAN();
            }
        }
    }
}
