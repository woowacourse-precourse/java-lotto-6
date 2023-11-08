package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusTest {
    @DisplayName("보너스 번호가 로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Bonus(1, new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1 미만이면 예외가 발생한다.")
    @Test
    void createLottoByLess1() {
        assertThatThrownBy(() -> new Bonus(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 45 초과이면 예외가 발생한다.")
    @Test
    void createLottoByLarger45() {
        assertThatThrownBy(() -> new Bonus(46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
