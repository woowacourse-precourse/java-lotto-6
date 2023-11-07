package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.MatchResult.*;
import static lotto.domain.constant.NumberConstant.*;
import static org.assertj.core.api.Assertions.assertThat;

class MatchResultTest {
    @DisplayName("매칭 결과값으로 MatchResult 반환")
    @Test
    void getFromCount() {
        int count1 = SIX_WIN_COUNT;
        int count2 = MIN_WIN_COUNT;
        int count3 = MIN_WIN_COUNT + 1;

        assertThat(MatchResult.getFromCount(count1)).isEqualTo(SIX);
        assertThat(MatchResult.getFromCount(count2)).isEqualTo(THREE);
        assertThat(MatchResult.getFromCount(count3)).isEqualTo(FOUR);
    }
}