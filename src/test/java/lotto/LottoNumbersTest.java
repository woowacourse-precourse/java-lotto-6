package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.record.LottoNumbers;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {

    @Test
    void lottoNumbers() {
        assertSimpleTest(() -> assertThat(new LottoNumbers(List.of(1, 2, 3, 4, 5, 6)).lottoNumbers())
                .isEqualTo(List.of(1, 2, 3, 4, 5, 6)));
    }
}