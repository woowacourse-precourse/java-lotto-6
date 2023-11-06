package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LotteryService {
    static final int INITIALIZE = 0;

    public List<Lotto> getTotalLottery(int lotteryCount){
        List<Lotto> totalLottery = new ArrayList<>();

        while(totalLottery.size() < lotteryCount){
            List<Integer> lotteryNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lottery = new Lotto(lotteryNumber);
            totalLottery.add(lottery);
        }

        return totalLottery;
    }

    public List<Ranking> compareLotteryWithWinningNumber(List<Lotto> lotteries, Lotto winningNumber, int bonusNumber){
        List<Ranking> winningInformation = new ArrayList<>();

        for(Lotto lottery : lotteries){
            List<Integer> lotteryNumber = lottery.getNumbers();
            int sameNumberCount = getSameNumberCount(lotteryNumber, winningNumber);

            boolean hasBonusNumber = lotteryNumber.contains(bonusNumber);

            Ranking rank = getRank(sameNumberCount, hasBonusNumber);
            winningInformation.add(rank);
        }

        return winningInformation;
    }

    public int getSameNumberCount(List<Integer> lotteryNumber, Lotto winningNumber){
        int sameNumberCount = INITIALIZE;
        List<Integer> winningLotteryNumber = winningNumber.getNumbers();

        for(int number : lotteryNumber){
            if(winningLotteryNumber.contains(number)){
                sameNumberCount++;
            }
        }

        return sameNumberCount;
    }

    public Ranking getRank(int sameNumberCount, boolean hasBonusNumber){
        Ranking ranking = Ranking.FAILURE;

        for(Ranking rank : Ranking.values()){
            if(sameNumberCount == rank.getSameNumberCount()){
                ranking = rank;
                break;
            }
        }

        if(ranking.name().equals("SECOND_PRIZE") && !hasBonusNumber){
            ranking = Ranking.THIRD_PRIZE;
        }

        return ranking;
    }
}
