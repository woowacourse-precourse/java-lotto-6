package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.DecimalFormat;
import org.junit.jupiter.api.Test;

class JudgementTest {
    @Test
    void 반올림_계산() {
        double roundedReturn = Math.round(35.789 * 10.0) / 10.0;
        assertThat(roundedReturn).isEqualTo(35.8);
    }

    @Test
    void 문자열_format() {
        String formattedRate = String.valueOf(1345.7);
        assertThat(formattedRate.length()).isEqualTo(6);
    }

    @Test
    void 천_단위_comma() {
        double returnRate = 13255255588.8;
        DecimalFormat df = new DecimalFormat("###,###.#");
        String formattedRate = df.format(returnRate);
        assertThat(formattedRate).isEqualTo("13,255,255,588.8");
    }
}