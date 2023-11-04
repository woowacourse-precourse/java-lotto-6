package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private int lottoNum;
    private final List<Lotto> lottos = new ArrayList<>();

    public void setLottoNum(int lottoNum) {
        this.lottoNum = lottoNum;
    }

    public void setLottos() {
        for (int i = 0; i < this.lottoNum; i++) {
            this.lottos.add(makeLottoNum());
        }
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    private static Lotto makeLottoNum() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
