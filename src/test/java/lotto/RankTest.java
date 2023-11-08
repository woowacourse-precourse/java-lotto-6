package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {
    @DisplayName("주어진 일치 번호 개수와 보너스 번호 여부로 등수를 결정할 수 있다.")
    @Test
    void decideRank() {
        int inputCountDuplication = 4;
        boolean inputCheckBonus = false;
        Rank result = Rank.decideRank(inputCountDuplication, inputCheckBonus);

        assertThat(result).isEqualTo(Rank.FOUR_MATCH);
    }

    @DisplayName("랭크에 해당하는 일치 번호 개수를 반환한다")
    @Test
    void getCountDuplication() {
        int result = Rank.THREE_MATCH.getCountDuplication();

        assertThat(result).isEqualTo(3);
    }

    @DisplayName("랭크에 해당하는 보너스 번호 일치 여부를 반환한다.")
    @Test
    void getCheckBonus() {
        boolean result = Rank.FOUR_MATCH.getCheckBonus();

        assertThat(result).isEqualTo(false);
    }

    @DisplayName("랭크에 해당하는 상금을 반환한다")
    @Test
    void getPrize() {
        int result = Rank.SIX_MATCH.getPrize();

        assertThat(result).isEqualTo(2000000000);
    }
}