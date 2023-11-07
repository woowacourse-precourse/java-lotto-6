package lotto.controller.dto.input;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

final class DrawLottosInputTest {
    @DisplayName("유효한 로또 번호와 보너스 번호로 DrawLottosDto를 생성할 수 있다.")
    @Test
    void DrawLottosDto_withValidLottoNumbersAndBonusNumber_shouldCreateInstance() {
        // given
        final List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        final int bonusNumber = 7;

        // when
        final DrawLottosInput drawLottosInput = new DrawLottosInput(lottoNumbers, bonusNumber);

        // then
        assertThat(drawLottosInput.getLottoNumbers()).isEqualTo(lottoNumbers);
        assertThat(drawLottosInput.getBonusNumber()).isEqualTo(bonusNumber);
    }

    @DisplayName("유효하지 않은 로또 번호 입력으로 DrawLottosDto 생성 시 예외 발생.")
    @ParameterizedTest
//    @NullAndEmptySource
    @ValueSource(strings = {"123", "xxx", "1.2.3"})
    void DrawLottosDto_withInvalidLottoNumbers_shouldThrowException(final String lottoNumbersInput) {
        // given
        final String bonusNumberInput = "7";
        // when
        // then
        assertThatThrownBy(() ->
                DrawLottosInput.from(lottoNumbersInput, bonusNumberInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유효하지 않은 보너스 번호 입력으로 DrawLottosDto 생성 시 예외 발생.")
    @ParameterizedTest
//    @NullAndEmptySource
    @ValueSource(strings = {"x", ".", "1000j"})
    void DrawLottosDto_withInvalidBonusNumber_shouldThrowException(final String bonusNumberInput) {
        // given
        final String lottoNumbersInput = "1,2,3,4,5,6";
        // when
        // then
        assertThatThrownBy(() ->
                DrawLottosInput.from(lottoNumbersInput, bonusNumberInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}