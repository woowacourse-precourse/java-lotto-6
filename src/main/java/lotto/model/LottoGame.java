package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private final int numLotto;
    private final List<Lotto> lottoGames = new ArrayList<>(5);

    public LottoGame(int money) {
        this.numLotto = money / 1_000;
    }

    public void createLotto() {
        for (int i = 0; i < this.numLotto; i++) {
            List<Integer> lottoNum = createLottoNumber();
            Lotto lotto = new Lotto(lottoNum);
            lottoGames.add(lotto);
        }
    }

    private List<Integer> createLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Lotto> getLottoGames() {
        return this.lottoGames;
    }

    public int getLottoNumber() {
        return this.numLotto;
    }
}
