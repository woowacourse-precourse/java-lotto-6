package lotto.dto;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.dto.input.UserBonusDTO;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class UserBonusDTOTest {
    // UserMoneyDTOTest와 유사하다
    private UserBonusDTO userBonusDTO;

    @ParameterizedTest
    @NullAndEmptySource
    void 아무것도_입력하지_않으면_예외(String input) {
        assertThatThrownBy(
                        () -> {
                            userBonusDTO = new UserBonusDTO(input);
                        }
                ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("아무것도");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0-A", "12!"})
    void 숫자가_입력되지_않으면_예외(String input) {
        assertThatThrownBy(
                        () -> {
                            userBonusDTO = new UserBonusDTO(input);
                        }
                ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자를 입력하지");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0123", "034"})
    void 첫번쨰_숫자가_0이고_길이가_1보다_크다면_예외(String input) {
        assertThatThrownBy(
                        () -> {
                            userBonusDTO = new UserBonusDTO(input);
                        }
                ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0으로 시작하는 수는");
    }

    @ParameterizedTest
    @ValueSource(strings = {"12", "1", "46"})
    void 첫번째_숫자가_0이_아닌_수를_입력한_경우_성공(String input) {
        assertThatNoException().isThrownBy(
                () -> {
                    userBonusDTO = new UserBonusDTO(input);
                }
        );
    }
}
