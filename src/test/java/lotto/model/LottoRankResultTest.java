package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoRankResultTest {

    @DisplayName("0으로 초기화된 길이 6의 리스트를 가진 순위 결과 객체를 생성한다.")
    @Test
    void createInitializedListLengthSixCountZero() {
        LottoRankResult rankResult = new LottoRankResult();
        for (int rank = 0; rank < 6; rank++) {
            assertThat(rankResult.getCount(rank)).isEqualTo(0);
        }
    }

    @DisplayName("주어진 순위의 카운트를 1씩 증가한다.")
    @Test
    void increaseRankCountOnceAtOneCall() {
        int rank1 = 1;
        int rank2 = 2;
        int rank3 = 3;
        LottoRankResult rankResult = new LottoRankResult();
        rankResult.increaseRankCount(rank1);
        for (int i = 0; i < 5; i++) {
            rankResult.increaseRankCount(rank3);
        }
        assertThat(rankResult.getCount(rank1)).isEqualTo(1);
        assertThat(rankResult.getCount(rank2)).isEqualTo(0);
        assertThat(rankResult.getCount(rank3)).isEqualTo(5);
    }

}