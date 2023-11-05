package lotto.Service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Model.Lotto;
import java.util.List;
import lotto.Model.Prize;


public class LottoMachine {

    public static Integer lottoCount(Integer price) {
        return price / 1000;
    }

    public static List<Integer> makeRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static void countStatistics(List<Lotto> lottos, List<Integer> winningNumbers,
            Integer bonusNumber) {
        for (Lotto lotto : lottos) {
            Prize prize = lotto.checkWinningNumber(winningNumbers, bonusNumber);
            prize.setCount(prize.getCount() + 1);
        }
    }

    public static double calculaateProfit(Integer price) {
        double profit =
                ((Prize.SIX.getPrice() * Prize.SIX.getCount()) + (Prize.FIVE_BONUS.getPrice()
                        * Prize.FIVE_BONUS.getCount()) + (Prize.FIVE.getPrice()
                        * Prize.FIVE.getCount()) + (Prize.FOUR.getPrice() * Prize.FOUR.getCount())
                        + (Prize.THREE.getPrice() * Prize.THREE.getCount())) * 100 / price;
        return Math.round(profit * 10) / 10.0;
    }
}
