package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 범위가 넘어선 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByRangeOverNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 49)))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 보너스 숫자가 포함되어 있는지 확인한다.")
    @Test
    void containsMatch() {
        int containsBonus = 5;
        int notContainsBonus = 7;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        boolean contains = lotto.containsNumber(containsBonus);
        boolean notContains = lotto.containsNumber(notContainsBonus);

        assertThat(contains).isTrue();
        assertThat(notContains).isFalse();
    }


    @DisplayName("로또끼리 숫자를 비교해 몇 개의 숫자가 맞는지 반환한다.")
    @Test
    void countingMatchNumbers() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 9, 10, 11));
        Lotto lotto2 = new Lotto(List.of(12, 13, 14, 15, 16, 17));

        long count1 = lotto.countingMatchNumbers(lotto1);
        long count2 = lotto.countingMatchNumbers(lotto2);

        assertThat(count1).isEqualTo(3L);
        assertThat(count2).isEqualTo(0L);
    }
}