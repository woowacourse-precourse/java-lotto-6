package domain;

import static domain.Lotto.getMatchCounts;
import static org.assertj.core.api.Assertions.assertThat;

import domain.Lotto;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @DisplayName("로또 맞은 번호 개수 카운트")
    @Test
    void getMatchCountsTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        int matchCount = getMatchCounts(lotto, winningLotto);

        assertThat(matchCount).isEqualTo(6);
    }
}
