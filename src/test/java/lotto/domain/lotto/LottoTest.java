package lotto.domain.lotto;

import lotto.domain.result.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

    @DisplayName("로또의 범위는 1 이상, 45 이하여야 한다. 0이하 포함")
    @Test
    void 로또의_범위_벗어남_1미만() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또의 범위는 1 이상, 45 이하여야 한다. 45초과 포함")
    @Test
    void 로또의_범위_벗어남_45초과() {
        assertThatThrownBy(() -> new Lotto(List.of(46, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 숫자가 없으면 정상적으로 실행되어야 한다.")
    @Test
    void 정상적으로_실행() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertNotNull(lotto);
    }

    @DisplayName("로또는 일치하는 값의 갯수를 출력해줄 수 있어야 한다. 모두 일치")
    @Test
    void 로또의_compare_모두_일치() {
        Lotto first = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto second = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        Result result = first.compare(second, 0);

        assertEquals(6, result.count());
    }

    @DisplayName("로또는 일치하는 값의 갯수를 출력해줄 수 있어야 한다. 1개 일치")
    @Test
    void 로또의_compare_1개_일치() {
        Lotto first = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto second = new Lotto(List.of(6, 7, 8, 9, 10, 11));

        Result result = first.compare(second, 0);

        assertEquals(1, result.count());
    }

    @DisplayName("로또는 일치하는 값의 갯수를 출력해줄 수 있어야 한다. 일치하지_않음")
    @Test
    void 로또의_compare_0개_일치() {
        Lotto first = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto second = new Lotto(List.of(7, 8, 9, 10, 11, 12));

        Result result = first.compare(second, 0);

        assertEquals(0, result.count());
    }
}