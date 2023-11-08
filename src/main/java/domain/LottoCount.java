package domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class LottoCount {

    private int lottoCount;
    private List<Lotto> lotties;

    public LottoCount(int lottoCount) {
        this.lottoCount = lottoCount / 1000;
        setLotties();
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public List<Lotto> getLotties() {
        return lotties;
    }

    private void setLotties() {
        this.lotties = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            this.lotties.add(new Lotto(numbers));
        }
    }

}
