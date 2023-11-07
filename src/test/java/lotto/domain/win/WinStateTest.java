package lotto.domain.win;

import java.util.Optional;
import java.util.stream.Stream;
import lotto.dto.LottoNumberMatchDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinStateTest {

    @DisplayName("일치하는 숫자와 보너스 번호 포함 여부에 대해 알맞는 당첨 여부를 반환할 수 있다.")
    @ParameterizedTest
    @MethodSource("ProvideNumberMatchDTOAndResult")
    void getWinStateTest(LottoNumberMatchDTO lottoNumberMatchDTO, Optional<WinState> expectedWinState) {
        // when
        Optional<WinState> winState = WinState.from(lottoNumberMatchDTO);

        // then
        Assertions.assertThat(winState)
                .isEqualTo(expectedWinState);
    }

    private static Stream<Arguments> ProvideNumberMatchDTOAndResult() {
        return Stream.of(
                Arguments.of(new LottoNumberMatchDTO(6, false), Optional.of(WinState.FIRST_PLACE)),
                Arguments.of(new LottoNumberMatchDTO(5, true), Optional.of(WinState.SECOND_PLACE)),
                Arguments.of(new LottoNumberMatchDTO(5, false), Optional.of(WinState.THIRD_PLACE)),
                Arguments.of(new LottoNumberMatchDTO(4, true), Optional.of(WinState.FOURTH_PLACE)),
                Arguments.of(new LottoNumberMatchDTO(4, false), Optional.of(WinState.FOURTH_PLACE)),
                Arguments.of(new LottoNumberMatchDTO(3, true), Optional.of(WinState.FIFTH_PLACE)),
                Arguments.of(new LottoNumberMatchDTO(3, false), Optional.of(WinState.FIFTH_PLACE)),
                Arguments.of(new LottoNumberMatchDTO(2, true), Optional.empty()),
                Arguments.of(new LottoNumberMatchDTO(0, false), Optional.empty())
        );
    }

}
