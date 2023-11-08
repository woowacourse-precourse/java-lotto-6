package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.repository.LottoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoServiceTest {

    @BeforeEach
    void init() {
        LottoRepository.resetInstanceAndFields();
    }

    @DisplayName("budget 만큼 로또를 발행한 후, repository에 저장한다.")
    @ParameterizedTest
    @ValueSource(ints = {3000, 12000})
    void issueLottos(int budget) {
        LottoService lottoService = new LottoService();
        LottoRepository.setBudget(budget);

        lottoService.issueLottos();

        List<Lotto> lottos = LottoRepository.getLottos();
        int actual = lottos.size();
        int expected = budget / 1000;

        assertThat(actual).isEqualTo(expected);
    }
}
