package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStatusTest {
    @DisplayName("로또의 당첨 상태의 동일 여부를 판단할 수 있다.")
    @Test
    void isSameStatusByDifferent() {
        LottoStatus lottoStatus1 = new LottoStatus(3, false); //5등
        LottoStatus lottoStatus2 = new LottoStatus(5, true); // 1등

        assertThat(lottoStatus1.isSameStatus(lottoStatus2, false)).isFalse();
    }

    @DisplayName("로또의 당첨 상태의 동일 여부를 판단할때 보너스 일치여부를 같이 판단할 수 있다.")
    @Test
    void isSameStatusBySame() {
        LottoStatus lottoStatus1 = new LottoStatus(5, true); //5등
        LottoStatus lottoStatus2 = new LottoStatus(5, true); // 1등

        assertThat(lottoStatus1.isSameStatus(lottoStatus2, true)).isTrue();
    }
}
