package lotto;

import lotto.domain.lotto.Bonus;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Paper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PaperTest {

    @Test
    @DisplayName("로또 번호 6개와 보너스 번호 1개를 입력을 적절히 받는다.")
    void of() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = Lotto.of(lottoNumbers);
        int bonusNumber = 7;
        Bonus bonus = Bonus.of(bonusNumber);
        Paper paper = Paper.of(lotto, bonus);

        assertThat(paper).isEqualTo(Paper.of(lotto, bonus));
    }
}