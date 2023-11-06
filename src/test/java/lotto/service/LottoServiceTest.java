package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    @DisplayName("개수에 맞게 로또가 발급")
    @Test
    void generateLotto() {
        LottoService lottoService = new LottoService();
        int generateLottoCount = 4;
        List<Lotto> lottos = lottoService.generateLotto(generateLottoCount);
        assertEquals(generateLottoCount, lottos.size());
    }
}