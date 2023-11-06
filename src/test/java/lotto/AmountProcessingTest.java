package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AmountProcessingTest {
    @Test
    void 발행한_로또_수량을_출력한다(){
        AmountProcessing amountProcessing = new AmountProcessing();
        int output = amountProcessing.getLottoCount(8000);
        assertEquals(8, output);
        int output2 = amountProcessing.getLottoCount(16000);
        assertEquals(16, output2);
        int output3 = amountProcessing.getLottoCount(12500);
        assertEquals(12, output3);
        int output4 = amountProcessing.getLottoCount(12345);
        assertEquals(12, output4);
    }
    
    // 테스트 다 하고 lotto처럼 validate 안에 집어넣자
    @DisplayName("1,000원으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    @Test
    void validateCostByDivided(){
        ValidateTools validateTools = new ValidateTools();
        assertThrows(IllegalArgumentException.class, () -> validateTools.validateDivided(1100));
        assertEquals(true, validateTools.validateDivided(1000));
    }

}
