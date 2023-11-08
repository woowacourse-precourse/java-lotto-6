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
}