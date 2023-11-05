package lotto.domain.lotto;

import lotto.domain.common.Money;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class LottoMachine {

    private static final Money LOTTO_PRICE = Money.from(1000);
    private static final String UNKNOWN_FACTORY_MESSAGE = "알 수 없는 로또 생성기로 로또 기계를 생성할 수 없습니다.";
    private static final String INVALID_MONEY_MESSAGE =
            "금액을 " + LOTTO_PRICE.getValue() + Money.CURRENCY + " 단위로 입력해주세요.";

    private final LottoFactory factory;

    private LottoMachine(LottoFactory factory) {
        this.factory = factory;
    }

    public static LottoMachine from(LottoFactory factory) {
        checkFactoryNonNull(factory);

        return new LottoMachine(factory);
    }

    private static void checkFactoryNonNull(LottoFactory factory) {
        if (Objects.isNull(factory)) {
            throw new IllegalArgumentException(UNKNOWN_FACTORY_MESSAGE);
        }
    }

    public List<Lotto> issueWith(Money money) {
        checkHasRemainderWith(money);

        return issue((int) money.divide(LOTTO_PRICE));
    }

    private void checkHasRemainderWith(Money money) {
        if (money.hasRemainderWith(LOTTO_PRICE)) {
            throw new IllegalArgumentException(INVALID_MONEY_MESSAGE);
        }
    }

    private List<Lotto> issue(int maxCount) {
        List<Lotto> lottos = new ArrayList<>();
        IntStream.range(0, maxCount)
                .forEach((count) -> lottos.add(factory.create()));

        return Collections.unmodifiableList(lottos);
    }
}
