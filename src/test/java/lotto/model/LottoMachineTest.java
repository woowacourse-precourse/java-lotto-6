package lotto.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    private LottoMachine lottoMachine;

    @BeforeEach
    public void setup() {
        lottoMachine = new LottoMachine();
    }

    @Test
    @DisplayName("점수판이 증가하는지 확인한다.")
    public void updateWinningRecordTest() {
        Rank rank = Rank.FIFTH;

        for (int i = 0; i < 3; i++) {

            assertThat(lottoMachine.getRankValue(rank)).isEqualTo(i);

            lottoMachine.updateWinningRecord(rank);

            assertThat(lottoMachine.getRankValue(rank)).isEqualTo(i + 1);
        }
    }

    @Test
    @DisplayName("PASS일때는 증가하지 않는다.")
    public void PassTest() {
        Rank rank = Rank.PASS;
        for (int i = 0; i < 3; i++) {

            assertThat(lottoMachine.getRankValue(rank)).isEqualTo(0);

            lottoMachine.updateWinningRecord(rank);

            assertThat(lottoMachine.getRankValue(rank)).isEqualTo(0);
        }
    }

    @Test
    @DisplayName("수익률을 둘째 자리에서 반올림한다.")
    public void calculateEarningRateTest() {
        int lottoCount = 7;
        double earningRate;

        lottoMachine.updateWinningRecord(Rank.FIFTH);
        earningRate = lottoMachine.calculateEarningRate(lottoCount);
        assertThat(earningRate).isEqualTo(71.4);

        lottoMachine.updateWinningRecord(Rank.FOURTH);
        earningRate = lottoMachine.calculateEarningRate(lottoCount);
        assertThat(earningRate).isEqualTo(785.7);

        lottoMachine.updateWinningRecord(Rank.THIRD);
        earningRate = lottoMachine.calculateEarningRate(lottoCount);
        assertThat(earningRate).isEqualTo(22214.3);

    }

}