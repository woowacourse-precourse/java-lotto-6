package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankInfoTest {

    @Test
    @DisplayName("지정된 숫자 일치 개수와 보너스 번호 여부에 따라 적절한 RankInfo를 반환한다")
    void getRankByValue() {
        // Given
        int matchingNumbers = 5;
        boolean bonusNumberContained = true;

        // When
        RankInfo rank = RankInfo.getRankByValue(matchingNumbers, bonusNumberContained);

        // Then
        assertThat(rank).isEqualTo(RankInfo.SECOND);
    }

    @Test
    @DisplayName("보너스 번호가 없을 때, 지정된 숫자 일치 개수에 따라 적절한 RankInfo를 반환한다")
    void getRankByValueWithoutBonusNumber() {
        // Given
        int matchingNumbers = 4;
        boolean bonusNumberContained = false;

        // When
        RankInfo rank = RankInfo.getRankByValue(matchingNumbers, bonusNumberContained);

        // Then
        assertThat(rank).isEqualTo(RankInfo.FOURTH);
    }

    @Test
    @DisplayName("지정된 숫자 일치 개수와 보너스 번호 여부가 모두 일치하지 않을 때, NONE을 반환한다")
    void getRankByValueWhenNone() {
        // Given
        int matchingNumbers = 2;
        boolean bonusNumberContained = true;

        // When
        RankInfo rank = RankInfo.getRankByValue(matchingNumbers, bonusNumberContained);

        // Then
        assertThat(rank).isEqualTo(RankInfo.NONE);
    }

    @Test
    @DisplayName("RankInfo의 상금을 가져온다")
    void getPrizeMoney() {
        // Given
        RankInfo rank = RankInfo.FIRST;

        // When
        Long prizeMoney = rank.getPrizeMoney();

        // Then
        assertThat(prizeMoney).isEqualTo(2_000_000_000L);
    }
}
