package lotto.service.mapper;

import lotto.controller.dto.input.BuyLottosDto;
import lotto.domain.money.Money;
import lotto.domain.money.Wallet;

/**
 * Dto와 Domain 간의 매핑을 담당
 */
public final class WalletFromDtoMapper {

    /**
     * BuyLottosDto -> Wallet(Domain) 변환
     */
    public static Wallet mapFrom(final BuyLottosDto dto) {
        final Money money = Money.from(dto.getAmount());
        return new Wallet(money);
    }
}
