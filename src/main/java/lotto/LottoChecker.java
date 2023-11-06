package lotto;

import static lotto.constants.ConstantValues.*;

public class LottoChecker {
    public static int checkLotto(Lotto lotto, Lotto winLotto) {
        int count = 0;
        for (int number : lotto.getNumbers()) {
            if (winLotto.getNumbers().contains(number)) {
                count++;
            }
        }
        return count;
    }

}
