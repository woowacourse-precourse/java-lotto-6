package lotto.domain;

import lotto.exception.ErrorCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningDetailsTest {

    private static WinningDetails winningDetails;

    @BeforeEach
    void beforeEach() {
        winningDetails = new WinningDetails();
    }

    @DisplayName("생성시 각 당첨 개수가 0으로 초기화 되는지 테스트")
    @Test
    void createWinningDetailsByCountIsNull() {
        for (int count : winningDetails.getWinningDetails().values()) {
            assertThat(count).isEqualTo(0);
        }
    }

    @DisplayName("등수 범위보다 작은 값을 입력하는 경우")
    @Test
    void createWinningDetailsByUnderRank() {

        int rank = 0;

        assertThatThrownBy(() -> winningDetails.increaseCount(rank))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INVALID_RANK_RANGE.getMessage());
    }

    @DisplayName("등수 범위보다 큰 값을 입력하는 경우")
    @Test
    void createWinningDetailsByOverRank() {

        int rank = 6;

        assertThatThrownBy(() -> winningDetails.increaseCount(rank))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INVALID_RANK_RANGE.getMessage());
    }

    @DisplayName("개수 증가시 당첨 개수가 올맞게 증가되는지 테스트")
    @Test
    void increaseWinningDetailsCount() {

        int winningRank = 5;
        int count = 3;

        for (int i = 0; i < count; i++) {
            winningDetails.increaseCount(winningRank);
        }

        assertThat(winningDetails.getWinningCount(winningRank)).isEqualTo(count);
    }

}
