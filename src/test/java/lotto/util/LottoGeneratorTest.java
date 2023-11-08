package lotto.util;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    @DisplayName("당첨 로또 번호 생성")
    @Test
    void testGenerationOfWinningLottoNumbers() {
        String input = "1,2,3,4,5,6";

        Lotto winningLotto = LottoGenerator.generateWinningLottoNumbers(input);

        assertThat(winningLotto).isNotNull();
        assertThat(winningLotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

}