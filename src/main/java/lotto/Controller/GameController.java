package lotto.Controller;

import lotto.Lotto;
import lotto.View.*;
import lotto.Model.*;

import java.util.*;

public class GameController {

    public void run(){
        int purchaseAmount = this.readPurchaseAmount();
        List<Lotto> lottoTickets = LottoTicket.generateLottoTickets(purchaseAmount);
        output.printLotto(lottoTickets);
        List<Integer> winningNumbers = this.readWinningNumbers();
        int bonusNumber = this.readBonusNumber();
        Map<String, Integer> result = Result.calculateResults(lottoTickets, winningNumbers, bonusNumber);
        double prifitRate = Result.resultsToProfitRate(result);
        output.printResults(result, prifitRate);
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
    private List<Integer> readWinningNumbers() {
        while (true) {
            try {
                String winningNumberString = input.readWinningNumbers();
                List<Integer> winningNumbers = new ArrayList<>();
                Set<Integer> uniqueNumbers = new HashSet<>();
                int trigger = validateWinningNumbers(winningNumberString, winningNumbers, uniqueNumbers);

                if (winningNumbers.size() == 6) {
                    return winningNumbers;
                }
                if (trigger == 1) {
                    error.not_valid_winningNumber_length();
                }
            } catch (NumberFormatException e) {
                error.NAN();
            }
        }
    }

    private int validateWinningNumbers(String winningNumberString, List<Integer> winningNumbers, Set<Integer> uniqueNumbers) {
        int trigger = 1;
        String[] winningNumberStringArray = winningNumberString.split(",");
        for (String number : winningNumberStringArray) {
            int num = Integer.parseInt(number);
            if (uniqueNumbers.contains(num)) {
                error.duplicate_winningNumber();
                trigger = 0;
            } else if (num < 1 || num > 45) {
                error.not_valid_winningNumber();
                trigger = 0;
            } else {
                winningNumbers.add(num);
                uniqueNumbers.add(num);
            }
        }
        return trigger;
    }

    private int readBonusNumber(){
        while (true) {
            try {
                String bonusNumberString = input.readBonusNumber();
                int bonusNumber = Integer.parseInt(bonusNumberString);
                if (1 <= bonusNumber && bonusNumber <= 45 ) {
                    return bonusNumber;
                }
                error.not_valid_bonusNumber();
            } catch (NumberFormatException e) {
                error.NAN();
            }
        }
    }
}
