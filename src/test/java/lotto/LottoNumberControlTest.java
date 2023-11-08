package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberControlTest {
    @DisplayName("가격에 따른 로또 구매 개수가 맞는지 테스트한다.")
    @Test
    void getLottoCountTest() {
        LottoNumbersControl lottoNumbersControl = new LottoNumbersControl();
        int lottoCount = lottoNumbersControl.getLottoCount(15000);
        assertThat(lottoCount).isEqualTo(15);
    }
}
