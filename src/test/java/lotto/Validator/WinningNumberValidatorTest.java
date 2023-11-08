package lotto.Validator;

import static lotto.config.ErrorMessage.INPUT_WINNING_CHARACTER_ERROR_MESSAGE;
import static lotto.config.ErrorMessage.INPUT_WINNING_NUMBER_SIZE_ERROR_MESSAGE;
import static lotto.config.ErrorMessage.LOTTO_NUMBER_DUPLICATION_ERROR_MESSAGE;
import static lotto.config.ErrorMessage.LOTTO_NUMBER_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("WinningNumberValidator 클래스 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class WinningNumberValidatorTest {
    private final WinningNumberValidator validator = new WinningNumberValidator();

    @Test
    void 올바른_정답_번호의_개수을_확인한다() {
        List<String> list = new ArrayList<>();

        for (int i = 1; i <= 6; i++) {
            list.add(String.valueOf(i));
        }

        assertDoesNotThrow(() -> validator.valid(list));
    }

    @Test
    void 잘못된_정답_번호의_개수을_확인한다() {
        List<String> list = new ArrayList<>();

        for (int i = 1; i <= 7; i++) {
            list.add(String.valueOf(i));
        }

        assertThatThrownBy(() -> validator.valid(list))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUT_WINNING_NUMBER_SIZE_ERROR_MESSAGE.getMessage());
    }

    @Test
    void 정답_번호가_정수가_아닌_경우를_확인한다() {
        List<String> list = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            list.add(String.valueOf(i));
        }
        list.add("hi");

        assertThatThrownBy(() -> validator.valid(list))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUT_WINNING_CHARACTER_ERROR_MESSAGE.getMessage());
    }

    @Test
    void 정답_번호가_범위를_벗어난_경우를_확인한다() {
        List<String> list = new ArrayList<>();

        for (int i = 41; i <= 46; i++) {
            list.add(String.valueOf(i));
        }

        assertThatThrownBy(() -> validator.valid(list))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NUMBER_ERROR_MESSAGE.getMessage());
    }

    @Test
    void 중복된_번호가_있는_경우를_확인한다() {
        List<String> list = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            list.add(String.valueOf(i));
        }
        list.add("1");

        assertThatThrownBy(() -> validator.valid(list))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NUMBER_DUPLICATION_ERROR_MESSAGE.getMessage());
    }
}
