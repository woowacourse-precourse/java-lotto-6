package lotto;

import lotto.view.LottoOutputView;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoOutputTest {

    @Test
    void 제대로_반올림() {
        double number = 2.34;
        double number2 = 2.35;
        LottoOutputView view = new LottoOutputView();
        Assertions.assertEquals(String.format("%.1f", view.roundToTwoDecimalPlaces(number)), "2.3");
        Assertions.assertEquals(String.format("%.1f", view.roundToTwoDecimalPlaces(number2)),
            "2.4");
    }

}
