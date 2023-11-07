package lotto.domain.strategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Lotto;

class IssuableStrategyTest {

    @Test
    @DisplayName("로또 자동 발행 전략: 자동으로 숫자를 생성해 로또 발행 성공")
    void givenAutoIssueStrategy_whenIssue_thenNoException() {
        // given
        IssuableStrategy autoIssueStrategy = new AutoIssuanceStrategy();

        // when & then
        assertThatNoException()
                .isThrownBy(autoIssueStrategy::issue);
    }

    @Test
    @DisplayName("로또 수동 발행 전략: 문자열 numbers를 받아 로또 발행 성공")
    void givenManualIssuanceStrategy_whenIssue_thenSuccess() {
        // given
        IssuableStrategy manualIssuanceStrategy = new ManualIssuanceStrategy("6,5,4,3,2,1");

        // when
        Lotto result = manualIssuanceStrategy.issue();

        // then
        assertThat(result).isEqualTo(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
    }

}
