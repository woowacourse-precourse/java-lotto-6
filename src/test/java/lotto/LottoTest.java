package lotto;

import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.domain.WinningLotto;
import lotto.view.InputMoneySpentOnLottoView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있다면 예외가 발생한다.")
    @Test
    void createWinningLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호에 있다면 예외가 발생한다.")
    @Test
    void createBonusNumberByDuplicatedNumberInLotto() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6)).setBonusNumber(6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 번호는 1~45 사이의 숫자가 아니라면 예외가 발생한다.")
    @Test
    void LottoNumberRangeCheck() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 60)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호는 1~45 사이의 숫자가 아니라면 예외가 발생한다.")
    @Test
    void BonusNumberRangeCheck() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6)).setBonusNumber(60))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 구입 금액이 0원일 때 예외가 발생한다.")
    @Test
    void userMoneyZero() {
        assertThatThrownBy(() -> new User(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 구입 금액이 1000의 배수가 아니라면 예외가 발생한다.")
    @Test
    void userMoneyThousands() {
        assertThatThrownBy(() -> new User(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }
}