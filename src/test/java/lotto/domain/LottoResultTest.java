package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.constants.Prize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {
    private LottoResult lottoResult;

    @BeforeEach
    void beforeEach() {
        // given
        lottoResult = new LottoResult();
    }

    @DisplayName("로또 결과 초기화 -> key를 Prize 열거형 초기화")
    @Test
    void initializeLottoResultOfKey() {
        // key - Prize
        for (Prize prize : Prize.values()) {
            assertThat(lottoResult.state.containsKey(prize)).isTrue();
        }
    }

    @DisplayName("로또 결과 초기화 -> value를 0으로 초기화")
    @Test
    void initializeLottoResultOfValue() {
        // value - 0
        for (Prize prize : lottoResult.state.keySet()) {
            assertThat(lottoResult.state.get(prize)).isEqualTo(0);
        }
    }

    @DisplayName("로또 결과 초기화 -> 크기는 5")
    @Test
    void initializeLottoResultOfSize() {
        assertThat(lottoResult.state.size()).isEqualTo(5);
    }

    @DisplayName("수익률 계산")
    @Test
    void calculateEarningsRate() {
        // given
        lottoResult.state.replace(Prize.FIFTH, 1);   // 5등 5000원, 1개

        // when
        Double earningsRate = lottoResult.calculateEarningsRate(5); // 로또 5장

        // then
        assertThat(earningsRate).isEqualTo(100); // (5000 / (1000*5)) * 100 = 100 %
    }
}