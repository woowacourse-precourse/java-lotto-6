package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoStore {
    private int lottoCount;
    private Lottos lottos = new Lottos();

    public LottoStore(int money) {
        this.lottoCount = money / 1000;
    }

    public Lottos buyLotto() {
        for(int i = 0; i < lottoCount; i++) {
            lottos.addLotto(createLotto(makeRandomNumbers()));
        }
        return lottos;
    }

    private Lotto createLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private List<Integer> makeRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
