package lotto.method;

import lotto.UserController;
import lotto.method.uilogic.UserInterfaceLogic;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserControllerTest {

    @DisplayName("정상적인 로또 구입 금액을 입력하면 입력값을 정수로 반환한다.")
    @Test
    void 정상_로또_구입_금액_입력() {
        UserInterfaceLogic.setUserInput("1000");
        Assertions.assertThat(UserController.getLottoPrice()).isEqualTo(1000);
    }

    @DisplayName("잘못된 로또 구입 금액을 입력하면 정상적인 값을 입력할 때까지 다시 요청한다.")
    @Test
    void 비정상_로또_구입_금액_입력() {
        UserInterfaceLogic.setUserInput("1000q\n1001\n1000");
        Assertions.assertThat(UserController.getLottoPrice()).isEqualTo(1000);
    }
}
