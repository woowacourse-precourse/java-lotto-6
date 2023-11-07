package lotto.controller.dto.input.builder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.controller.dto.input.DrawLottosInput;
import lotto.controller.dto.input.DrawLottosInput.Builder;
import lotto.controller.exception.InvalidBuilderFieldsException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

final class DrawLottosInputBuilderTest {
    @DisplayName("유효한 데이터로 필드를 채운 뒤 DrawLottosDto 생성 가능")
    @Test
    void builder_hasValidFields_shouldCreateLottosDto() {
        // given
        final String lottoNumbersInput = "1,2,3,4,5,6";
        final String bonusNumberInput = "7";

        // when
        final DrawLottosInput dto = Builder.builder()
                .lottoNumbers(lottoNumbersInput)
                .bonusNumber(bonusNumberInput)
                .build();

        // then
        for (int i = 0; i < 6; i++) {
            assertThat(dto.getLottoNumbers().get(i)).isEqualTo(i + 1);
        }
        assertThat(dto.getBonusNumber()).isEqualTo(7);
    }


    @DisplayName("유효하지 않은 데이터로 lottoNumbers 필드 설정 시, 예외 발생")
    @Test
    void builder_withInvalidLottoNumbersField_shouldThrowException() {
        // given
        final String lottoNumbersInput1 = "123";
        final String lottoNumbersInput2 = "xxx";

        // when
        final Builder builder = Builder.builder();
        // then
        assertThatThrownBy(() -> builder.lottoNumbers(lottoNumbersInput1))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> builder.lottoNumbers(lottoNumbersInput2))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("lottoNumbers 필드 초기화 누락 상태에서 bonusNumber 설정 시, 예외 발생")
    @Test
    void setBonusNumber_withUninitLottoNumbersField_shouldThrowException() {
        // given
        final String bonusNumberInput = "x";

        // when
        final Builder builder = Builder.builder();
        // then

        assertThatThrownBy(() -> builder.bonusNumber(bonusNumberInput))
                .isInstanceOf(InvalidBuilderFieldsException.class);
    }

    @DisplayName("bonusNumber 필드가 세팅되지 않은 경우, build 시 예외 발생")
    @Test
    void builder_withBonusNumberUninit_shouldThrowException() {
        // given
        final String lottoNumbersInput = "1,2,3,4,5,6";

        // when
        final Builder builder1 = Builder.builder()
                .lottoNumbers(lottoNumbersInput);

        // then
        assertThatThrownBy(builder1::build)
                .isInstanceOf(InvalidBuilderFieldsException.class)
                .hasMessage(InvalidBuilderFieldsException.INVALID_BUILDER_FIELDS_EXCEPTION_MESSAGE);

    }

    @DisplayName("모든 필드 초기화 누락 상태에서 build 호출 시, 예외 발생")
    @Test
    void build_withUninitLottoNumbersField_shouldThrowException() {
        // given
        // when
        final Builder builder = Builder.builder();
        // then
        assertThatThrownBy(builder::build)
                .isInstanceOf(InvalidBuilderFieldsException.class);
    }
}