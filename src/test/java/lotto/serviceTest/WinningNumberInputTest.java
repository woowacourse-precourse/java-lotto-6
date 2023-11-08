package lotto.serviceTest;

import exception.CustomException;
import lotto.domain.Lotto;
import lotto.service.WinningNumberInput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumberInputTest {

    @DisplayName("당첨번호입력시 숫자를 입력하면 통과")
    @Test
    void testValidateString() throws NoSuchMethodException {
        String[] numbers = new String[]{
                "1", "2", "3", "4", "5", "6"
        };

        try {
            WinningNumberInput winningNumberInput = new WinningNumberInput();
            Method method = WinningNumberInput.class.getDeclaredMethod("isNumber", String[].class);
            method.setAccessible(true);
            method.invoke(winningNumberInput, (Object) numbers);
        } catch (CustomException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @DisplayName("당첨번호입력시 문자열을 입력하면 예외발생")
    @Test
    void testValidateNumber() throws NoSuchMethodException {
        String[] numbers = new String[]{
                "a", "2", "3", "4", "5", "6"
        };

        try {
            WinningNumberInput winningNumberInput = new WinningNumberInput();
            Method method = WinningNumberInput.class.getDeclaredMethod("isNumber", String[].class);
            method.setAccessible(true);
            method.invoke(winningNumberInput, (Object) numbers);
        } catch (CustomException | IllegalAccessException | InvocationTargetException e) {
            assertThat(e.getCause().getMessage()).isEqualTo("[ERROR] 숫자로 입력해 주세요");
        }
    }

    @DisplayName("당첨번호와 보너스번호의 숫자가 중복된 값이 입력되면 예외발생")
    @Test
    void testContainCheck() {
        int number = 1;

        try {
            WinningNumberInput winningNumberInput = new WinningNumberInput(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
            Method method = WinningNumberInput.class.getDeclaredMethod("containCheck", int.class);
            method.setAccessible(true);
            method.invoke(winningNumberInput, number);
        } catch (CustomException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            assertThat(e.getCause().getMessage()).isEqualTo("[ERROR] 당첨번호와 중복되지 않은 값을 입력해 주세요.");
        }
    }

    @DisplayName("당첨번호나 보너스번호릐 숫자가 1미만 45초과일때 예외 발생")
    @Test
    void testIsBetween1And45(){
        int number = 55;
        try {
            WinningNumberInput winningNumberInput = new WinningNumberInput();
            Method method = WinningNumberInput.class.getDeclaredMethod("isBetween1And45", int.class);
            method.setAccessible(true);
            method.invoke(winningNumberInput, number);
        }catch (CustomException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            assertThat(e.getCause().getMessage()).isEqualTo("[ERROR] 1이상 45이하의 숫자를 입력해 주세요.");
        }
    }
}
