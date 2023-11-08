package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoPurchaseAmount;
import lotto.domain.LottoTickets;

/**
 * @author 민경수
 * @description lotto generator
 * @since 2023.11.04
 **********************************************************************************************************************/
public class LottoGenerator {

    public static LottoTickets buyLottos(LottoPurchaseAmount amount) {
        List<Lotto> lottos = new ArrayList<>();

        while (amount.isBuyable()) {
            List<Integer> integers = Randoms.pickUniqueNumbersInRange(
                    Lotto.VALID_MIN_NUMBER,
                    Lotto.VALID_MAX_NUMBER,
                    Lotto.VALID_NUMBER_SIZE
            );

            lottos.add(Lotto.of(integers));

            amount.subtractOnePriceUnit();
        }

        return LottoTickets.of(lottos);
    }

}