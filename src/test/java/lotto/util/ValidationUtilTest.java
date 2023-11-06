package lotto.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ValidationUtilTest {

    private final ValidationUtil validationUtil = new ValidationUtil();

    @Test
    public void validateBuyValidAmount(){
        assertEquals(1000, validationUtil.validateBuy("1000"));
    }

    @Test
    public void validateBuyInvalidNumber(){
        assertThrows(IllegalArgumentException.class, () -> validationUtil.validateBuy("100a"));
    }

    @Test
    public void validateBuyNotDivideAmount(){
        assertThrows(IllegalArgumentException.class, () -> validationUtil.validateBuy("1005"));
    }

    @Test
    public void validateWinningNumber(){
        List<Integer> validNum = Arrays.asList(1,2,3,4,5,6);
        assertEquals(validNum, validationUtil.validateWinningNumber("1,2,3,4,5,6"));
    }
    @Test
    public void validateWinningNumberInvalidLength() {
        assertThrows(IllegalArgumentException.class, () -> validationUtil.validateWinningNumber("1,2,3"));
    }

    @Test
    public void validateWinningNumberInvalidRange() {
        assertThrows(IllegalArgumentException.class, () -> validationUtil.validateWinningNumber("0,49,2,3,4,5"));
    }

    @Test
    public void validateWinningNumberDuplicateNumbers() {
        assertThrows(IllegalArgumentException.class, () -> validationUtil.validateWinningNumber("1,1,2,3,4,5"));
    }
}
