package lotto.Controller;

import lotto.Lotto;
import lotto.View.*;
import lotto.Model.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameController {

    public void run(){
        int purchaseAmount = this.readPurchaseAmount();
        List<Lotto> lottoTickets = LottoTicket.generateLottoTickets(purchaseAmount);
        output.printLotto(lottoTickets);
        List<Integer> winningNumbers = this.readWinningNumbers();
        //int bonusNumber = Console.readBonusNumber();

        //Result result = lottoService.calculateResult(lottoTickets, winningNumbers, bonusNumber);

        //Console.printResults(result);
    }

    private List<Integer> readWinningNumbers() {
        while (true) {
            try {
                String winningNumberString = input.readWinningNumbers();
                String[] winningNumberStringArray = winningNumberString.split(",");
                List<Integer> winningNumbers = new ArrayList<>();
                Set<Integer> uniqueNumbers = new HashSet<>();
                int trigger = 1;
                for (String number : winningNumberStringArray) {
                    int num = Integer.parseInt(number);
                    if (uniqueNumbers.contains(num)) {
                        error.duplicate_winningNumber();
                        trigger=0;
                        continue;
                    }
                    if (num < 1 || num > 45) {
                        error.not_valid_winningNumber();
                        trigger=0;
                        continue;
                    }
                    winningNumbers.add(num);
                    uniqueNumbers.add(num);
                }
                if ( winningNumbers.size() == 6) {
                    return winningNumbers;
                }
                if (trigger == 1){
                    error.not_valid_winningNumber();
                }
            } catch (NumberFormatException e) {
                error.NAN();
            }
        }
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
