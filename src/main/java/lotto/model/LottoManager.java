package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.utils.Constants;

public class LottoManager {
    private final int money;
    private final List<Lotto> lottos;
    private WinningLotto winningLotto;

    public LottoManager(final int money) {
        this.money = money;
        this.lottos = new ArrayList<>();
        createLottos();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public WinningLotto getWinningLotto() {
        return winningLotto;
    }

    public void setWinningLotto(final WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public void createLottos() {
        for (int i = 0; i < money / Constants.DIVIDE_UNIT; i++) {
            final Lotto lotto = new Lotto(generateLottoNumbers());
            lottos.add(lotto);
        }
    }

    private List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(Constants.MIN_GENERATE_VALUE, Constants.MAX_GENERATE_VALUE, Constants.LOTTO_SIZE);
    }
}