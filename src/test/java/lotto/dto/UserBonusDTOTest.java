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
public class UserBonusDTOTest {
    @Nested
    @DisplayName("예외가 발생하는 경우")
    class unvalidUserBonus {
        @ParameterizedTest
        @NullAndEmptySource
        void 아무것도_입력하지_않으면_예외(String input) {
            assertThatThrownBy(
                    () -> {
                        new UserBonusDTO(input);
                    }
            ).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("아무것도");
        }

        @ParameterizedTest
        @ValueSource(strings = {"0-A", "12!"})
        void 숫자가_입력되지_않으면_예외(String input) {
            assertThatThrownBy(
                    () -> {
                        new UserBonusDTO(input);
                    }
            ).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("숫자를 입력하지");
        }

        @ParameterizedTest
        @ValueSource(strings = {"0123", "034"})
        void 첫번쨰_숫자가_0이고_길이가_1보다_크다면_예외(String input) {
            assertThatThrownBy(
                    () -> {
                        new UserBonusDTO(input);
                    }
            ).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("0으로 시작하는 수는");
        }
    }

    @Nested
    @DisplayName("예외가 발생하는 경우")
    class validUserBonus {
        @ParameterizedTest
        @ValueSource(strings = {"12", "1", "46"})
        void 첫번째_숫자가_0이_아닌_수를_입력한_경우_성공(String input) {
            assertThatNoException().isThrownBy(
                    () -> {
                        new UserBonusDTO(input);
                    }
            );
        }
    }
}
