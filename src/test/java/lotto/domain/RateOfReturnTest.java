package lotto.domain;

import lotto.utility.GameUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("수익률 계산 테스트")
public class RateOfReturnTest {
    @ParameterizedTest
    @DisplayName("입력 대비 수익률을 계산하는 테스트")
    @CsvSource(value = "1000,10,10000.0")
    void 입력_대비_수익률_테스트(int winningPrize, int payment, float rateOfReturn) {
        // when, then
        Assertions.assertEquals(GameUtility.calculateRateOfReturn(winningPrize, payment),rateOfReturn);
    }
}
