package lotto.validator;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.constant.TestConstant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberValidatorTest {

    @DisplayName("유효한 로또 번호가 주어졌을 때 유효성 검사를 통과한다.")
    @Test
    void 유효한_로또_번호_길이() {
        List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);

        assertThatCode(() -> LottoNumberValidator.isValid(validNumbers)).doesNotThrowAnyException();
    }

    @DisplayName("로또 번호 리스트의 길이가 올바르지 않을 때 예외가 발생한다.")
    @Test
    void 로또_번호_리스트_길이가_올바르지_않을_때_예외_발생() {
        List<Integer> invalidNumbers = List.of(1, 2, 3, 4, 5);

        assertThatThrownBy(() -> LottoNumberValidator.isValid(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(TestConstant.ERROR_MESSAGE);
    }

    @DisplayName("문자열에서 정수 리스트로 변환한다.")
    @Test
    void 문자열에서_정수_리스트로_변환_검사() {
        String winningNumbers = "1, 2, 3, 4, 5, 6";

        List<Integer> expectedNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> actualNumbers = LottoNumberValidator.convertStringToList(winningNumbers);

        assertThat(actualNumbers).isEqualTo(expectedNumbers);
    }

    @DisplayName("잘못된 형식의 문자열에서 변환 시 예외가 발생한다.")
    @Test
    void 잘못된_형식의_문자열_변환_시_예외_발생() {
        String invalidNumbersString = "a, b, c, d, e, f";

        assertThatThrownBy(() -> LottoNumberValidator.convertStringToList(invalidNumbersString))
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining(TestConstant.ERROR_MESSAGE);
    }
}
