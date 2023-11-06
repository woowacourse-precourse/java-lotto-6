package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Seller {
    public static Integer numberOfLotto(Integer price) {
        return price / LottoInfo.PRICE_UNIT.number();
    }

    public static List<Lotto> makeLottos(Integer numberOfLotto) {
        List<Lotto> lottos = new Vector<>();

        for (Integer count = 0; count < numberOfLotto; count++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                    LottoInfo.MIN_NUMBER.number(),
                    LottoInfo.MAX_NUMBER.number(),
                    LottoInfo.NUMBER_COUNT.number()
            );

            List<Integer> sortedNumbers = new ArrayList<>(numbers);
            sortedNumbers.sort(Comparator.naturalOrder());

            lottos.add(new Lotto(sortedNumbers));
        }

        return lottos;
    }
}
