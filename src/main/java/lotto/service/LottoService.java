package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.InputView;

import java.util.Collections;
import java.util.List;

public class LottoService {

    InputView inputView = new InputView();

    public int getLotteryTicketCount() {
        return inputView.inputPurchasePrice() / 1000;
    }

    public List<Integer> issueLotteryTicket() {
        List<Integer> lotteryTicketNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lotteryTicketNumbers);
        return lotteryTicketNumbers;
    }

    public int getMatchingNumbers(List<Integer> lotteryNumbers, List<Integer> winningNumbers) {
        int count = 0;
        for (Integer lotteryNumber : lotteryNumbers) {
            count += findNumbers(winningNumbers, lotteryNumber);
        }
        return count;
    }

    public void getRateOfReturn() {

    }

    private int findNumbers(List<Integer> winningNumbers, Integer lotteryNumber) {
        if (winningNumbers.contains(lotteryNumber)) {
            return 1;
        }
        return 0;
    }
}
