package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LotteryService {
    public List<Lotto> getTotalLottery(int lotteryCount){
        List<Lotto> totalLottery = new ArrayList<>();

        while(totalLottery.size() < lotteryCount){
            List<Integer> lotteryNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lottery = new Lotto(lotteryNumber);
            totalLottery.add(lottery);
        }

        return totalLottery;
    }
}
