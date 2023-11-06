package lotto;


import java.util.ArrayList;
import java.util.Arrays;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
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

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 번호에 입력된 값이 존재 하지 않으면 예외가 발생한다.")
    @Test
    void createLottoByBlankInput() {
        assertThatThrownBy(() -> new Lotto(List.of()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개 보다 작으면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또를 사는 금액의 입력이 1000원 단위가 아닐 경우 예외가 발생한다.")
    @Test
    void createLottoBuyMoneyByBlankInput() {
        assertThatThrownBy(() -> new Money(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또를 사는 금액의 입력이 1000원 단위가 아닐 경우 예외가 발생한다.")
    @Test
    void createLottoBuyMoneyNotThousandUnit() {
        assertThatThrownBy(() -> new Money("5500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또를 사는 금액의 입력이 정수가 아닐 경우 예외가 발생한다.")
    @Test
    void createLottoBuyMoneyNotInteger() {
        assertThatThrownBy(() -> new Money("NotNumber"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또를 사는 금액의 최대 금액은 10만원 이상이 될 경우 예외가 발생한다.")
    @Test
    void createLottoBuyMoneyOverTenThousand() {
        assertThatThrownBy(() -> new Money("200000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

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