package lotto.controller.dto;

import lotto.model.domain.vo.Lottos;
import lotto.model.domain.vo.Money;

public class MoneyLottosDto {

    private Money money;
    private Lottos lottos;

    private MoneyLottosDto(Money money, Lottos lottos) {
        this.money = money;
        this.lottos = lottos;
    }

    public static MoneyLottosDto from(Money money, Lottos lottos) {
        return new MoneyLottosDto(money, lottos);
    }

    public Money getMoney() {
        return money;
    }

    public Lottos getLottos() {
        return lottos;
    }
}
