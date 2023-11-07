package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    @DisplayName("로또를 생성한다.")
    @Test
    void generateLotto() {
        // given
        LottoService lottoService = new LottoService();

        // when
        lottoService.setLottos(14000);

        // then
        assertEquals(14, lottoService.getLottoCount());
    }

}
