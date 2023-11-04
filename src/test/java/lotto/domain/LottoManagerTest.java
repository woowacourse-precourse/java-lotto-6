package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoManagerTest {

    @ParameterizedTest
    @CsvSource(value = {"8000, 8", "4000, 4", "1000, 1", "10000000, 10000"})
    void LottoManager는_구입금액_받아_로또를_생성관리한다(int money, int count) {
        LottoManager manager = LottoManager.from(money);
        assertThat(manager.getLottos().size()).isEqualTo(count);
    }

}