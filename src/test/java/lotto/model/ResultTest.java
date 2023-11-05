package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
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
    void getResultCount() {
        Result result = Result.of(List.of(lotto), winning);
        assertThat(result.getPrizeCount(Prize.NONE)).isEqualTo(0);
        assertThat(result.getPrizeCount(Prize.FIFTH)).isEqualTo(0);
        assertThat(result.getPrizeCount(Prize.FOURTH)).isEqualTo(0);
        assertThat(result.getPrizeCount(Prize.THIRD)).isEqualTo(0);
        assertThat(result.getPrizeCount(Prize.SECOND)).isEqualTo(0);
        assertThat(result.getPrizeCount(Prize.FIRST)).isEqualTo(1);
    }
}