package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import lotto.constant.ErrorMessage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ROICalculatorTest {

    private final ROICalculator roiCalculator = new ROICalculator();

    @Test
    @DisplayName("ROI가 올바르게 계산되는지 확인")
    void testCalculateROI() {
        long totalPrize = 2_000_000;
        long investment = 1_000_000;

        double expectedROI = 2.0;

        assertThat(roiCalculator.calculate(totalPrize, investment)).isEqualTo(expectedROI);
    }

    @Test
    @DisplayName("ROI가 소수 둘째자리에서 반올림되는지 확인")
    void testROIRounding() {
        long totalPrize = 1_000_000;
        long investment = 3;

        double expectedROI = 333333.33;

        assertThat(roiCalculator.calculate(totalPrize, investment)).isEqualTo(expectedROI);
    }
}
