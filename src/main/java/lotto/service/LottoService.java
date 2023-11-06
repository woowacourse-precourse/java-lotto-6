package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.view.InputView;

import java.util.Collections;
import java.util.List;

public class LottoService {

    private InputView inputView = new InputView();
    private Buyer buyer = new Buyer();

    public int getLotteryTicketCount(int purchasePrice) {
        return purchasePrice / 1000;
    }

    public List<Integer> issueLotteryTicket() {
        List<Integer> lotteryTicketNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lotteryTicketNumbers);

        Lotto lotto = new Lotto(lotteryTicketNumbers);
        buyer.addLotto(lotto);

        return lotteryTicketNumbers;
    }

    public Buyer issueLotteryTicketAll(int purchasePrice) {
        int lotteryTicketCount = getLotteryTicketCount(purchasePrice);
        while(lotteryTicketCount-- > 0) {
            issueLotteryTicket();
        }
        return buyer;
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

    public double getRateOfReturn(List<Prize> prizes, double purchasePrice) {
        double totalPrizeMoney = getTotalPrizeMoney(prizes);
        return totalPrizeMoney / purchasePrice * 100;
    }

    private double getTotalPrizeMoney(List<Prize> prizes) {
        double totalPrizeMoney = 0;
        for (Prize prize : prizes) {
            totalPrizeMoney += prize.getMoney();
        }
        return totalPrizeMoney;
    }

    private int findNumbers(List<Integer> winningNumbers, Integer lotteryNumber) {
        if (winningNumbers.contains(lotteryNumber)) {
            return 1;
        }
        return 0;
    }

    public Buyer getBuyer() {
        return buyer;
    }
}
