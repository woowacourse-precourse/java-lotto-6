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

    public void compare(List<Lotto> userLotto, List<Integer> winNumber, int bonusNumber) {
        for (Lotto lotto : userLotto) {
            System.out.println(getSameNumber(lotto, winNumber) + " " + hasBonusNumber(lotto,bonusNumber));
        }
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
}
