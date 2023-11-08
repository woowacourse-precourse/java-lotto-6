package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ROICalculatorTest {

    private final ROICalculator roiCalculator = new ROICalculator();

    @Test
    @DisplayName("ROI가 올바르게 계산되는지 확인")
    void testCalculateROI() {
        long totalPrize = 2_000_000;
        long investment = 1_000_000;

        double expectedROI = 200.0;

        assertThat(roiCalculator.calculate(totalPrize, investment)).isEqualTo(expectedROI);
    }
    @Test
    @DisplayName("ROI가 소수 둘째자리에서 반올림 되는지 확인")
    void testROIRoundingForSecondDecimal() {
        ROICalculator roiCalculator = new ROICalculator();

        long totalPrize = 117;
        long investment = 100;
        double expectedROI = 117.0;

        assertThat(roiCalculator.calculate(totalPrize, investment)).isEqualTo(expectedROI);
    }

    @Test
    @DisplayName("ROI 계산이 정확하게 이루어지는지 확인")
    void testROICalculation() {
        ROICalculator roiCalculator = new ROICalculator();

        long totalPrize = 1_000_000;
        long investment = 3;
        double expectedROI = 3.33333333E7;

        assertThat(roiCalculator.calculate(totalPrize, investment)).isEqualTo(expectedROI);
    }

}
