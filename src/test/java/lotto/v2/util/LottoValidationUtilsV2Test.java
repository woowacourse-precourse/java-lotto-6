package lotto.v2.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


class LottoValidationUtilsV2Test {
    @Test
    @DisplayName("로또 번호가 6개가 아니면 예외를 던진다")
    void should_ThrowException_When_LottoNumbersSizeIsNotSix() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5); // 5 numbers, not 6

        // when & then
        assertThatThrownBy(() -> LottoValidationUtilsV2.checkValidLottoNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 6개여야 합니다.");
    }

    @Test
    @DisplayName("로또 번호가 6개일 때 예외를 던지지 않는다")
    void should_NotThrowException_When_LottoNumbersSizeIsSix() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // when & then
        assertThatNoException().isThrownBy(() -> LottoValidationUtilsV2.checkValidLottoNumbers(numbers));
    }

}