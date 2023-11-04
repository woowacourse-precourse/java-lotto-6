package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoWallet {
    static final int ZERO = 0;
    static final int MIN_NUMBER = 1;
    static final int MAX_NUMBER = 45;
    static final int NUMBERS_SIZE = 6;
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
