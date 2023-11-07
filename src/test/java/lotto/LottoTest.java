package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복되지 않는 6개의 숫자를 통해 로또를 만들 수 있다.")
    @Test
    void generateLotto() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        Lotto lotto = Lotto.of(numbers);

        // then
        assertThat(Optional.of(lotto)).isNotNull();
    }

    @DisplayName("로또 내에서 특정 숫자의 존재 유무를 확인할 수 있다.")
    @Test
    void checkNumberIsIncluded() {
        // given
        Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));

        // when
        int containedNumber = 5;
        int notContainedNumber = 7;

        // then
        assertTrue(lotto.contains(containedNumber));
        assertFalse(lotto.contains(notContainedNumber));
    }

    @DisplayName("두 개의 로또를 비교하여 일치하는 개수를 확인할 수 있다.")
    @Test
    void matchTwoLotto() {
        // given
        Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        Lotto otherLotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        Lotto anotherLotto = Lotto.of(List.of(1, 2, 3, 4, 5, 7));

        // when
        int otherLottoMatchCount = lotto.match(otherLotto);
        int anotherLottoMatchCount = lotto.match(anotherLotto);

        // then
        assertEquals(6, otherLottoMatchCount);
        assertEquals(5, anotherLottoMatchCount);
    }
}