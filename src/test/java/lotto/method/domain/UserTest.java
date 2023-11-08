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
    void inputLottoPayment() {
        UserInterfaceLogic.setUserInput("8000");
        assertThat(user.buyLotto()).size().isEqualTo(8);
    }

    @Test
    @DisplayName("잘못된 로또 구입 금액을 입력하면 정상적인 값을 입력할 때까지 다시 요청한다.")
    void requestAgainWhenInputWrongPayment() {
        UserInterfaceLogic.setUserInput("8000q\n8111\n8000");
        assertThat(user.buyLotto()).size().isEqualTo(8);
    }

    @Test
    @DisplayName("로또 당첨 번호와 보너스 번호를 입력하면 해당 값을 가지는 LottoWinningNumber 객체를 반환한다.")
    void inputWinningNumberAndBonusNumber() {
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber();
        lottoWinningNumber.setLotto(new Lotto(List.of(1,2,3,4,5,6)));
        lottoWinningNumber.setBonusNumber(7);

        UserInterfaceLogic.setUserInput("1,2,3,4,5,6\n7");
        assertThat(user.createWinningLottoNumber()).isInstanceOf(LottoWinningNumber.class);
    }

    @Test
    @DisplayName("잘못된 로또 당첨 번호나 보너스 번호를 입력하면 잘못 입력된 부분부터 다시 요청한다.")
    void requestAgainWhenInputWrongWinningNumberAndBonusNumber() {
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber();
        lottoWinningNumber.setLotto(new Lotto(List.of(1,2,3,4,5,6)));
        lottoWinningNumber.setBonusNumber(7);

        UserInterfaceLogic.setUserInput("1,2,3,4,5,5\n1,2,3,4,5,6f\n1,2,3,4,5,6" +  // 로또 당첨 번호 재입력
                                        "\n6\n0\n7");                               // 보너스 번호 재입력
        assertThat(user.createWinningLottoNumber()).isInstanceOf(LottoWinningNumber.class);
    }
}
