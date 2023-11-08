package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<Lotto>();
    private int countOfLotto;

    public Lottos(int inputCost) {
        LottoCount lottoCount = new LottoCount();
        countOfLotto = lottoCount.inputLottoCost(inputCost);
    }

    public List<Lotto> createLottos() {
        for (int i = 0; i < countOfLotto; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
