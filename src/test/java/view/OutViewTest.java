package view;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.text.DecimalFormat;
import org.junit.jupiter.api.Test;

public class OutViewTest {

    @Test
    void 소수점_둘째_자리에서_반올림_한다() {
        double decimalPoint = 0.625;
        String expected = "62.5%";
        DecimalFormat decimalFormat = new DecimalFormat("#.0%");
        String roundedRate1 = decimalFormat.format(decimalPoint);
        assertThat(roundedRate1).isEqualTo(expected);
    }
}
