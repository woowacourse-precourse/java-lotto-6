package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JudgeTest {
    @Test
    void 로또_번호와_당첨_번호의_일치_개수_리턴() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> numbers = Arrays.asList(4, 5, 6, 7, 8, 9);
        Lotto lotto = new Lotto(numbers);

        assertThat(Judge.winningCount(lotto, winningNumbers)).isEqualTo(3);
    }

    @Test
    void 로또_번호와_보너스_번호의_일치_여부_리턴() {
        List<Integer> numbers = Arrays.asList(4, 5, 6, 7, 8, 9);
        Lotto lotto = new Lotto(numbers);
        Integer bonusNumber = 5;

        assertThat(Judge.isBonusMatch(lotto, bonusNumber)).isTrue();
    }
}
