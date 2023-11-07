package lotto;

import lotto.controller.Controller;
import lotto.domain.Lotto;
import lotto.domain.Ranking;
import lotto.domain.Winning;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningTest {
    @DisplayName("로또 일치 번호 확인 ")
    @Test
    public void matchingCount() {
        // given
        Lotto winner = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        // when
        int count = lotto.countContain(winner);

        // then
        assertThat(count).isEqualTo(3);
    }
}

