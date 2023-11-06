package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Seller {
    private static final Integer NUMBER_COUNT = 6;
    private static final Integer UNIT = 1000;
    private static final Integer MINIMUM_RANGE = 1;
    private static final Integer MAXIMUM_RANGE = 45;

    public static Integer numberOfLotto(Integer price) {
        return price / UNIT;
    }

    public static List<Lotto> makeLottos(Integer numberOfLotto) {
        List<Lotto> lottos = new ArrayList<>();

        for (Integer count = 0; count < numberOfLotto; count++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MINIMUM_RANGE, MAXIMUM_RANGE, NUMBER_COUNT);

            lottos.add(new Lotto(numbers));
        }

        return lottos;
    }
}
