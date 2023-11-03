package lotto.domain;

import java.util.Objects;

class LottoMachine {

    private static final String UNKNOWN_FACTORY_MESSAGE = "알 수 없는 로또 생성기로 로또 기계를 생성할 수 없습니다.";

    private final LottoFactory factory;

    public LottoMachine(LottoFactory factory) {
        this.factory = factory;
    }

    public static LottoMachine from(LottoFactory factory) {
        checkFactoryNonNUll(factory);

        return new LottoMachine(factory);
    }

    private static void checkFactoryNonNUll(LottoFactory factory) {
        if (Objects.isNull(factory)) {
            throw new IllegalArgumentException(UNKNOWN_FACTORY_MESSAGE);
        }
    }
}
