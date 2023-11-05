package lotto.model.result;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.Winning;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {
    private final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    private final int bonus = 7;
    private final Winning winning = Winning.of(lotto, bonus);

    @DisplayName("로또 당첨 결과 객체 생성을 테스트한다.")
    @Test
    void createResult() {
        Result result = Result.of(List.of(lotto), winning);
        assertThat(result).isNotNull();
    }

    @DisplayName("로또 당첨 결과에 따른 개수 조회를 테스트한다.")
    @Test
    void getPrizeCount() {
        Result result = Result.of(List.of(lotto), winning);
        assertThat(result.getPrizeCount(Prize.NONE)).isEqualTo(0);
        assertThat(result.getPrizeCount(Prize.FIFTH)).isEqualTo(0);
        assertThat(result.getPrizeCount(Prize.FOURTH)).isEqualTo(0);
        assertThat(result.getPrizeCount(Prize.THIRD)).isEqualTo(0);
        assertThat(result.getPrizeCount(Prize.SECOND)).isEqualTo(0);
        assertThat(result.getPrizeCount(Prize.FIRST)).isEqualTo(1);
    }

    @DisplayName("로또 당첨 결과에 따른 총 당첨 금액 계산을 테스트한다.")
    @Test
    void calculatePrizeMoney() {
        Result result = Result.of(List.of(lotto), winning);
        double prizeMoney = result.calculatePrizeMoney();
        assertThat(prizeMoney).isEqualTo(2000000000);
    }

    @DisplayName("로또 당첨 결과에 따른 총 수익률 계산을 테스트한다.")
    @Test
    void calculateProfit() {
        Result result = Result.of(List.of(lotto), winning);
        double prizeProfit = result.calculatePrizeProfit(1);
        assertThat(prizeProfit).isEqualTo(200000000);
    }
}