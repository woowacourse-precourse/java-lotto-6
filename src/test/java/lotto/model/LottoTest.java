package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

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

    @DisplayName("구매한 로또 번호와 당첨 번호를 비교하여 일치한 번호 개수를 출력한다.(보너스 번호가 일치하지 않을 때")
    @Test
    void createCompareLotto(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        WinningNumber winningNumber = new WinningNumber(List.of(3,4,5,6,7,8));
        winningNumber.setBonusNumber(String.valueOf(10));

        int comparisonResult = lotto.compareLotto(winningNumber.getWinningNumber(), winningNumber.getBonusNumber());
        assertThat(comparisonResult).isEqualTo(4);
    }

    @DisplayName("구매한 로또 번호와 당첨 번호를 비교하여 일치한 번호 개수를 출력한다.(보너스 번호가 일치할 때)")
    @Test
    void createCompareLottoBonusMatch(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        WinningNumber winningNumber = new WinningNumber(List.of(3,4,5,6,1,10));
        winningNumber.setBonusNumber(String.valueOf(10));

        int comparisonResult = lotto.compareLotto(winningNumber.getWinningNumber(), winningNumber.getBonusNumber());
        assertThat(comparisonResult).isEqualTo(7);
    }
}