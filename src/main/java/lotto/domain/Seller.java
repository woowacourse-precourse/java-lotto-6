package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Seller {
    public static Integer numberOfLotto(Integer price) {
        return price / LottoInfo.PRICE_UNIT.number();
    }

    public static List<Lotto> makeLottos(Integer numberOfLotto) {
        List<Lotto> lottos = new ArrayList<>();

        for (Integer count = 0; count < numberOfLotto; count++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                    LottoInfo.MIN_NUMBER.number(),
                    LottoInfo.MAX_NUMBER.number(),
                    LottoInfo.NUMBER_COUNT.number()
            );

            lottos.add(new Lotto(numbers));
        }

        return lottos;
    }
}
