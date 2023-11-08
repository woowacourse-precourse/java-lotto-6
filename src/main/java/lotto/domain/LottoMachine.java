package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.utils.GameRules;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LottoMachine {

    private LottoMachine() {
    }

    public static Lottos buyLottos(Money money) {
        return Stream.generate(LottoMachine::pickNumbers)
                .map(Lotto::new)
                .limit(getLottoCount(money))
                .collect(collectingAndThen(toList(), Lottos::from));
    }

    public static List<Integer> pickNumbers() {
        return Randoms.pickUniqueNumbersInRange(GameRules.START_RANGE.getValue(), GameRules.END_RANGE.getValue(), GameRules.NUMBERS_SIZE.getValue());
    }

    private static int getLottoCount(Money money) {
        return money.getMoney() / GameRules.MINIMUN_UNIT.getValue();
    }
}
