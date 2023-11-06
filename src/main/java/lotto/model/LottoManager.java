package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    private final int money;
    private List<Lotto> lottos = new ArrayList<>();
    private WinningLotto winningLotto;

    public LottoManager(final int money) {
        this.money = money;
        this.lottos = createLottos();
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

    public List<Lotto> createLottos() {
        for (int i = 0; i < money / 1000; i++) {
            List<Integer> numbers = generateLottoNumbers();
            Lotto newLotto = new Lotto(numbers);
            lottos.add(newLotto);
        }
        return lottos;
    }

    private List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
