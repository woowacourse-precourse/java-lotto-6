package lotto.serviceTest;

import exception.CustomException;
import lotto.service.LottoPurchase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPurchaseTest {

    @DisplayName("구입금액이 문자열일때 예외 발생")
    @Test
    void testPurchaseNumberString() throws NoSuchMethodException {
        try {
            String userPurchase = "money";
            LottoPurchase lottoPurchase = new LottoPurchase(userPurchase);
            Method method = LottoPurchase.class.getDeclaredMethod("validateNumber");
            method.setAccessible(true);
            method.invoke(lottoPurchase);
        } catch (CustomException | IllegalAccessException | InvocationTargetException e) {
            assertThat(e.getCause().getMessage()).isEqualTo("[ERROR] 숫자로 입력해 주세요");
        }
    }

    @DisplayName("구입금액이 맞게 입력되었을때")
    @Test
    void testPurchaseNumber() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String userPurchase = "2000";
        LottoPurchase lottoPurchase = new LottoPurchase(userPurchase);
        Method method = LottoPurchase.class.getDeclaredMethod("validateNumber");
        method.setAccessible(true);
        assertThat(method.invoke(lottoPurchase)).isEqualTo(2000);
    }

    @DisplayName("입력된 값이 1000으로 나누어 떨어지지 않을때")
    @Test
    void testIsDivisibleBt1000() throws NoSuchMethodException {
        try {
            int number = 50;
            LottoPurchase lottoPurchase = new LottoPurchase();
            Method method = LottoPurchase.class.getDeclaredMethod("isDivisibleBy1000", int.class);
            method.setAccessible(true);
            method.invoke(lottoPurchase, number);
        } catch (CustomException | IllegalAccessException | InvocationTargetException e) {
            assertThat(e.getCause().getMessage()).isEqualTo("[ERROR] 잔돈이 발생합니다. 1000으로 나누어떨어지는 수를 입력하세요");
        }
    }
}
