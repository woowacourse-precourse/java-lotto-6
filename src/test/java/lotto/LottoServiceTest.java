package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.LottoService.rorDoubleToString;

class LottoServiceTest {

    @DisplayName("수익률 형식 검사")
    @Test
    void testRorDoubleToString() {
        Double ror = 1000000.0;
        String formattedRor = "1,000,000.0";
        Assertions.assertThat(rorDoubleToString(ror)).isEqualTo(formattedRor);
    }

    @DisplayName("수익률 반올림 검사")
    @Test
    void testRor() {
        Double ror = 12.189;
        String formattedRor = "12.2";
        Assertions.assertThat(rorDoubleToString(ror)).isEqualTo(formattedRor);
    }
}