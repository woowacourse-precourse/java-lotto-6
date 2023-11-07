package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.Controller.AmountProcessing;
import lotto.Controller.Calculate;
import lotto.Controller.ValidateTools;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AmountProcessingTest {

    
    // 테스트 다 하고 lotto처럼 validate 안에 집어넣자
    @DisplayName("1,000원으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    @Test
    void validateCostByDivided(){
        ValidateTools validateTools = new ValidateTools();
        assertThrows(IllegalArgumentException.class, () -> validateTools.validateDivided(1100));
        assertEquals(true, validateTools.validateDivided(1000));
    }

}
