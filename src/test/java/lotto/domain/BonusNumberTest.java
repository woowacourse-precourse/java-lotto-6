package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {
    List<Integer> test = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
    @DisplayName("보너스 번호와 로또 번호 사이에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createBonusNumberByDuplicatedNumber() {
        assertThatThrownBy(() -> new BonusNumber(1, new Lotto(test)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 범위를 넘어가면 예외가 발생한다.")
    @Test
    void createBonusNumberByOverRange() {
        assertThatThrownBy(() -> new BonusNumber(46, new Lotto(test)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}