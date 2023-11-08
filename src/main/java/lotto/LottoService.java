package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private int getNumberOfLotto(int price) {
        return price / 1000;
    }

    public List<Lotto> createLotto(int price) {
        List<Lotto> lottos = new ArrayList<>();
        int number = getNumberOfLotto(price);

        for (int i = 0; i < number; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }

        return lottos;
    }

    public Prize[] compare(List<Lotto> userLotto, List<Integer> winNumber, int bonusNumber) {
        Prize[] prizes = Prize.values();
        for (Lotto lotto : userLotto) {
            prizes[getPrize(lotto, winNumber, bonusNumber)].addCount();
        }

        return prizes;
    }

    public int getPrize(Lotto lotto, List<Integer> winNumber, int bonusNumber) {
        if (getSameNumber(lotto, winNumber) < 3) {
            return 0;
        }

        if (hasBonusNumber(lotto, bonusNumber) && getSameNumber(lotto, winNumber) == 5) {
            return 5;
        }

        return getSameNumber(lotto, winNumber) - 2;
    }

    private int getSameNumber(Lotto lotto, List<Integer> winNumber) {
        int count = 0;
        for (int i = 0; i < 6; i++) {
            if (winNumber.contains(lotto.get(i))) {
                count++;
            }
        }
        return count;
    }

    private boolean hasBonusNumber(Lotto lotto, int bonusNumber) {
        for (int i = 0; i < 6; i++) {
            if (lotto.get(i) == bonusNumber) {
                return true;
            }
        }
        return false;
    }

    public double getStatistics(Prize[] prizes, int numberOfLotto) {
        double profit = 0;
        List<Integer> stats = new ArrayList<>();
        int[] prices = {0, 5000, 50000, 1500000, 2000000000, 30000000};

        for (int i = 1; i < prizes.length; i++) {
            profit += prizes[i].getCount() * prices[i];
        }
        profit = profit / (numberOfLotto * 1000) * 100;
        profit = Math.round(profit * 10) / 10.0;
        return profit;
    }
}
