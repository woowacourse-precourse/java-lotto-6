package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BonusTest {

    @DisplayName("보너스 번호가 당첨번호에 있으면 예외가 발생한다.")
    @Test
    void duplicateCheck() {
        assertThatThrownBy(() -> new Bonus(List.of(1, 2, 3, 4, 5, 6), 1))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("1 ~ 45 사이 숫자가 아니면 예외가 발생한다.")
    @Test
    void rangeCheck() {
        assertThatThrownBy(() -> new Bonus(List.of(1, 2, 3, 4, 5, 60), 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

}