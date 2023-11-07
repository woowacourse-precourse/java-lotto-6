package lotto.method.domain;

import lotto.domain.Lotto;
import lotto.domain.LottoWinningNumber;
import lotto.domain.User;
import lotto.method.domain.uilogic.UserInterfaceLogic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {
    private final User user = new User();

    @Test
    @DisplayName("로또 구입 금액을 입력하면 금액에 따라 로또를 반환한다.")
    void 정상_로또_구입_금액_입력() {
        UserInterfaceLogic.setUserInput("8000");
        assertThat(user.buyLotto()).size().isEqualTo(8);
    }

    @Test
    @DisplayName("잘못된 로또 구입 금액을 입력하면 정상적인 값을 입력할 때까지 다시 요청한다.")
    void 비정상_로또_구입_금액_입력시_재요청() {
        UserInterfaceLogic.setUserInput("8000q\n8111\n8000");
        assertThat(user.buyLotto()).size().isEqualTo(8);
    }
}
