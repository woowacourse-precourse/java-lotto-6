package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Prize;
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
        boolean isMatchedBonus;
        for (Integer lotteryNumber : lotteryNumbers) {
            count += findNumbers(winningNumbers, lotteryNumber);
        }
        return count;
    }

    public boolean isMatchingBonusNumber(List<Integer> lotteryNumbers, int bonusNumber) {
        if (lotteryNumbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    public Prize getPrize(List<Integer> lotteryNumbers, List<Integer> winningNumbers, int bonusNumber) {
        int matchingNumbers = getMatchingNumbers(lotteryNumbers, winningNumbers);
        boolean isMatchingBonusNumber = isMatchingBonusNumber(lotteryNumbers, bonusNumber);

        if (matchingNumbers == 6) {
            return Prize.FIRST_PLACE;
        }
        if (matchingNumbers == 5 && isMatchingBonusNumber) {
            return Prize.SECOND_PLACE;
        }
        if(matchingNumbers == 5) {
            return Prize.THIRD_PLACE;
        }
        if(matchingNumbers == 4) {
            return Prize.FOURTH_PLACE;
        }
        if(matchingNumbers == 3) {
            return Prize.FIFTH_PLACE;
        }

        return Prize.UNRANKED;
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
