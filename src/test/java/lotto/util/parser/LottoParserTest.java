package lotto.util.parser;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import lotto.model.Lotto;
import lotto.model.Prize;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoParserTest {
    @DisplayName("Lotto를 Prize로 파싱한다.")
    @Test
    void parseLottoToPrize() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 11, 22)), 7);
        assertThat(LottoParser.parseLottoToPrize(lotto, winningLotto)).isEqualTo(Prize.of(4, false));
    }
}
