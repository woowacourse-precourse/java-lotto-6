package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningTest {

    private Winning winning;

    @BeforeEach
    void setUp() {
         winning = new Winning();
    }

    @DisplayName("당첨 번호는 쉼표를 기준으로 저장한다.")
    @Test
    void save() {
        winning.save("1,2,3,4,5,6");
        List<Integer> numbers = winning.getNumbers();
        assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("당첨 번호에 공백이 포함되어 있는 경우 무시한다.")
    @Test
    void saveWinningByContainEmpty() {
        winning.save("1,  2, 3,    4,5,6");
        List<Integer> numbers = winning.getNumbers();
        assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("당첨 번호에 쉼표가 아닌 문자가 포함되어 있을 경우 예외가 발생한다.")
    @Test
    void saveWinningByNotRestCharacter() {
        assertThatThrownBy(() -> winning.save("1,2.3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 1~45 범위를 초과할 경우 예외가 발생한다.")
    @Test
    void saveWinningByExceedBoundary() {
        assertThatThrownBy(() -> winning.save("1,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> winning.save("0,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 중복 숫자를 가지고 있을 경우 예외가 발생한다.")
    @Test
    void saveWinningByDuplicateNumber() {
        assertThatThrownBy(() -> winning.save("1,2,3,3,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
