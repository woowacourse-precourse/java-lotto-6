package lotto.util;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
    }

    @Test
    void 유저가_입력한_지불_금액이_올바른_입력인지_테스트() {
        String inputAmount1 = "8000";
        String inputAmount2 = "100000";
        String inputAmount3 = "0";
        String inputAmount4 = "80a0";
        String inputAmount5 = " 8000";
        String inputAmount6 = "80 00";

        Assertions.assertDoesNotThrow(() -> {
            user.checkInvalidPaymentAmount(inputAmount1);
        });
        Assertions.assertDoesNotThrow(() -> {
            user.checkInvalidPaymentAmount(inputAmount2);
        });
        Assertions.assertDoesNotThrow(() -> {
            user.checkInvalidPaymentAmount(inputAmount3);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            user.checkInvalidPaymentAmount(inputAmount4);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            user.checkInvalidPaymentAmount(inputAmount5);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            user.checkInvalidPaymentAmount(inputAmount6);
        });
    }

    @Test
    void 지불금액이_1000원_단위인지_테스트(){
        String inputAmount1 = "8000";
        String inputAmount2 = "111000";
        String inputAmount3 = "1000";
        String inputAmount4 = "2200";
        String inputAmount5 = "1001";
        String inputAmount6 = "1100";

        Assertions.assertDoesNotThrow(() -> {
            user.inputPaymentAmount(inputAmount1);;
        });
        Assertions.assertDoesNotThrow(() -> {
            user.inputPaymentAmount(inputAmount2);;
        });
        Assertions.assertDoesNotThrow(() -> {
            user.inputPaymentAmount(inputAmount3);;
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            user.inputPaymentAmount(inputAmount4);;
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            user.inputPaymentAmount(inputAmount5);;
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            user.inputPaymentAmount(inputAmount6);;
        });
    }
}