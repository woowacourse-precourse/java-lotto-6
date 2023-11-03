package lotto;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final int lottoCount;
    private final List<Lotto> lottos;

    public User(int price) {
        this.lottoCount = price / Const.priceUnit;
        this.lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(Lotto.createWinningNumbers());
        }
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
