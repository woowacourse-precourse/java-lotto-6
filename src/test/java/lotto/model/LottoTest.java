package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("[Test - Lotto]")
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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 생성 테스틑 - 정렬")
    @Test
    void sortLottoNumbersTest() {
        // Given
        List<Integer> checkLotto = List.of(1,2,3,4,5,6);

        // When
        Lotto lotto = new Lotto(List.of(6,5,4,3,2,1));

        // Then
        assertThat(lotto.getNumbers()).isEqualTo(checkLotto);
    }

    @DisplayName("로또 당첨 테스트 - 발행된 로또가 당첨번호에 몇 개 포함되는지")
    @Test
    void isContainWinningLottoNumberTest1() {
        // Given
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        List<Integer> winningLottoNumber = List.of(1,2,3,4,5,6);
        int containNum = 6;

        // When
        int amountOfContaining = lotto.isContainWinningLottoNumber(winningLottoNumber);

        // Then
        assertThat(amountOfContaining).isEqualTo(containNum);
    }

    @DisplayName("로또 당첨 테스트 - 발행된 로또가 당첨번호에 몇개 포함되는지")
    @Test
    void isContainWinningLottoNumberTest2() {
        // Given
        Lotto lotto = new Lotto(List.of(1,3,5,7,8,12));
        List<Integer> winningLottoNumber = List.of(1,2,3,4,5,6);
        int containNum = 3;

        // When
        int amountOfContaining = lotto.isContainWinningLottoNumber(winningLottoNumber);

        // Then
        assertThat(amountOfContaining).isEqualTo(containNum);
    }
}