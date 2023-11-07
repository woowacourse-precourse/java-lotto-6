package lotto.service.mapper;

import lotto.controller.dto.input.BuyLottosInput;
import lotto.domain.money.Money;
import lotto.domain.money.Wallet;

/**
 * Dto와 Domain 간의 매핑을 담당
 */
public final class WalletFromDtoMapper {

    /**
     * BuyLottosDto -> Wallet(Domain) 변환
     */
    public static Wallet from(final BuyLottosInput dto) {
        final Money money = Money.from(dto.getAmount());
        return new Wallet(money);
    }
}
