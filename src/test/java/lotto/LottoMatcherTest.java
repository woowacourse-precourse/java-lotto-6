package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMatcher;
import lotto.domain.MatchResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoMatcherTest {
    @DisplayName("당첨번호와 보너스번호는 중복될 수 없다.")
    @Test
    void createWithDuplicatedBonusNumber() {
        Lotto winning = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> new LottoMatcher(winning, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoMatcher.ERROR_MESSAGE_DUPLICATED_BONUS_NUMBER);
    }

    @DisplayName("제대로된 매칭결과를 반환한다.")
    @Test
    void matchTest() {
        Lotto winning = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoMatcher matcher = new LottoMatcher(winning, 7);

        Lotto trying = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        MatchResult result = matcher.match(trying);

        assertThat(result.correctNumber()).isEqualTo(5);
        assertThat(result.correctBonusNumber()).isEqualTo(true);
    }
}
