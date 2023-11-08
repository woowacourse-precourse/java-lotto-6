package lotto.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserBuyingExceptionTest {

    UserBuyingException userBuyingException = new UserBuyingException();

    @Test
    void 로또_구매_1000_단위_아닐_경우() {
        String pay = "1001";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                userBuyingException.validPrice(pay));
        assertEquals("[ERROR] 구매는 1,000원 단위로 가능합니다", exception.getMessage());
    }
    @Test
    void 숫자가_아닌_값을_입력한_경우() {
        String input = "NonNumeric";
        NumberFormatException exception = assertThrows(NumberFormatException.class, () ->
                userBuyingException.validIsNumber(input));
        assertEquals("[ERROR] 숫자를 입력하세요", exception.getMessage());
    }
}
