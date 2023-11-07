package lotto.domain;

import static lotto.constraint.LottoConstraint.TOTAL_NUMBERS_OF_LOTTO;
import static lotto.constraint.LottoConstraint.LOTTO_MINIMUM_BOUND;
import static lotto.constraint.LottoConstraint.LOTTO_MAXIMUM_BOUND;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private LottoMachine() {
    }

    public List<Lotto> purchaseLotto(int gameCount) {
        List<Lotto> playerLotto = new ArrayList<>();
        int publishCount = 1;

        while (publishAllLotto(publishCount, gameCount)) {
            playerLotto.add(new Lotto(createLottoNumbers()));

            publishCount++;
        }

        return playerLotto;
    }

    private List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                LOTTO_MINIMUM_BOUND.getValue(), LOTTO_MAXIMUM_BOUND.getValue(), TOTAL_NUMBERS_OF_LOTTO.getValue());
    }

    private boolean publishAllLotto(int publishCount, int gameCount) {
        return publishCount == gameCount;
    }
}