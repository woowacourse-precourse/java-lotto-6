package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoManagerTest {

    @DisplayName("로또 리스트를 오름차순으로 정렬")
    @Test
    void sortLottos() {

        // given
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(6, 5, 4, 3, 2, 1)));
        lottos.add(new Lotto(List.of(5, 1, 2, 3, 4, 6)));

        // when
        List<Lotto> sortedlottos = LottoManager.sortLottos(lottos);

        // then
        for (Lotto sortedlotto : sortedlottos) {
            assertThat(sortedlotto.getNumbers())
                    .isEqualTo(List.of(1, 2, 3, 4, 5, 6))
                    .isNotEqualTo(List.of(6, 5, 4, 3, 2, 1));
        }
    }

}