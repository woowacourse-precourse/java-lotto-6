package lotto.domain.lottoManage;

import lotto.domain.lotto.Lotto;
import lotto.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    private LottoGenerator() {

    }

    public static List<Lotto> generateWinningLottos(int purchasedLottoCount) {
        List<Lotto> winningLottos = new ArrayList<>();
        for (int i = 0; i < purchasedLottoCount; i++) {
            winningLottos.add(generateWinningLotto());
        }
        return winningLottos;
    }

    private static Lotto generateWinningLotto() {
        return Lotto.create(RandomUtil.generateRandomLottoNumber());
    }
}
