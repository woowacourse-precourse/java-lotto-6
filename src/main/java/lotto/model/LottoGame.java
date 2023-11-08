package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private int numLotto;
    private List<Lotto> lottoGames = new ArrayList<>(5);

    public LottoGame() {
    }

    public LottoGame(int money) {
        this.numLotto = money / 1_000;
    }

    public LottoGame(int money, List<Lotto> lotto) {
        this.numLotto = money / 1_000;
        this.lottoGames = lotto;
    }

    public void createLotto(int lottoNum) {
        this.numLotto = lottoNum;
        for (int i = 0; i < lottoNum; i++) {
            List<Integer> lottoNumber = createLottoNumber();
            Lotto lotto = new Lotto(lottoNumber);
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
