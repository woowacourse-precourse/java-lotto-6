package lotto.domain.win;

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
    void getWinStateTest(LottoNumberMatchDTO lottoNumberMatchDTO, WinState expectedWinState) {
        // when
        WinState winState = WinState.from(lottoNumberMatchDTO);

        // then
        Assertions.assertThat(winState)
                .isEqualTo(expectedWinState);
    }

    private static Stream<Arguments> ProvideNumberMatchDTOAndResult() {
        return Stream.of(
                Arguments.of(new LottoNumberMatchDTO(6, false), WinState.FIRST_PLACE),
                Arguments.of(new LottoNumberMatchDTO(5, true), WinState.SECOND_PLACE),
                Arguments.of(new LottoNumberMatchDTO(5, false), WinState.THIRD_PLACE),
                Arguments.of(new LottoNumberMatchDTO(4, true), WinState.FOURTH_PLACE),
                Arguments.of(new LottoNumberMatchDTO(4, false), WinState.FOURTH_PLACE),
                Arguments.of(new LottoNumberMatchDTO(3, true), WinState.FIFTH_PLACE),
                Arguments.of(new LottoNumberMatchDTO(3, false), WinState.FIFTH_PLACE),
                Arguments.of(new LottoNumberMatchDTO(2, true), WinState.NONE),
                Arguments.of(new LottoNumberMatchDTO(0, false), WinState.NONE)
        );
    }

}
