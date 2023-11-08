package lotto.controller;

import static lotto.enums.NumberCondition.LOWEST_PRIZE_RANK;
import static lotto.enums.PrizeRank.FIFTH;
import static lotto.enums.PrizeRank.FIRST;
import static lotto.enums.PrizeRank.FOURTH;
import static lotto.enums.PrizeRank.SECOND;
import static lotto.enums.PrizeRank.THIRD;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import lotto.model.Prize;
import lotto.model.User;
import lotto.utils.Converter;
import lotto.view.OutputView;

public class GameController {
    private static final int PERCENT_CONVERTER = 100;
    private static final int DECIMAL_PLACE = 1;
    private final int[] nthPrizeNumber = new int[LOWEST_PRIZE_RANK.number() + 1];
    private User user;
    private Prize prize;
    private BigDecimal returnRate;
    private int count;
    private int totalPrizeMoney;

    public void run() {
        this.user = new User();
        setCount();
        OutputView.printCountAndTickets(user, count);
        this.prize = new Prize();
        setNthPrizeNumber();
        OutputView.printPrizeDetails(nthPrizeNumber);
        this.returnRate = calculateReturnRate(count, totalPrizeMoney);
        OutputView.printReturnRate(returnRate);
    }

    private void setCount() {
        count = user.getCount();
    }

    private void setNthPrizeNumber() {
        for (int index = 0; index < count; index++) {
            List<Integer> userTicket = user.getTicket(index);
            List<Integer> winningNumber = prize.getNumbers();
            int bonusNumber = prize.getBonusNumber();
            int rank = getRank(userTicket, matchNumberAmount(userTicket, winningNumber), bonusNumber);
            addNthPrize(rank);
        }
    }

    public int matchNumberAmount(List<Integer> userTicket, List<Integer> lottoNumber) {
        List<Integer> matchingList = userTicket.stream()
                .filter(lottoNumber::contains)
                .toList();
        return matchingList.size();
    }

    public int getRank(List<Integer> userTicket, int matchNumberAmount, int bonusNumber) {
        if (isFifthPrize(matchNumberAmount)) {
            return 5;
        }
        if (isFourthPrize(matchNumberAmount)) {
            return 4;
        }
        if (isThirdPrize(userTicket, matchNumberAmount, bonusNumber)) {
            return 3;
        }
        if (isSecondPrize(userTicket, matchNumberAmount, bonusNumber)) {
            return 2;
        }
        if (isFirstPrize(matchNumberAmount)) {
            return 1;
        }
        return 0;
    }

    private boolean isFifthPrize(int matchNumberAmount) {
        return matchNumberAmount == FIFTH.matchCondition();
    }

    private boolean isFourthPrize(int matchNumberAmount) {
        return matchNumberAmount == FOURTH.matchCondition();
    }

    private boolean isThirdPrize(List<Integer> userTicket, int matchNumberAmount, int bonusNumber) {
        return matchNumberAmount == THIRD.matchCondition() && !userTicket.contains(bonusNumber);
    }

    private boolean isSecondPrize(List<Integer> userTicket, int matchNumberAmount, int bonusNumber) {
        return matchNumberAmount == SECOND.matchCondition() && userTicket.contains(bonusNumber);
    }

    private boolean isFirstPrize(int matchNumberAmount) {
        return matchNumberAmount == FIRST.matchCondition();
    }

    private void addNthPrize(int n) {
        nthPrizeNumber[n]++;
        totalPrizeMoney += Converter.rankToPrizeMoney(n);
    }

    public BigDecimal calculateReturnRate(int count, int totalPrizeMoney) {
        BigDecimal money = new BigDecimal(Converter.countToMoney(count));
        BigDecimal earnedMoney = new BigDecimal(totalPrizeMoney);
        BigDecimal convertToPercent = new BigDecimal(PERCENT_CONVERTER);
        return earnedMoney.multiply(convertToPercent)
                .divide(money, DECIMAL_PLACE, RoundingMode.HALF_UP);
    }

}