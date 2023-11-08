package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class LottosTest {

    private final static List<List<Integer>> randomNumberLists = Arrays.asList(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 6));

    @Test
    @DisplayName("정상 리스트들이 들어오면 Lottos 객체 생성 성공")
    public void createLottosByNormalInput() {
        // given
        int expectedSize = 2;

        // when
        Lottos lottos = new Lottos(randomNumberLists);
        List<Lotto> randomLottos = lottos.getRandomLottos();
        int actualSize = randomLottos.size();

        // then
        assertThat(actualSize).isEqualTo(expectedSize);
    }

}