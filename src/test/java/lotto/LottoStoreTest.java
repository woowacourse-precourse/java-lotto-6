package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.LottoStore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStoreTest {
    @DisplayName("총 발행개수 만큼의 로또를 발행")
    @Test
    void publishLottoesByTotalLottoNumber() {
        int totalLottoNumber = 8;
        LottoStore lottoStore = new LottoStore(totalLottoNumber);

        int result = lottoStore.getLottoes().size();
        int expected = 8;

        assertThat(result).isEqualTo(expected);
    }
}
