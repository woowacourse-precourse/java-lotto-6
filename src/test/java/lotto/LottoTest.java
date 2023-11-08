package lotto;

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

    @DisplayName("일치하는 갯수가 3개이면 가중치 6을 반환한다.")
    @Test
    void countThreeMatchingNumbersTest() {
        // Arrange
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        Lotto myLotto = new Lotto(List.of(1, 2, 3, 10, 11, 12));
        int bonusNumber = 4;

        // Act
        int weight = myLotto.countMatchingNumbers(winningLotto, bonusNumber);

        // Assert
        assertThat(weight).isEqualTo(6);
    }

    @DisplayName("일치하는 갯수가 4개이면 가중치 8을 반환한다.")
    @Test
    void countFourMatchingNumbersTest() {
        // Arrange
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        Lotto myLotto = new Lotto(List.of(1, 2, 3, 7, 11, 12));
        int bonusNumber = 4;

        // Act
        int weight = myLotto.countMatchingNumbers(winningLotto, bonusNumber);

        // Assert
        assertThat(weight).isEqualTo(8);
    }

    @DisplayName("일치하는 갯수가 5개이고 보너스 숫자가 일치하지 않으면 가중치 10을 반환한다.")
    @Test
    void countFiveMatchingNumbersTest() {
        // Arrange
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        Lotto myLotto = new Lotto(List.of(1, 2, 3, 7, 8, 12));
        int bonusNumber = 4;

        // Act
        int weight = myLotto.countMatchingNumbers(winningLotto, bonusNumber);

        // Assert
        assertThat(weight).isEqualTo(10);
    }

    @DisplayName("일치하는 갯수가 5개이고 보너스 숫자가 일치하면 가중치 11을 반환한다.")
    @Test
    void countFiveMatchingIncludeBonusNumbersTest() {
        // Arrange
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        Lotto myLotto = new Lotto(List.of(1, 2, 3, 7, 8, 12));
        int bonusNumber = 12;

        // Act
        int weight = myLotto.countMatchingNumbers(winningLotto, bonusNumber);

        // Assert
        assertThat(weight).isEqualTo(11);
    }

    @DisplayName("일치하는 갯수가 6개면 가중치 12을 반환한다.")
    @Test
    void countSixMatchingNumbersTest() {
        // Arrange
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        Lotto myLotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        int bonusNumber = 4;

        // Act
        int weight = myLotto.countMatchingNumbers(winningLotto, bonusNumber);

        // Assert
        assertThat(weight).isEqualTo(12);
    }


}