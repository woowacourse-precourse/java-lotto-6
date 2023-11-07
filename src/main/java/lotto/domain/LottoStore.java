package lotto.domain;

import static lotto.utils.ErrorMessages.LOTTO_STORE_IS_NULL;

import java.util.Objects;

public class LottoStore {
    private final LottoMachine lottoMachine;
    private static final LottoStore INSTANCE = new LottoStore();

    private LottoStore() {
        this.lottoMachine = LottoMachine.getInstance();
    }

    public static LottoStore getInstance() {
        validateNonNull();
        return INSTANCE;
    }

    private static void validateNonNull() {
        if (Objects.isNull(INSTANCE)) {
            throw new IllegalArgumentException(LOTTO_STORE_IS_NULL);
        }
    }

    public Lottos issue(Money money, LottoIssuePolicy lottoIssuePolicy) {
        int quantity = money.getBuyLottoQuantity();
        return new Lottos(lottoMachine.issue(quantity, lottoIssuePolicy));
    }


}
