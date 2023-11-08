package lotto.domain;

import lotto.domain.dto.input.WinningLottoRequest;
import lotto.domain.dto.output.DrawLottosResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

class DrawMachineTest {
    static Stream<Arguments> provideStatistic() {
        Lottos lottos = Lottos.from(List.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(10, 12, 15, 24, 34, 40))
                )
        );
        Map<DrawResult, Integer> drawResult = Map.of(
                DrawResult.FIRST, 0,
                DrawResult.SECOND, 0,
                DrawResult.THIRD, 0,
                DrawResult.FOURTH, 0,
                DrawResult.FIFTH, 1
        );
        double rateOfReturn = 250.0;
        return Stream.of(Arguments.of(lottos, drawResult, rateOfReturn));
    }


    @ParameterizedTest
    @MethodSource("provideStatistic")
    @DisplayName("당첨통계 및 수익률을 계산한다.")
    void createStatisticAndRateOfReturn(Lottos lottos, Map<DrawResult, Integer> drawResult, double rateOfReturn) {
        //given
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 14, 15, 16));
        LottoNumber bonusNumber = new LottoNumber(11);
        WinningLottoRequest winningLottoRequest = new WinningLottoRequest(winningNumbers, bonusNumber);
        DrawMachine drawMachine = DrawMachine.from(WinningLottoNumbers.from(winningLottoRequest));
        //when
        DrawLottosResponse actual = drawMachine.drawAll(lottos);
        //then
        Assertions.assertThat(new DrawLottosResponse(
                        drawResult.get(DrawResult.FIRST),
                        drawResult.get(DrawResult.SECOND),
                        drawResult.get(DrawResult.THIRD),
                        drawResult.get(DrawResult.FOURTH),
                        drawResult.get(DrawResult.FIFTH),
                        rateOfReturn))
                .isEqualTo(actual);
    }
}