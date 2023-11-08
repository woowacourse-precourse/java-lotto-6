package lotto.strategy;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QuickpickIssuanceStrategyTest {
    @DisplayName("issue 메서드로 생성된 Lotto 객체가 유효한 번호로 구성된다.")
    @Test
    void issueLottoWithValidNumbers() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    QuickpickIssuanceStrategy strategy = new QuickpickIssuanceStrategy();
                    Lotto lotto = strategy.issue();
                    assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @DisplayName("issue 메서드로 생성된 Lotto 객체가 중복되지 않는 번호로 구성된다.")
    @Test
    void issueLottoWithUniqueNumbers() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    QuickpickIssuanceStrategy strategy = new QuickpickIssuanceStrategy();
                    Lotto lotto = strategy.issue();
                    assertThat(lotto.getNumbers()).containsOnlyOnce(1, 2, 3, 4, 5, 6); // 중복이 없어야 함
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }
}