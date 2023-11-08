package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

    @DisplayName("맞춘 번호 갯수와 보너스 번호로 등수 매칭 test")
    @Test
    void findRankTest() {
        //Given
        int matchNumberCnt = 5;
        boolean isBonus = false;
        //When
        Rank rank = Rank.findRank(matchNumberCnt, isBonus);
        //Then
        assertThat(rank.name()).isEqualTo("THIRD");
    }

    @DisplayName("맞춘 번호 갯수가 5개이고, 보너스 번호도 맞으면 2등")
    @Test
    void findRankTest_SECOND() {
        //Given
        int matchNumberCnt = 5;
        boolean isBonus = true;
        //When
        Rank rank = Rank.findRank(matchNumberCnt, isBonus);
        //Then
        assertThat(rank.name()).isEqualTo("SECOND");
    }

}