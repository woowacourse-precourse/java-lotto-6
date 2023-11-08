package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @DisplayName("Lottos 생성 및 가져오기")
    @Test
    void createAndGetLottos() {
        List<Lotto> lottoList = List.of(
                new Lotto(new ArrayList<>(List.of(6,5,4,3,2,1))),
                new Lotto(new ArrayList<>(List.of(12, 11, 10, 9, 8, 7)))
        );
        Lottos lottos = new Lottos(lottoList);

        List<Lotto> retrievedLottos = lottos.getLottos();
        assertThat(retrievedLottos).isEqualTo(lottoList);
    }

}