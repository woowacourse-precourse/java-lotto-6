package lotto.service;

import lotto.domain.RandomLottoGenerator;
import org.junit.jupiter.api.BeforeEach;

class LottoServiceTest {

    private RandomLottoGenerator lottoGenerator;
    private LottoService lottoService;

    @BeforeEach
    void beforeEach() {
        lottoGenerator = new RandomLottoGenerator();
        lottoService = new LottoService(lottoGenerator);
    }

    
}