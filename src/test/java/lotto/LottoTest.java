package lotto;

import java.util.ArrayList;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("Match Count 계산 테스트")
    @Test
    void calculateMatchCountTest() {
        List<Integer> numbers1 = List.of(1,2,3,4,5,6);
        List<Integer> numbers2 = List.of(2,3,4,5,6,7);
        Lotto lotto = Lotto.from(numbers1);
        Lotto otherLotto = Lotto.from(numbers2);

        assertThat(lotto.calculateMatchCount(otherLotto)).isEqualTo(5);
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}