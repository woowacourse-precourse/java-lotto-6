package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("로또 일급컬렉션에")
class LottosTest {

    @DisplayName("로또 목록 확인 요청시 저장된 값을 반환한다.")
    @Test
    void toElements() {
        // given
        final List<Lotto> expected = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        final Lottos lottos = new Lottos(expected);

        // when
        final List<Lotto> result = lottos.toElements();

        // then
        assertThat(result).hasSameElementsAs(expected);
    }

    @DisplayName("로또 개수 확인 요청시 갖고 있는 로또 개수를 반환한다.")
    @Test
    void numOfElement() {
        // given
        final List<Lotto> elements = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        final Lottos lottos = new Lottos(elements);

        // when
        final int result = lottos.numOfElement();

        // then
        assertThat(result).isEqualTo(elements.size());
    }

    @DisplayName("우승 정보 비교 요청시")
    @Nested
    class Compare {

        @DisplayName("당첨 로또가 하나 있는 경우 적합한 값을 반환하는가")
        @Test
        void hasWinningLotto() {
            // given
            final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
            final Lotto winningNumber = new Lotto(numbers);
            final Lottos lottos = new Lottos(List.of(new Lotto(numbers)));

            // when
            final WinningDetails result = lottos.compare(winningNumber);

            // then
            assertThat(result.numOfValues()).isOne();
        }

        @DisplayName("당첨 로또가 없는 경우 빈 리스트를 반환하는가")
        @Test
        void noWinningLotto() {
            // given
            final Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            final Lottos lottos = new Lottos(List.of(new Lotto(List.of(11, 12, 13, 14, 15, 16))));

            // when
            final WinningDetails winningDetails = lottos.compare(winningNumber);

            // then
            assertThat(winningDetails.numOfValues()).isZero();
        }
    }

    @DisplayName("인덱스의 값 요청시 적합한 값을 반환한다.")
    @Test
    void getByIndex() {
        // given
        final Lotto expected = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        final Lottos lottos = new Lottos(List.of(expected));
        // when
        final Lotto result = lottos.getByIndex(0);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
