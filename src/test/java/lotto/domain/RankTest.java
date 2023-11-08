package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @DisplayName("Rank.valueOf메서드가 제대로 작동하는 지 확인하기")
    @Test
    void checkRankWorks() {
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
    }

}