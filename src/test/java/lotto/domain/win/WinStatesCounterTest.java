package lotto.domain.win;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningLottoNumbers;
import lotto.dto.WinStateInformationDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinStatesCounterTest {

    @DisplayName("당첨 번호와 로또 번호들이 주어졌을 때, 올바른 당첨 횟수들을 추출해낸다.")
    @ParameterizedTest
    @MethodSource("ProvideWinningNumbers")
    void getWinStateInformationTest(WinningLottoNumbers winningLottoNumbers, List<Lotto> lotteries,
            List<WinStateInformationDTO> expectedWinStateInformationDTOs) {
        // when
        WinStatesCounter winStatesCounter = new WinStatesCounter(winningLottoNumbers, lotteries);
        List<WinStateInformationDTO> winStateInformationDTOs = winStatesCounter.getWinStateInformationDTOs();

        // then
        Assertions.assertThat(winStateInformationDTOs)
                .isEqualTo(expectedWinStateInformationDTOs);
    }

    private static Stream<Arguments> ProvideWinningNumbers() {
        return Stream.of(
                Arguments.of(
                        new WinningLottoNumbers(List.of(1, 2, 3, 4, 5, 6), 7),
                        List.of(
                                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                                new Lotto(List.of(1, 2, 3, 5, 6, 10)),
                                new Lotto(List.of(1, 2, 3, 6, 11, 10)),
                                new Lotto(List.of(1, 2, 3, 12, 11, 10)),
                                new Lotto(List.of(1, 2, 13, 12, 11, 10))
                        ),
                        List.of(
                                WinState.FIRST_PLACE.getWinStateInformation(1),
                                WinState.SECOND_PLACE.getWinStateInformation(1),
                                WinState.THIRD_PLACE.getWinStateInformation(1),
                                WinState.FOURTH_PLACE.getWinStateInformation(1),
                                WinState.FIFTH_PLACE.getWinStateInformation(1),
                                WinState.NONE.getWinStateInformation(1)
                        )
                )
        );
    }

}
