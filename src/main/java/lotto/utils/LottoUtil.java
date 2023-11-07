package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lotto.data.Lotto;
import lotto.domain.LottoGenerator;
import lotto.message.ErrorMessage;

public class LottoUtil {

    public static List<Lotto> generateLottos(BigDecimal numberOfLottoPurchased, LottoGenerator lottoGenerator) {
        List<Lotto> lottos = new ArrayList<>();
        while (numberOfLottoPurchased.compareTo(BigDecimal.ZERO) > 0) {
            lottos.add(lottoGenerator.generate());
            numberOfLottoPurchased = numberOfLottoPurchased.subtract(BigDecimal.ONE);
        }
        return lottos;
    }

    public static Lotto generateLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }


}
