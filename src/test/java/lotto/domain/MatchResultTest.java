package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MatchResultTest {

    @DisplayName("번호 일치 개수 테스트")
    @Test
    void equalNumbers() {
        assertThat(MatchResult.of(4, true).isEqaulMatchNumbersCount(4)).isTrue();
    }

    @DisplayName("보너스 번호 일치 테스트")
    @Test
    void equalBonus() {
        assertThat(MatchResult.of(4, true).isEqaulHasBonusNumber(true)).isTrue();
    }

}
