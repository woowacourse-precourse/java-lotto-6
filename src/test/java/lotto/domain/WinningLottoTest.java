package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    @DisplayName("당첨 번호와 일치하는 개수를 구하는 기능 테스트")
    @Test
    void countMatchingNumbers() {
        WinningLotto winningLotto = WinningLotto.of(Arrays.asList(1,2,3,4,5,6),7);
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,8));
        int expected = 5;

        int matchingNumbers = winningLotto.countMatchingNumbers(lotto);

        assertThat(matchingNumbers).isEqualTo(expected);
    }
}