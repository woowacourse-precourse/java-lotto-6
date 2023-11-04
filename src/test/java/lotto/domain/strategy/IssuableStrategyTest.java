package lotto.domain.strategy;

import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IssuableStrategyTest {

    @Test
    @DisplayName("로또 자동 발행 전략: 자동으로 숫자를 생성해 로또 발행 성공")
    void givenAutoIssueStrategy_whenIssue_thenNoException() {
        // given
        IssuableStrategy autoIssueStrategy = new AutoIssueStrategy();

        // when & then
        assertThatNoException()
                .isThrownBy(autoIssueStrategy::issue);
    }

}
