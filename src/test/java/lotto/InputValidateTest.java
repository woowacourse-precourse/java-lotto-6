package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.exception.LottoGameException;
import lotto.util.Validate;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputValidateTest {
    @Test
    void purchaseAmountValidateTest() {
        String input = "as";
        assertThrows(LottoGameException.class, () -> Validate.checkPurchaseAmountValidate(input));
    }

    @Test
    void checkIntegerTest() {
        String input = "1 ";
        assertEquals(1, Validate.checkIntegerAndSpace(input));
    }

    @Test
    void checkDuplicateTest() {
        List<String> input1 = new ArrayList<>(Arrays.asList("1","1","3","4","5","6"));
        List<Integer> input2 = new ArrayList<>(Arrays.asList(1,1,3,4,5,6));
        assertThrows(LottoGameException.class, () -> Validate.checkDuplicated(input1,input2));
    }
}
