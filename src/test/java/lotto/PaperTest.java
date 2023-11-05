package lotto;

import lotto.domain.Paper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PaperTest {

    @Test
    @DisplayName("로또 번호 6개와 보너스 번호 1개를 입력을 적절히 받는다.")
    void of() {
        Paper paper = Paper.of("1,2,3,4,5,6", "7");

        Assertions.assertThat(paper).isEqualTo(Paper.of("1,2,3,4,5,6", "7"));
    }
}