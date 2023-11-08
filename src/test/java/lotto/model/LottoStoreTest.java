package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoStoreTest {
    @ParameterizedTest
    @CsvSource({"3,3","5,5","1,1"})
    @DisplayName("주어진 장수만큼 로또를 생성해 주는지 테스트")
    void buyLottoByCount(int count, int lottosSize) {
        LottoStore lottoStore = new LottoStore(count);
        Lottos lottos = lottoStore.buyLotto();
        assertThat(lottos.size()).isEqualTo(lottosSize);
    }
}