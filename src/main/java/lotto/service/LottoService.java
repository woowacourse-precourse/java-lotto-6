package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {

    private static final int SIX = 6;
    private static final int FIVE = 5;
    private static final int FOUR = 4;
    private static final int THREE = 3;
    private static final int TWO = 2;
    private static final int ONE = 1;

    private InputView inputView = new InputView();
    private Buyer buyer = new Buyer();
    private List<Integer> prizeCount = new ArrayList<>();

    public LottoService() {
        for (int i = 0; i < 6; i++) {
            prizeCount.add(0);
        }
    }

    public int getLotteryTicketCount(int purchasePrice) {
        return purchasePrice / 1000;
    }

    public List<Integer> issueLotteryTicket() {
        List<Integer> lotteryTicketNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> newLotteryTicketNumbers = new ArrayList<>(lotteryTicketNumbers);
        Collections.sort(newLotteryTicketNumbers);

        Lotto lotto = new Lotto(newLotteryTicketNumbers);
        buyer.addLotto(lotto);

        return newLotteryTicketNumbers;
    }

    public Buyer issueLotteryTicketAll(int purchasePrice) {
        int lotteryTicketCount = getLotteryTicketCount(purchasePrice);
        while (lotteryTicketCount-- > 0) {
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

        if (matchingNumbers == SIX) {
            prizeCount.add(ONE, prizeCount.get(ONE) + 1);
            return Prize.FIRST_PLACE;
        }
        if (matchingNumbers == FIVE && isMatchingBonusNumber) {
            prizeCount.add(TWO, prizeCount.get(TWO) + 1);
            return Prize.SECOND_PLACE;
        }
        if (matchingNumbers == FIVE) {
            prizeCount.add(THREE, prizeCount.get(THREE) + 1);
            return Prize.THIRD_PLACE;
        }
        if (matchingNumbers == FOUR) {
            prizeCount.add(FOUR, prizeCount.get(FOUR) + 1);
            return Prize.FOURTH_PLACE;
        }
        if (matchingNumbers == THREE) {
            prizeCount.add(FIVE, prizeCount.get(FIVE) + 1);
            return Prize.FIFTH_PLACE;
        }

        return Prize.UNRANKED;
    }

    public double getRateOfReturn(List<Prize> prizes, double purchasePrice) {
        double totalPrizeMoney = getTotalPrizeMoney(prizes);
        return (totalPrizeMoney / purchasePrice) * 100;
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

    public List<Integer> getPrizeCount() {
        return prizeCount;
    }
}
