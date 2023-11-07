package mytest;

import static org.assertj.core.api.Assertions. *;

import model.Rank;
import org.junit.jupiter.api.Test;

public class RankEnumTest {
    @Test
    public void shouldReturnValueOfCountOfMatch() {
        
        assertThat(Rank.valueOf(3)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.valueOf(4)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.valueOf(5)).isEqualTo(Rank.THIRD);
        assertThat(Rank.valueOf(6)).isEqualTo(Rank.FIRST);
    }

    @Test
    public void shouldReturnCountOfMatch() {
        assertThat(Rank.FIFTH.getCountOfMatch()).isEqualTo(3);
        assertThat(Rank.FOURTH.getCountOfMatch()).isEqualTo(4);
        assertThat(Rank.THIRD.getCountOfMatch()).isEqualTo(5);
        assertThat(Rank.FIRST.getCountOfMatch()).isEqualTo(6);
    }

    @Test
    public void shouldReturnMessage() {
        assertThat(Rank.FIFTH.getMessage()).isEqualTo("개 일치");
        assertThat(Rank.FOURTH.getMessage()).isEqualTo("개 일치");
        assertThat(Rank.THIRD.getMessage()).isEqualTo("개 일치");
        assertThat(Rank.SECOND.getMessage()).isEqualTo("개 일치, 보너스 볼 일치");
        assertThat(Rank.FIRST.getMessage()).isEqualTo("개 일치");
    }

    @Test
    public void shouldReturnWinningMoney() {
        assertThat(Rank.FIFTH.getWinningMoney()).isEqualTo(" (5,000원) - ");
        assertThat(Rank.FOURTH.getWinningMoney()).isEqualTo(" (50,000원) - ");
        assertThat(Rank.THIRD.getWinningMoney()).isEqualTo(" (1,500,000원) - ");
        assertThat(Rank.SECOND.getWinningMoney()).isEqualTo(" (30,000,000원) - ");
        assertThat(Rank.FIRST.getWinningMoney()).isEqualTo(" (2,000,000,000원) - ");
    }
}
