package lotto.lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.lotto.repository.LottoRepositoryImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoServiceImplTest {

    LottoService lottoService = new LottoServiceImpl(new LottoRepositoryImpl());

    @Test
    void createLottosTest() {
        lottoService.createLottos(8);
        assertThat(lottoService.getLottos().size()).isEqualTo(8);
    }

    @Test
    void generateNumbersTest() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        assertThat(numbers.size()).isEqualTo(6);
    }
}