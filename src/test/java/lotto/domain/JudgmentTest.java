package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class JudgmentTest {
    @Test
    void 일치하는_숫자_개수_판단() {
        Judgment judgment = new Judgment();
        List<Integer> lotto = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        ArrayList<Integer> winningLotto = new ArrayList<>(List.of(2, 3, 4, 5, 6, 7));

        assertThat(judgment.correctCount(lotto, winningLotto)).isEqualTo(5);
    }

    @Test
    void 로또_번호에_보너스_번호_존재_여부_판단() {
        Judgment judgment = new Judgment();
        List<Integer> lotto = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 7;

        assertThat(judgment.hasBonus(lotto, bonus)).isEqualTo(false);
    }
}