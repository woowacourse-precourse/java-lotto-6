package lotto.mapper;

import java.util.List;
import lotto.domain.lotto.Lottos;
import lotto.domain.money.Money;
import lotto.dto.input.MoneyDto;
import lotto.dto.output.LottoDto;
import lotto.dto.output.LottosDto;

public class LottoMapper {

    public static Money mapFrom(MoneyDto moneyDto) {
        int money = moneyDto.money();
        return Money.fromInitialMoney(money);
    }

    public static LottosDto mapFrom(Lottos lottos) {
        List<LottoDto> lottosDto = lottos.getLottos().stream()
                .map(LottoDto::toLottoDto)
                .toList();
        return new LottosDto(lottosDto);
    }
}
