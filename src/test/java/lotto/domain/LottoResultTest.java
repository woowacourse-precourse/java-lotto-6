package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @DisplayName("당첨 개수와 대응하는 상태를 반환한다.")
    @Test
    void createStatusByCoincidedLottoNumber() {
        int size = 5;

        assertThat(LottoResult.THIRD).isEqualTo(LottoResult.initiateLottoResult(size));
    }
}
