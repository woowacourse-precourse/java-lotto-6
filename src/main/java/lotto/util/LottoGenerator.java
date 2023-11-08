package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoCount;
import lotto.model.Lottos;
import lotto.model.constant.LottoNumber;

public class LottoGenerator {
    private LottoGenerator() {
        throw new IllegalArgumentException("[ERROR]");
    }

    public static Lottos generateLottos(LottoCount lottoCount) {
        List<Lotto> lottos = generateRandomLottos(lottoCount.getLottoCount());
        return new Lottos(lottos);
    }

    private static List<Lotto> generateRandomLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = generateLotto();
            lottos.add(lotto);
        }
        return lottos;
    }

    private static Lotto generateLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(
                LottoNumber.MIN_RANGE, LottoNumber.MAX_RANGE, LottoNumber.LOTTO_SIZE);
        return new Lotto(randomNumbers);
    }
}