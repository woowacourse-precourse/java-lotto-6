package lotto.dto;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class UserMoneyDTOTest {
    @Nested
    @DisplayName("예외가 발생하는 경우")
    class unvalidUserMoney {
        @ParameterizedTest(name = "인자 : {0}")
        @NullAndEmptySource
        void 아무것도_입력하지_않은_경우_예외(String inputMoney) {
            assertThatThrownBy(() -> new UserMoneyDTO(inputMoney))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("아무것도 입력하지");
        }

        @ParameterizedTest(name = "인자 : {0}")
        @ValueSource(strings = {"1001,", "뮤10"})
        void 숫자가_아닌_경우_예외(String inputMoney) {
            assertThatThrownBy(() -> new UserMoneyDTO(inputMoney))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("숫자를 입력하지");
        }

        @ParameterizedTest(name = "인자 : {0}")
        @ValueSource(strings = {"000", "01", "01234"})
        void 첫번쨰_숫자가_0이고_길이가_1보다_크다면_예외(String inputMoney) {
            assertThatThrownBy(() -> new UserMoneyDTO(inputMoney))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("0으로 시작하는 수는");
        }
    }

    @Nested
    @DisplayName("예외가 발생하지 않는 경우")
    class validUserMoney {
        @ParameterizedTest
        @ValueSource(strings = {"8000", "7000", "1000", "0"})
        void 조건을_만족하면_성공(String inputMoney) {
            assertThatNoException().isThrownBy(() -> new UserMoneyDTO(inputMoney));
        }
    }
}
