package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.List;

public class Controller {
    public int getLottoCount(int userMoney) {
        if (userMoney % Lotto.PRICE != 0) {
            throw new IllegalArgumentException("[ERROR]");
        }

        return userMoney / Lotto.PRICE;
    }

    public List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}