package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lotto.data.Lotto;
import lotto.domain.LottoGenerator;

public class LottoUtil {

    public static List<Lotto> generateLottos(BigDecimal numberOfLottoPurchased, LottoGenerator lottoGenerator) {
        List<Lotto> lottos = new ArrayList<>();
        while (numberOfLottoPurchased.compareTo(BigDecimal.ZERO) > 0) {
            lottos.add(lottoGenerator.generate());
            numberOfLottoPurchased = numberOfLottoPurchased.subtract(BigDecimal.ONE);
        }
        return lottos;
    }

    public static Lotto generateRandomLotto(int rangeStartNumber, int rangeEndNumber, int digits) {
        return new Lotto(Randoms.pickUniqueNumbersInRange(rangeStartNumber, rangeEndNumber, digits));
    }
}
