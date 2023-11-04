package lotto;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    void 로또번호를_3개이상_맞춘경우_winningCount_증가() {
        // Arrange
        List<Integer> myNumber = List.of(2, 4, 5, 6, 7, 8);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 9;

        // Action
        Lotto lotto = new Lotto(myNumber);
        lotto.setWinningNumbersAndBonusNumber(winningNumbers, bonusNumber);

        // Assert
        assertThat(lotto.getWinningCount()).isEqualTo(4);
    }

    @Test
    void 일반번호와_보너스번호를_맞춘경우_WinningCount가_증가한다(){
        // Arrange
        List<Integer> myNumber = List.of(1, 2, 7, 8, 9, 10);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // Action
        Lotto lotto = new Lotto(myNumber);
        lotto.setWinningNumbersAndBonusNumber(winningNumbers, bonusNumber);

        // Assert
        assertThat(lotto.getWinningCount()).isEqualTo(3);
    }

    @Test
    void 일반번호_3개를_맞춘_경우_5000원_금액을_탈수있다(){
        // Arrange
        List<Integer> myNumber = List.of(1, 2, 3, 4, 5, 10);
        List<Integer> winningNumbers = List.of(1, 2, 3, 11, 12, 13);
        int bonusNumber = 14;

        // Action
        Lotto lotto = new Lotto(myNumber);
        lotto.setWinningNumbersAndBonusNumber(winningNumbers, bonusNumber);

        // Assert
        AssertionsForClassTypes.assertThat(lotto.getWinningMoney()).isEqualTo(5000);
    }

    @Test
    void 일반번호_4개를_와_보너스번호_1개를_맞춘_경우_3천만원_금액을_탈수있다(){
        // Arrange
        List<Integer> myNumber = List.of(1, 2, 3, 4, 5, 10);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 12, 13);
        int bonusNumber = 5;

        // Action
        Lotto lotto = new Lotto(myNumber);
        lotto.setWinningNumbersAndBonusNumber(winningNumbers, bonusNumber);

        // Assert
        AssertionsForClassTypes.assertThat(lotto.getWinningMoney()).isEqualTo(30000000);
    }

    @Test
    void 일반번호_5개를_맞춘_경우_천오백만원_금액을_탈수있다(){
        // Arrange
        List<Integer> myNumber = List.of(1, 2, 3, 4, 5, 10);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 13);
        int bonusNumber = 14;

        // Action
        Lotto lotto = new Lotto(myNumber);
        lotto.setWinningNumbersAndBonusNumber(winningNumbers, bonusNumber);

        // Assert
        AssertionsForClassTypes.assertThat(lotto.getWinningMoney()).isEqualTo(1500000);
    }
}