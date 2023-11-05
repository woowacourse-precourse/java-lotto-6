package lotto.controller.dto.input.builder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.controller.dto.input.DrawLottosDto;
import lotto.controller.exception.InvalidBuilderFieldsException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

final class DrawLottosDtoBuilderTest {
    @DisplayName("유효한 데이터로 필드를 채운 뒤 DrawLottosDto 생성 가능")
    @Test
    void builder_hasValidFields_shouldCreateLottosDto() {
        // given
        final String lottoNumbersInput = "1,2,3,4,5,6";
        final String bonusNumberInput = "7";

        // when
        final DrawLottosDto dto = DrawLottosDtoBuilder.builder()
                .lottoNumbers(lottoNumbersInput)
                .bonusNumber(bonusNumberInput)
                .build();

        // then
        for (int i = 0; i < 6; i++) {
            assertThat(dto.getLottoNumbers().get(i)).isEqualTo(i + 1);
        }
        assertThat(dto.getBonusNumber()).isEqualTo(7);
    }

    @DisplayName("모든 필드가 세팅되지 않은 경우, DrawLottosDto 생성 시 예외 발생")
    @Test
    void builder_isNotAllFieldsSet_shouldThrowException() {
        // given
        final String lottoNumbersInput = "1,2,3,4,5,6";
        final String bonusNumberInput = "7";

        // when
        final DrawLottosDtoBuilder builder1 = DrawLottosDtoBuilder.builder()
                .lottoNumbers(lottoNumbersInput);
        final DrawLottosDtoBuilder builder2 = DrawLottosDtoBuilder.builder()
                .bonusNumber(bonusNumberInput);

        // then
        assertThatThrownBy(builder1::build)
                .isInstanceOf(InvalidBuilderFieldsException.class)
                .hasMessage(InvalidBuilderFieldsException.INVALID_BUILDER_FIELDS_EXCEPTION_MESSAGE);

        assertThatThrownBy(builder2::build)
                .isInstanceOf(InvalidBuilderFieldsException.class)
                .hasMessage(InvalidBuilderFieldsException.INVALID_BUILDER_FIELDS_EXCEPTION_MESSAGE);
    }

    @DisplayName("유효하지 않은 데이터로 필드 설정 시, 예외 발생")
    @Test
    void builder_withInValidFields_shouldThrowException() {
        // given
        final String lottoNumbersInput1 = "123";
        final String lottoNumbersInput2 = "xxx";

        final String bonusNumberInput1 = "x";
        final String bonusNumberInput2 = "";

        // when
        final DrawLottosDtoBuilder builder = DrawLottosDtoBuilder.builder();
        // then
        assertThatThrownBy(() -> builder.lottoNumbers(lottoNumbersInput1))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> builder.lottoNumbers(lottoNumbersInput2))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> builder.bonusNumber(bonusNumberInput1))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> builder.bonusNumber(bonusNumberInput2))
                .isInstanceOf(IllegalArgumentException.class);

    }
}