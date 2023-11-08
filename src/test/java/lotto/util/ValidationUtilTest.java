package lotto.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationUtilTest {

    private final ValidationUtil validationUtil = new ValidationUtil();

    @Test
    @DisplayName("적절한 금액이 들어갔는지 테스트")
    public void validateBuyValidAmount(){
        assertEquals(1000, validationUtil.validateBuy("1000"));
    }

    @Test
    @DisplayName("부적절한 금액이 들어갔는지 테스트")
    public void validateBuyInvalidNumber(){
        assertThrows(IllegalArgumentException.class, () -> validationUtil.validateBuy("100a"));
    }
    @Test
    @DisplayName("나눠떨어지지않는 금액이 들어갔는지 테스트")
    public void validateBuyNotDivideAmount(){
        assertThrows(IllegalArgumentException.class, () -> validationUtil.validateBuy("1005"));
    }

    @Test
    @DisplayName("값 변환 테스트")
    public void validateWinningNumber(){
        List<Integer> validNum = Arrays.asList(1,2,3,4,5,6);
        assertEquals(validNum, validationUtil.validateWinningNumber("1,2,3,4,5,6"));
    }
    @Test
    @DisplayName("길이 제한 테스트")
    public void validateWinningNumberInvalidLength() {
        assertThrows(IllegalArgumentException.class, () -> validationUtil.validateWinningNumber("1,2,3"));
    }

    @Test
    @DisplayName("맞는 범위의 숫자 테스트")
    public void validateWinningNumberInvalidRange() {
        assertThrows(IllegalArgumentException.class, () -> validationUtil.validateWinningNumber("0,49,2,3,4,5"));
    }

    @Test
    @DisplayName("당첨번호와 보너스 번호가 중복되는지 테스트")
    public void validateWinningNumberDuplicateNumbers() {
        assertThrows(IllegalArgumentException.class, () -> validationUtil.validateBonusNumberDuplicate(3, Arrays.asList(1,2,3,4,5,6)));
    }
}
