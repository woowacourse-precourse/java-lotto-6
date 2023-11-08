package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import camp.nextstep.edu.missionutils.Console;
import controller.UserController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputView;

public class UserTest {
    InputView inputView = new InputView();
    UserController userController = new UserController();

    @DisplayName("로또 구입 가격을 입력받은 후 올바르지 않으면 예외가 발생한다.")
    @Test
    void testInvalidInputPurchasePrice() {
        when(inputView.showInputPriceToUser()).thenReturn();
        doThrow(new IllegalArgumentException("올바르지 않은 입력입니다.")).when(Console.readLine());

        assertThatThrownBy(() -> userController.inputPriceHowManyLottos())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바르지 않은 입력입니다.");
    }

    @DisplayName("사용자가 유효한 로또 번호를 입력하는 기능 테스트")
    @Test
    void testValidInput() {
        when(inputView.showInputLottoNumberToUser()).thenReturn();
        doThrow(new IllegalArgumentException("올바르지 않은 입력입니다.")).when(Console.readLine());

        assertThatThrownBy(() -> userController.generateUserLottoNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바르지 않은 입력입니다.");
    }

    @DisplayName("사용자가 유효한 로또 보너스 번호를 입력하는 기능 테스트")
    @Test
    void testValidInput() {
        when(inputView.showInputBonusNumberToUser()).thenReturn();
        doThrow(new IllegalArgumentException("올바르지 않은 입력입니다.")).when(Console.readLine());

        assertThatThrownBy(() -> userController.inputBonusNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바르지 않은 입력입니다.");
    }

}
