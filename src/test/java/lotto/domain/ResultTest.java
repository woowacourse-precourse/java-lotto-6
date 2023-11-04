package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {
    private final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    private final Prize prize = Prize.of(lotto, 7);

    @DisplayName("로또 당첨 결과 객체 생성을 테스트한다.")
    @Test
    void createResult() {
        Result result = Result.of(List.of(lotto), prize);
        assertThat(result).isNotNull();
    }

    @DisplayName("로또 당첨 결과에 따른 개수 조회를 테스트한다.")
    @Test
    void getResultCount() {
        Result result = Result.of(List.of(lotto), prize);
        assertThat(result.getResultCount(Rank.NONE)).isEqualTo(0);
        assertThat(result.getResultCount(Rank.FIFTH)).isEqualTo(0);
        assertThat(result.getResultCount(Rank.FOURTH)).isEqualTo(0);
        assertThat(result.getResultCount(Rank.THIRD)).isEqualTo(0);
        assertThat(result.getResultCount(Rank.SECOND)).isEqualTo(0);
        assertThat(result.getResultCount(Rank.FIRST)).isEqualTo(1);
    }
}