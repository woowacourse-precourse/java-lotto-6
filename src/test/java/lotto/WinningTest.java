package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningTest {
    @DisplayName("로또 일치 번호 확인 ")
    @Test
    public void matchingCount() {
        Lotto winner = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        int count = lotto.countContain(winner);

        assertThat(count).isEqualTo(3);
    }
}

