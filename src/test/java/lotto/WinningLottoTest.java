package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {
    @DisplayName("로또 당첨 번호의 입력을 하지 않을 경우 예외가 발생한다.")
    @Test
    void createWinningLottoByBlankInput() {
        assertThatThrownBy(() -> new WinningLotto(List.of()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 번호에 중복 입력이 존재할 경우 예외가 발생한다.")
    @Test
    void createWinningLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 번호가 6개 이상일 경우 예외가 발생한다.")
    @Test
    void createWinningLottoByOverSize() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 번호가 6개 이하일 경우 예외가 발생한다.")
    @Test
    void createWinningLottoByUnderSize() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 보너스 번호가 빈칸일 경우 예외가 발생한다.")
    @Test
    void createBonusNumberByBlankInput() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(input);
        assertThatThrownBy(() -> winningLotto.addBonusNumber(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 보너스 번호가 정수가 아닐 경우 예외가 발생한다.")
    @Test
    void createBonusNumberByNotInteger() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(input);
        assertThatThrownBy(() -> winningLotto.addBonusNumber("NotNumber"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 보너스 번호가 45를 초과할 경우 예외가 발생한다..")
    @Test
    void createBonusNumberByOverMaxInput() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(input);
        assertThatThrownBy(() -> winningLotto.addBonusNumber("46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 보너스 번호가 1을 미만일 경우 예외가 발생한다.")
    @Test
    void createBonusNumberByOverMinInput() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(input);
        assertThatThrownBy(() -> winningLotto.addBonusNumber("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 보너스 번호가 중복될 경우 오류가 발생한다.")
    @Test
    void createBonusNumberByDuplicatedNumber() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(input);
        assertThatThrownBy(() -> winningLotto.addBonusNumber("5"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
