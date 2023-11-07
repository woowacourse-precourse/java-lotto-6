package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @Test
    @DisplayName("로또에 보너스 번호가 있는 경우")
    void matchOne() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 7));
        Collections.sort(numbers);

        Lotto lotto = new Lotto(numbers);
        BonusNumber bonusNumber = new BonusNumber(7);

        assertThat(bonusNumber.match(lotto)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또에 보너스 번호가 없는 경우")
    void matchZero() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Collections.sort(numbers);

        Lotto lotto = new Lotto(numbers);
        BonusNumber bonusNumber = new BonusNumber(7);

        assertThat(bonusNumber.match(lotto)).isEqualTo(0);
    }
}