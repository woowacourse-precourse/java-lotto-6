package lotto.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.LottoErrorMessage;

public class Store {
    public static List<Lotto> sellLottos(Integer money) {
        List<Lotto> lottos = new ArrayList<Lotto>();
        validateDividedByPrice(money);

        for (int i = 0; i < money / Lotto.PRICE; i++) {
            List<Integer> lottoNumbers = pickUniqueNumbersInRange(Lotto.FIRST_NUMBER, Lotto.LAST_NUMBER, Lotto.SIZE);
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }

        return lottos;
    }

    private static void validateDividedByPrice(Integer money) {
        if (money % Lotto.PRICE != 0) {
            throw new IllegalArgumentException(LottoErrorMessage.THOUSAND_MULTIPLE_PRICE);
        }
    }
}
