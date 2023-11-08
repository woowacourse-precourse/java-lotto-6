package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottosTest {

    @DisplayName("복제된 로또 배열을 반환한다.")
    @Test
    void getLottosSuccessTest() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<Lotto> lottos = IntStream.range(0, 10)
                .mapToObj(idx -> new Lotto(List.copyOf(numbers)))
                .toList();
        Lottos preLottos = new Lottos(lottos);

        // when
        List<Lotto> expectedLottos = preLottos.lottos();

        // then
        assertThat(expectedLottos == lottos).isFalse();
        assertThat(expectedLottos).isEqualTo(lottos);
    }

    @DisplayName("로또 배열의 크기를 반환한다.")
    @Test
    void sizeSuccessTest() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<Lotto> readyLottos = IntStream.range(0, 10)
                .mapToObj(idx -> new Lotto(List.copyOf(numbers)))
                .toList();
        Lottos lottos = new Lottos(readyLottos);

        // when
        int size = lottos.size();

        // then
        assertThat(size).isEqualTo(10);
    }

    @DisplayName("로또 당첨 배열을 반환한다.")
    @Test
    void calculateRankingsSuccessTest() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<Lotto> readyLottos = IntStream.range(0, 10)
                .mapToObj(idx -> new Lotto(List.copyOf(numbers)))
                .toList();
        WinningLotto winningLotto = new WinningLotto(List.copyOf(numbers), 7);
        Lottos lottos = new Lottos(readyLottos);
        List<LottoRanking> expectedRankings = IntStream.range(0, 10)
                .mapToObj(idx -> LottoRanking.FIRST)
                .toList();

        // when
        List<LottoRanking> lottoRankings = lottos.calculateRankings(winningLotto);

        // then
        assertThat(lottoRankings).isEqualTo(expectedRankings);

    }
}