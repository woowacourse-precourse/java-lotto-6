package lotto.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.draw.DrawingResult;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoRank;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.WinningCombination;
import lotto.domain.money.Money;
import lotto.dto.input.MoneyDto;
import lotto.dto.input.WinningCombinationDto;
import lotto.dto.output.DrawingResultDto;
import lotto.dto.output.LottosDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMapperTest {

    @DisplayName("MoneyDTO를 Money로 매핑")
    @Test
    public void should_Map_Money_From_MoneyDto() {
        // given
        MoneyDto moneyDto = new MoneyDto(10000);

        // when
        Money money = LottoMapper.mapFrom(moneyDto);

        // then
        assertThat(money).isInstanceOf(Money.class);
    }

    @DisplayName("Lottos를 LottosDto로 매핑")
    @Test
    public void shouldMapLottosFromLottosDto() {
        // given
        Lotto lotto1 = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = Lotto.from(List.of(10, 21, 23, 33, 35, 45));
        Lotto lotto3 = Lotto.from(List.of(11, 25, 27, 32, 36, 43));
        Lottos lottos = Lottos.from(List.of(lotto1, lotto2, lotto3));

        // when
        LottosDto lottosDto = LottoMapper.mapFrom(lottos);

        // then
        assertThat(lottosDto).isInstanceOf(LottosDto.class);
    }

    @DisplayName("WinningCombinationDto를 WinningCombination로 매핑")
    @Test
    public void should_Map_WinningCombination_From_WinningCombinationDto() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningCombinationDto winningCombinationDto = new WinningCombinationDto(winningNumbers, bonusNumber);

        // when
        WinningCombination winningCombination = LottoMapper.mapFrom(winningCombinationDto);

        // then
        assertThat(winningCombination).isInstanceOf(WinningCombination.class);
    }

    @DisplayName("DrawingResult를 DrawingResultDto로 매핑")
    @Test
    public void should_Map_DrawingResult_From_DrawingResultDto() {
        // given
        DrawingResult drawingResult = new DrawingResult(new EnumMap<>(Map.of(
                LottoRank.FIRST, 1,
                LottoRank.SECOND, 2,
                LottoRank.THIRD, 3,
                LottoRank.FOURTH, 4,
                LottoRank.FIFTH, 5
        )));

        // when
        DrawingResultDto drawingResultDto = LottoMapper.mapFrom(drawingResult);

        // then
        assertThat(drawingResultDto).isInstanceOf(DrawingResultDto.class);
    }
}