package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StatisticTest {

    @DisplayName("정상적인 등수의 횟수를 가져오면 0을 리턴한다.")
    @Test
    void getNumberOfExistWinRank() {
        assertThat(new Statistic().getRank(1))
                .isEqualTo(0);
    }

    @DisplayName("없는 등수의 횟수를 가져오면 예외가 발생한다.")
    @Test
    void getNumberOfNonExistWinRank() {
        assertThatThrownBy(() -> new Statistic().getRank(6))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
