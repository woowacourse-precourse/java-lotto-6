package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import lotto.util.NumberConst;

public class PlayerLotto {
    private List<Integer> playerLotto;

    public PlayerLotto() {
        this.playerLotto = Randoms.pickUniqueNumbersInRange(NumberConst.MIN_RANGE, NumberConst.MAX_RANGE,
                NumberConst.LOTTO_SIZE);
        Collections.sort(playerLotto);
    }

    @Override
    public String toString() {
        return playerLotto.toString();
    }
}
