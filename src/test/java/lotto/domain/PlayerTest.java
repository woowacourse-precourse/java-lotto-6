package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    private final int bonusNumber = 7;
    private final Lotto winningNumber = new Lotto(Arrays.asList(1,2,3,4,5,9));
    private List<Lotto> lotto;
    private Player player;

    @BeforeEach
    void setUp() {
        lotto = Arrays.asList(new Lotto(Arrays.asList(1,2,3,4,5,6)), new Lotto(Arrays.asList(1,2,3,4,5,7)));
        player = new Player(lotto);
    }

    @DisplayName("로또 당첨 내역이 2등인지 확인한다.")
    @Test
    void checkWinning_2ND() {
        lotto = Arrays.asList(new Lotto(Arrays.asList(1,2,3,4,5,7)));
        player = new Player(lotto);
        player.checkWinning(winningNumber, bonusNumber);

        Map<Rank, Integer> winningDetails = player.getWinningDetails();

        assertThat(winningDetails.get(Rank._2ND)).isEqualTo(1);
        assertThat(winningDetails.get(Rank._3RD)).isEqualTo(0);
    }

    @DisplayName("로또 당첨 내역이 3등인지 확인한다.")
    @Test
    void checkWinning_3RD() {
        lotto = Arrays.asList(new Lotto(Arrays.asList(1,2,3,4,5,6)));
        player = new Player(lotto);
        player.checkWinning(winningNumber, bonusNumber);

        Map<Rank, Integer> winningDetails = player.getWinningDetails();

        assertThat(winningDetails.get(Rank._2ND)).isEqualTo(0);
        assertThat(winningDetails.get(Rank._3RD)).isEqualTo(1);
    }

    @DisplayName("로또 당첨 내역이 2, 3등인지 확인한다.")
    @Test
    void checkWinning_2ND_3RD() {
        player.checkWinning(winningNumber, bonusNumber);

        Map<Rank, Integer> winningDetails = player.getWinningDetails();

        assertThat(winningDetails.get(Rank._2ND)).isEqualTo(1);
        assertThat(winningDetails.get(Rank._3RD)).isEqualTo(1);
    }

    @DisplayName("로또 당첨 등수를 전체 확인한다.")
    @Test
    void checkWinning_all() {
        lotto = Arrays.asList(
                new Lotto(Arrays.asList(1,2,3,4,5,9)),          // 1등
                new Lotto(Arrays.asList(1,2,3,4,5,7)),          // 2등
                new Lotto(Arrays.asList(1,2,3,4,5,10)),         // 3등
                new Lotto(Arrays.asList(1,2,3,4,12,13)),        // 4등
                new Lotto(Arrays.asList(1,2,3,15,16,17)),       // 5등
                new Lotto(Arrays.asList(1,2,19,20,25,30)),      // 일치 수가 2개
                new Lotto(Arrays.asList(1,20,25,27,28,35)),     // 일치 수가 1개
                new Lotto(Arrays.asList(10,20,30,40,41,42))     // 일치 수가 0개
        );
        player = new Player(lotto);
        player.checkWinning(winningNumber, bonusNumber);

        Map<Rank, Integer> winningDetails = player.getWinningDetails();

        assertThat(winningDetails.get(Rank._1ST)).isEqualTo(1);
        assertThat(winningDetails.get(Rank._2ND)).isEqualTo(1);
        assertThat(winningDetails.get(Rank._3RD)).isEqualTo(1);
        assertThat(winningDetails.get(Rank._4TH)).isEqualTo(1);
        assertThat(winningDetails.get(Rank._5TH)).isEqualTo(1);
        assertThat(winningDetails.get(Rank.BLANK)).isEqualTo(3);
    }

    @DisplayName("구매 금액에 대한 수익률을 계산한다.")
    @Test
    void calculateRateOfReturn() {
        lotto = Arrays.asList(
                new Lotto(Arrays.asList(1,2,3,15,16,17)),   // 5등
                new Lotto(Arrays.asList(1,2,19,20,25,30)),  // 당첨 x
                new Lotto(Arrays.asList(1,2,25,27,28,35)),  // 당첨 x
                new Lotto(Arrays.asList(1,2,10,22,33,44)),  // 당첨 x
                new Lotto(Arrays.asList(1,2,20,25,35,45)),  // 당첨 x
                new Lotto(Arrays.asList(1,2,30,40,41,42)),  // 당첨 x
                new Lotto(Arrays.asList(1,2,15,17,22,42)),  // 당첨 x
                new Lotto(Arrays.asList(1,2,20,30,40,45))   // 당첨 x
        );
        player = new Player(lotto);
        player.checkWinning(winningNumber, bonusNumber);

        double result = player.calculateRateOfReturn(8000);

        assertThat(result).isEqualTo(62.5);
    }
}