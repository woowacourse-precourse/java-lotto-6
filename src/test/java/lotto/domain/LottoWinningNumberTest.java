package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoWinningNumberTest {

    @DisplayName("유효한 당첨 번호를 입력하면 LottoWinningNumber 클래스의 인스턴스가 생성된다.")
    @Test
    void Given_InvalidNumbers_When_CreateLottoWinningNumberInstance_Then_IsNotNull() {
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
    void Given_NumbersOfOverSixSize_When_CreateLottoWinningNumberInstance_Then_ThrowException() {
        // Given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 40, 20);

        // When & Then
        assertThatThrownBy(() -> new LottoWinningNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 당첨 번호입니다.");
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void Given_DuplicateNumbers_When_CreateLottoWinningNumberInstance_Then_ThrowException() {
        // Given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 2);

        // When & Then
        assertThatThrownBy(() -> new LottoWinningNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 당첨 번호입니다.");
    }

    @DisplayName("당첨 번호에 범위를 벗어나는 숫자가 있으면 예외가 발생한다.")
    @Test
    void Given_NotInRangeNumbers_When_CreateLottoWinningNumberInstance_Then_ThrowException() {
        // Given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 50);

        // When & Then
        assertThatThrownBy(() -> new LottoWinningNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 당첨 번호입니다.");
    }
}
