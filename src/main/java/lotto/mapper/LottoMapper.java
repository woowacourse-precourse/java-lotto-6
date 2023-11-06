package lotto.mapper;

import java.util.EnumMap;
import java.util.List;
import lotto.domain.draw.PrizeStatistics;
import lotto.domain.lotto.BonusNumber;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoRank;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.WinningCombination;
import lotto.domain.money.Money;
import lotto.dto.input.MoneyDto;
import lotto.dto.input.WinningCombinationDto;
import lotto.dto.output.DrawingResultDto;
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

    public static WinningCombination mapFrom(WinningCombinationDto winningCombinationDto) {
        List<Integer> numbers = winningCombinationDto.winningNumbers();
        Lotto winningNumbers = Lotto.from(numbers);
        int number = winningCombinationDto.bonusNumber();
        BonusNumber bonusNumber = BonusNumber.from(number);
        return WinningCombination.of(winningNumbers, bonusNumber);
    }

    public static DrawingResultDto mapFrom(PrizeStatistics prizeStatistics) {
        EnumMap<LottoRank, Integer> result = prizeStatistics.getDrawingResult();
        return new DrawingResultDto(
                result.get(LottoRank.FIRST),
                result.get(LottoRank.SECOND),
                result.get(LottoRank.THIRD),
                result.get(LottoRank.FOURTH),
                result.get(LottoRank.FIFTH),
                prizeStatistics.calculateProfitRate()
        );
    }
}
