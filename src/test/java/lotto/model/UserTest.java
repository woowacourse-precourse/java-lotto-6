package lotto.model;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserTest {

    @Test
    void PurchaseAmount_Test_ValidInput() {
        // given
        User user = new User();
        String input = "5000";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        int result = user.inputPurchaseAmount();

        // then
        assertEquals(5000, result);
    }

    @Test
    void inputPurchaseAmount_Test_InvalidInput_Range() {
        // given
        User user = new User();
        String input = "999";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when, then
        assertThrows(IllegalArgumentException.class, () -> user.inputPurchaseAmount());
    }

    @Test
    void inputPurchaseAmount_Test_InvalidInput_Character() {
        // given
        User user = new User();
        String input = "5000j";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when, then
        assertThrows(IllegalArgumentException.class, () -> user.inputPurchaseAmount());
    }

}