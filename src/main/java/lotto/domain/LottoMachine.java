package lotto.domain;

import lotto.utils.GameRules;

import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LottoMachine {

    private LottoMachine() {
    }

    public static Lottos buyLottos(Money money) {
        return Stream.generate(LottoNumberGenerator::pickNumbers)
                .map(Lotto::new)
                .limit(getLottoCount(money))
                .collect(collectingAndThen(toList(), Lottos::from));
    }

    private static int getLottoCount(Money money) {
        return money.getMoney() / GameRules.MINIMUN_UNIT.getValue();
    }
}
