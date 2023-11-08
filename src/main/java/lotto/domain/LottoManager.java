package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoManager {
    private final List<Lotto> lottos;

    public LottoManager(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    private List<Integer> generateUniqueRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public Lotto createLotto() {
        return new Lotto(generateUniqueRandomNumber());
    }

    public void add (Lotto lotto) {
        lottos.add(lotto);
    }
    public void renderAllLotte() {
        for (Lotto lotto : lottos) {
            lotto.showLottoNumber();
        }
    }
}
