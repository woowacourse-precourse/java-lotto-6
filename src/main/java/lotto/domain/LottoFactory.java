package lotto.domain;

import lotto.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {

    public static Lottos createLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        while (lottos.size() < lottoCount) {
            lottos.add(createLotto());
        }

        return new Lottos(lottos);
    }

    private static Lotto createLotto() {
        return new Lotto(RandomUtil.createRandomNumbers());
    }
}
