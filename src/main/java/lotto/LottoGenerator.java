package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoGenerator {

    public static List<Lotto> generateLotteries(int lottoAmount) {
        List<Lotto> lotteries = new ArrayList<>();
        while (lotteries.size() < lottoAmount) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(Unit.LOTTERY_MINIMUM_NUMBER.getUnit(),
                    Unit.LOTTERY_MAXIMUM_NUMBER.getUnit(), Unit.LOTTERY_NUMBER_COUNT.getUnit());
            List<Integer> lotteryNumbers = new ArrayList<>();
            lotteryNumbers.addAll(randomNumbers);
            lotteryNumbers.sort(Comparator.naturalOrder());
            lotteries.add(new Lotto(lotteryNumbers));
        }
        return lotteries;
    }
}
