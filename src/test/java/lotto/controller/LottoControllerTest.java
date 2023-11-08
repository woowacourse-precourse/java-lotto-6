package lotto.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.Application;
import lotto.model.Lotto;
import lotto.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoControllerTest extends NsTest {

    private LottoController lottoController = new LottoController();

    @DisplayName("로또 구입 금액은 로또 금액인 1,000원 단위로 입력하지 않으면 예외가 발생한다.")
    @Test
    void inputMoneyLessThanLottoMoney() {
        assertSimpleTest(() -> {
            runException("2300");
            assertThat(output()).contains("[ERROR]금액은 1,000원 단위로 입력해 주세요.");
        });
    }

    @DisplayName("당첨번호에 숫자가 아닌 값을 입력하면 예외가 발생한다.")
    @Test
    void inputStringIntoWinningNumber() {
        // assertThat(lottoController.validateWinningNumbers("number,23,5").)
        assertThatThrownBy(() -> lottoController.validateBonusNumber("number,abc,3,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("당첨번호에 1~45사이의 값이 아닌 다른 값을 입력하면 예외가 발생한다.")
    @Test
    void inputOutOfLottoNumberRange() {
        assertThatThrownBy(() -> lottoController.validateWinningNumbers("1,2,3,4,5,99"))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("당첨번호를 6개보다 적게 입력하면 예외가 발생한다.")
    @Test
    void inputSmallLengthThan6() {
        assertThatThrownBy(() -> lottoController.saveWinningNumber("1,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);

    }


    @DisplayName("당첨번호를 6개보다 많이 입력하면 예외가 발생한다.")
    @Test
    void inputMoreLengthThan6() {
        assertThatThrownBy(() -> lottoController.saveWinningNumber("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);

    }
//    @DisplayName("당첨번호 숫자가 1~45사이가 아닐 경우 예외가 발생한다")
//
//    @DisplayName("보너스번호 숫자가 1~45사이가 아닐 경우 예외가 발생한다")


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
