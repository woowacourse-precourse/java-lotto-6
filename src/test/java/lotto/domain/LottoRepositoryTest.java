package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRepositoryTest {

    @DisplayName("Lottos 저장 및 조회")
    @Test
    void saveLottos() {
        Lottos expectedLottos = new Lottos(List.of(
                new Lotto(new ArrayList<>(List.of(6,5,4,3,2,1))),
                new Lotto(new ArrayList<>(List.of(12, 11, 10, 9, 8, 7)))
        ));

        LottoRepository lottoRepository = new LottoRepository();
        lottoRepository.saveAll(expectedLottos);

        assertThat(lottoRepository.findAll()).isEqualTo(expectedLottos);
    }

}