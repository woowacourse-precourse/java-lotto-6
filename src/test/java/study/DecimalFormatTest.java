package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.DecimalFormat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DecimalFormatTest {
    private final DecimalFormat decimalFormat = new DecimalFormat("#,###");

    @DisplayName("DecimalFormat을 이용해서 숫자에 3자리마다 점이 찍혀서 출력된다.")
    @Test
    void printNumberWithDecimalFormat() {
        int input = 2000000000;
        assertThat(decimalFormat.format(input)).isEqualTo("2,000,000,000");
    }
}
