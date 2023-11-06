package lotto.domain.lotto;

import java.util.List;
import java.util.stream.Stream;
import lotto.dto.LottoNumberMatchDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningLottoNumbersTest {

    private List<Integer> numbers;

    @BeforeEach
    void setup() {
        numbers = List.of(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("보너스 번호가 당첨 번호에 대해")
    @Nested
    class include {

        @DisplayName("포함된다면 예외가 발생한다.")
        @Test
        void winningNumbersIncludeBonusNumber() {
            // given
            int bonusNumber = 3;

            // when & then
            Assertions.assertThatThrownBy(() -> new WinningLottoNumbers(numbers, bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(LottoExceptionMessages.DUPLICATED_BONUS_NUMBER.getMessage());
        }

        @DisplayName("포함되지 않는다면 예외가 발생하지 않는다.")
        @Test
        void winningNumbersExcludeBonusNumber() {
            // given
            int bonusNumber = 7;

            // when & then
            Assertions.assertThatCode(() -> new WinningLottoNumbers(numbers, bonusNumber))
                    .doesNotThrowAnyException();
        }

    }

    @DisplayName("당첨 번호에 로또 번호를 비교 시 DTO를 올바르게 반환한다.")
    @ParameterizedTest
    @MethodSource("provideLottoNumbersAndExpectedDTO")
    void getMatchDtoTest(WinningLottoNumbers winningLottoNumbers, LottoNumberMatchDTO expectedDTO) {
        // given
        Lotto lotto = new Lotto(numbers);

        // when
        LottoNumberMatchDTO resultDTO = winningLottoNumbers.getMatchDTO(lotto);

        // then
        Assertions.assertThat(resultDTO)
                .isEqualTo(expectedDTO);
    }


    static Stream<Arguments> provideLottoNumbersAndExpectedDTO() {
        return Stream.of(
                Arguments.of(
                        new WinningLottoNumbers(List.of(1, 2, 3, 4, 5, 6), 45),
                        new LottoNumberMatchDTO(6, false)
                ),
                Arguments.of(
                        new WinningLottoNumbers(List.of(1, 2, 3, 43, 44, 45), 6),
                        new LottoNumberMatchDTO(3, true)
                ),
                Arguments.of(
                        new WinningLottoNumbers(List.of(39, 40, 41, 42, 43, 44), 45),
                        new LottoNumberMatchDTO(0, false)
                )
        );
    }

}
