package lotto.domain;

import java.util.Arrays;
import lotto.domain.Lotto;
import lotto.domain.Judge;
import lotto.domain.LottoBonus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class JudgeTest {
    @DisplayName("자동 숫자에 보너스 숫자가 포함되었는지 확인한다.")
    @Test
    void compareBonusWithNumbers() {
        // given
        Lotto randomNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoBonus bonus = new LottoBonus(3);

        // when
        boolean hasBonus = Judge.compareBonusNumber(randomNumbers, bonus);

        // then
        assertThat(hasBonus).isEqualTo(true);
    }

}
