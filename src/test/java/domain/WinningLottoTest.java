package domain;

import java.util.List;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import util.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest extends NsTest {

    private final WinningLotto winningLotto = new WinningLotto();

    @DisplayName("당첨 번호 설정 시 숫자 6개가 아니면 예외 발생")
    @Test
    void winningNumberIsntSix() {
        assertThatThrownBy(() ->  winningLotto.setWinningNumber(List.of(1,2,3,4)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->  winningLotto.setWinningNumber(List.of(1,2,3,4,5,6,7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 보너스 번호 존재 시 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6})
    void winningNumberContainBonusNumber(int bonusNumber) {
        winningLotto.setWinningNumber(List.of(1,2,3,4,5,6));
        assertThatThrownBy(() -> winningLotto.setBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(output()).isEqualTo(ErrorMessage.WINNING_NUMBER_AND_BONUS_NUMBER_ARE_SAME.getErrorMessage());
    }

    @DisplayName("주어진 로또 번호가 당첨 번호에 있는지 알려준다.")
    @Test
    void checkNumberIsInWinningNumber() {
        winningLotto.setWinningNumber(List.of(1,2,3,4,5,6));

        Assertions.assertEquals(true, winningLotto.isEqualToWinningNumber(1));
        Assertions.assertEquals(false, winningLotto.isEqualToWinningNumber(10));

    }

    @DisplayName("주어진 로또가 보너스 번호와 일치하는지 알려준다.")
    @Test
    void checkNumberIsEqualToBonusNumber() {
        winningLotto.setWinningNumber(List.of(1,2,3,4,5,6));
        winningLotto.setBonusNumber(7);

        Assertions.assertEquals(true, winningLotto.isEqualToBonusNumber(7));
        Assertions.assertEquals(false, winningLotto.isEqualToBonusNumber(44));
    }

    @Override
    public void runMain(){
    }
}