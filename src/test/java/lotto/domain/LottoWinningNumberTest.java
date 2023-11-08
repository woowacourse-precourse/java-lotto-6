package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoWinningNumberTest {

    @DisplayName("유효한 당첨 번호를 입력하면 LottoWinningNumber 클래스의 인스턴스가 생성된다.")
    @Test
    void createLottoWinningNumber() {
        // Given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 40);

        // When
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(numbers);

        // Then
        assertThat(lottoWinningNumber).isNotNull();
        assertThat(lottoWinningNumber.getNumbers()).isEqualTo(numbers);
    }

    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoWinningNumberWithOverSizeWinningNumbers() {
        // Given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 40, 20);

        // When & Then
        assertThatThrownBy(() -> new LottoWinningNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 당첨 번호입니다.");
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoWinningNumberWithEqualNumber() {
        // Given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 2);

        // When & Then
        assertThatThrownBy(() -> new LottoWinningNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 당첨 번호입니다.");
    }

    @DisplayName("당첨 번호에 범위를 벗어나는 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoWinningNumberWithNotInRangeNumbers() {
        // Given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 50);

        // When & Then
        assertThatThrownBy(() -> new LottoWinningNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 당첨 번호입니다.");
    }

    @DisplayName("입력된 로또 번호와 비교해서 당첨 번호와 일치하는 숫자 개수를 반환한다.")
    @Test
    void returnMatchedNumberCount() throws Exception {
        // Given
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(List.of(1, 2, 3, 20, 12, 24));
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // When
        int equalNumberCount = lottoWinningNumber.equalLottoNumbersWithWinningNumbers(lotto);

        // Then
         assertThat(equalNumberCount).isEqualTo(3);
    }
}
