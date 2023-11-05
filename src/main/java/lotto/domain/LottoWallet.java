package lotto.domain;

import static lotto.constant.GeneralConstant.ZERO;
import static lotto.constant.GeneralConstant.MIN_NUMBER;
import static lotto.constant.GeneralConstant.MAX_NUMBER;
import static lotto.constant.GeneralConstant.NUMBERS_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoWallet {
    private final List<Lotto> LOTTOS = new ArrayList<Lotto>();

    public LottoWallet() {}

    public void addLotto(int number) {
        clearLottos();
        for (int i = ZERO; i < number; i++) {
            LOTTOS.add(new Lotto(pickNumbers()));
        }
    }

    private void clearLottos() {
        LOTTOS.clear();
    }

    private List<Integer> pickNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBERS_SIZE);
    }

    public List<Lotto> getLottos() {
        return LOTTOS;
    }
}
