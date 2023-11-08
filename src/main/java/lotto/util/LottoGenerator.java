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
        return generateLotto(lottoCount);
    }

    public static Lottos generateLotto(LottoCount lottoCount) {
        int count = lottoCount.getLottoCount();
        List<Lotto> lottoList = new ArrayList<>();
        Lottos lottos = new Lottos(lottoList);

        while (count > 0) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(LottoNumber.MIN_RANGE, LottoNumber.MAX_RANGE,
                    LottoNumber.LOTTO_SIZE));
            lottos.addLotto(lotto);
            count--;
        }
        return lottos;
    }
}
