package lotto.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusTest {

    @DisplayName("보너스 번호 구하기")
    @Test
    void getBonusNumber() {
        Bonus bonus = new Bonus();
        int actualBonus = bonus.getBonusNumber("42",
                List.of(1, 2, 3, 4, 5, 6)
        );
        int expectedBonus = 42;

        assertThat(expectedBonus).isEqualTo(actualBonus);
    }

    @DisplayName("보너스 번호에 공백이 포함된 경우")
    @Test
    void getBonusNumberWithSpace() {
        Bonus bonus = new Bonus();
        int actualBonus = bonus.getBonusNumber("  42 ",
                List.of(1, 2, 3, 4, 5, 6)
        );
        int expectedBonus = 42;

        assertThat(expectedBonus).isEqualTo(actualBonus);
    }

    @DisplayName("입력이 없는 경우")
    @Test
    void getBonusNumberByNullInput() {
        Bonus bonus = new Bonus();
        assertThatThrownBy(() -> bonus.getBonusNumber(
                "", List.of(1, 2, 3, 4, 5, 6)
        ))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정수가 아닌 값인 경우")
    @Test
    void getBonusNumberByInvalidType() {
        Bonus bonus = new Bonus();
        assertThatThrownBy(() -> bonus.getBonusNumber(
                "7,8", List.of(1, 2, 3, 4, 5, 6)
        ))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1~45 범위가 아닌 경우")
    @Test
    void getBonusNumberByInvalidRange() {
        Bonus bonus = new Bonus();
        assertThatThrownBy(() -> bonus.getBonusNumber(
                "100", List.of(1, 2, 3, 4, 5, 6)
        ))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 중복된 번호인 경우")
    @Test
    void getBonusNumberByDuplication() {
        Bonus bonus = new Bonus();
        assertThatThrownBy(() -> bonus.getBonusNumber(
                "1", List.of(1, 2, 3, 4, 5, 6)
        ))
                .isInstanceOf(IllegalArgumentException.class);
    }
}