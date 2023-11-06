package lotto;

import static lotto.constants.ConstantValues.*;

public class LottoChecker {
    public static int checkLotto(Lotto lotto, Lotto winLotto) {
        int count = 0;
        for (int i = 0; i < LOTTO_LENGTH.getValue(); i++) {
            if (lotto.getLotto().get(i) == winLotto.getLotto().get(i)) {
                count++;
            }
        }
        return count;
    }

}
