package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.utils.Constants;

public class LottoManager {
    private final List<Lotto> lottos;
    private final WinningLotto winningLotto;

    public LottoManager(final List<Lotto> lottos, final WinningLotto winningLotto) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public WinningLotto getWinningLotto() {
        return winningLotto;
    }

    public static List<Lotto> createLottos(final int money) {
        final List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < money / Constants.DIVIDE_UNIT; i++) {
            final Lotto lotto = new Lotto(generateLottoNumbers());
            lottos.add(lotto);
        }
        return lottos;
    }

    private static List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(Constants.MIN_GENERATE_VALUE, Constants.MAX_GENERATE_VALUE, Constants.LOTTO_SIZE);
    }
}