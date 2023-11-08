package lotto.model.lotto;

import static lotto.utils.random.RandomNumberGenerator.getRandomNumbersInLottoRange;

import java.util.ArrayList;
import java.util.List;
import lotto.model.money.LottoCount;

public class Lottos {

    private List<Lotto> lottos;

    private Lottos(int count) {
        this.lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(getRandomNumbersInLottoRange()));
        }
    }

    public static Lottos of(LottoCount lottoCount) {
        return new Lottos(lottoCount.lottoCount());
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public String getLottosInfo() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto.printLottoInfo());
        }

        return sb.toString();
    }
}
