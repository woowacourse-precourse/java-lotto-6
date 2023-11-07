package lotto.domain;

import static lotto.utils.ErrorMessages.LOTTO_STORE_IS_NULL;

import java.util.Objects;

public class LottoStore {
    private final LottoMachine lottoMachine;


    public Lottos issue(Money money, LottoIssuePolicy lottoIssuePolicy) {
        int quantity = money.getBuyLottoQuantity();
        return new Lottos(lottoMachine.issue(quantity, lottoIssuePolicy));
    }

}
