package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultCountTest {

    private LottoResultCount lottoResultCount;

    @BeforeEach
    void setUp() {
        lottoResultCount = new LottoResultCount();
    }

    @Test
    void shouldInitializeWithZeros() {
        assertThat(lottoResultCount.getThreeCount()).isZero();
        assertThat(lottoResultCount.getFourCount()).isZero();
        assertThat(lottoResultCount.getFiveCount()).isZero();
        assertThat(lottoResultCount.getFiveWithBonusCount()).isZero();
        assertThat(lottoResultCount.getSixCount()).isZero();
    }

    @Test
    void shouldAddThreeCount() {
        lottoResultCount.addThreeCount();
        lottoResultCount.addThreeCount();
        assertThat(lottoResultCount.getThreeCount()).isEqualTo(2);
    }

    @Test
    void shouldAddFourCount() {
        lottoResultCount.addFourCount();
        assertThat(lottoResultCount.getFourCount()).isEqualTo(1);
    }

    @Test
    void shouldAddFiveCount() {
        for (int i = 0; i < 6; i++) {
            lottoResultCount.addFiveCount();
        }
        assertThat(lottoResultCount.getFiveCount()).isEqualTo(6);
    }

    @Test
    void shouldAddFiveWithBonusCount() {
        for (int i = 0; i < 3; i++) {
            lottoResultCount.addFiveWithBonusCount();
        }
        assertThat(lottoResultCount.getFiveWithBonusCount()).isEqualTo(3);
    }

    @Test
    void shouldAddSixCount() {
        for (int i = 0; i < 4; i++) {
            lottoResultCount.addSixCount();
        }
        assertThat(lottoResultCount.getSixCount()).isEqualTo(4);
    }
}
