package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusTest {

    private Bonus bonus;
    private List<Integer> numbers;

    @BeforeEach
    void setUp() {
        bonus = new Bonus();
        numbers = List.of(1, 2, 3, 4, 5, 6, 7);
    }

    @DisplayName("보너스 번호를 정상적으로 저장한다.")
    @Test
    void saveBonus() {
        bonus.save("23", numbers);
        Assertions.assertThat(bonus.getNumber()).isEqualTo(23);
    }

    @DisplayName("보너스 번호가 당첨 번호 중 하나와 중복이라면 예외가 발생한다.")
    @Test
    void saveBonusByDuplicateNumber() {
        assertThatThrownBy(() -> bonus.save("1", numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호에 공백이 포함될 시 무시한다.")
    @Test
    void saveBonusByContainEmpty() {
        String EmptyContained = new String("1 2");
        String noEmptyContained = bonus.removeEmpty(EmptyContained);
        Assertions.assertThat(noEmptyContained).isEqualTo("12");
    }

    @DisplayName("보너스 번호가 문자를 포함한 경우 예외가 발생한다.")
    @Test
    void saveBonusByNotNumberOrRest() {
        assertThatThrownBy(() -> bonus.save("2a", numbers))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> bonus.save("-2", numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1~45 범위를 초과할 경우 예외가 발생한다.")
    @Test
    void saveBonusByExceedBoundary() {
        assertThatThrownBy(() -> bonus.save("46", numbers))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> bonus.save("0", numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
