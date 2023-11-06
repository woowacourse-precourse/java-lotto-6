package lotto.controller;

import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoControllerTest {

    LottoController lottoController;

    @BeforeEach
    void set() {
        lottoController = new LottoController();
    }

    @Test
    void 로또_생성_테스트() {
        List<Lotto> lottos = lottoController.lottoCreateCount(List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 6, 12, 7, 35)
        ));

        Assertions.assertThat(lottos.get(0).getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
        Assertions.assertThat(lottos.get(1).getNumbers()).isEqualTo(List.of(1, 2, 6, 7, 12, 35));

    }


}