package lotto.domain.lotto;

import lotto.Lotto;
import lotto.domain.Money;

import java.util.ArrayList;
import java.util.List;

public record LottoBuyer(List<Lotto> lottos, Money paidMoney) {

    @Override
    public List<Lotto> lottos() {
        return new ArrayList<>(lottos);
    }
}
