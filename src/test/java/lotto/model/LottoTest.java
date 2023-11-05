package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName("번호 일치 개수")
    @Test
    void count() {
        // given
        List<Integer> first = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> second = List.of(2, 3, 4, 5, 6, 7);

        // when
        Lotto firstLotto = new Lotto(first);
        Lotto secondLotto = new Lotto(second);
        Long result = firstLotto.countSameNumbers(secondLotto);

        // then
        assertThat(result).isEqualTo(5L);
    }

    @DisplayName("보너스 번호 포함 여부")
    @Test
    void containsNumber() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        Boolean result = lotto.containsNumber(6);
        Boolean result2 = lotto.containsNumber(20);

        // then
        assertThat(result).isEqualTo(true);
        assertThat(result2).isEqualTo(false);
    }

    @DisplayName("객체 일치 확인")
    @Test
    void sameObject() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto1).isEqualTo(lotto2);
        assertThat(lotto1).hasSameHashCodeAs(lotto2);
    }
}