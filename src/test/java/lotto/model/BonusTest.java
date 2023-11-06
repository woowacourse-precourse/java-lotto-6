package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusTest {

    private final List<Integer> answer = List.of(1, 2, 3, 4, 5, 6);

    @DisplayName("Bonus 번호에 숫자 외의 문자가 입력되면 예외를 발생한다.")
    @Test
    void createBonusByNotNumber() {
        assertThatThrownBy(() -> new Bonus("50a", answer))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Bonus 번호의 범위가 1부터 45가 아니라면 예외를 발생한다.")
    @Test
    void createBonusByOverRange() {
        assertThatThrownBy(() -> new Bonus("50", answer))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Bonus 번호가 당첨 번호와 중복되면 예외를 발생한다.")
    @Test
    void createBonusByDuplicatedAnswer() {
        assertThatThrownBy(() -> new Bonus("1", answer))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Bonus 번호를 5로 생성하고 getter 를 사용했을 때 5를 반환한다.")
    @Test
    void getBonusNumber() {
        assertThat(new Bonus("5", answer).getNumber()).isEqualTo(5);
    }
}