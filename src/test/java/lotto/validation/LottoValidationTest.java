
package lotto.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.system.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoValidationTest {
    LottoValidation lottoValidation = new LottoValidation();

    @Nested
    @DisplayName("checkNumberCount 검증 테스트")
    class CheckNumberCount {
        @ParameterizedTest(name = "{0}가 입력되었을 때")
        @ValueSource(strings = {
                "1",
                "1,2",
                "1,2,3",
                "1,2,3,4,5,6,7"
        })
        void 유효한_개수가_입력되었는지_테스트(String target) {
            assertThatThrownBy(() -> lottoValidation.check(target))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorMessage.LOTTO_IS_OVER_SIZE);
        }
    }

    @Nested
    @DisplayName("checkEachOutOfRange 검증 테스트")
    class CheckEachOutOfRange {
        @ParameterizedTest(name = "{0}가 입력되었을 때")
        @ValueSource(strings = {
                "1,2,3,4,5,46",
                "0,1,2,3,4,5",
                "46,47,48,49,50,51"
        })
        void 각_원소가_지정된_로또_값의_범위를_넘지_않는지_테스트(String target) {
            assertThatThrownBy(() -> lottoValidation.check(target))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE);
        }
    }

    @Nested
    @DisplayName("checkEachDistinct 검증 테스트")
    class CheckEachDistinct {
        @ParameterizedTest(name = "{0}가 입력되었을 때")
        @ValueSource(strings = {
                "1,2,3,4,5,1",
                "1,2,3,4,4,4",
                "43,43,43,45,45,45"
        })
        void 각_원소가_중복되지_않는지_테스트(String target) {
            assertThatThrownBy(() -> lottoValidation.check(target))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorMessage.NUM_DUPLICATION);
        }
    }
}