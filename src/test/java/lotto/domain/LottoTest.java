package lotto.domain;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import java.util.Arrays;
import java.util.List;

public class LottoTest {

    @DisplayName("로또 생성 정상 테스트")
    @Test
    public void testLottoCreationWithValidNumbers() {
        // Given
        List<Integer> validLottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // When
        Executable creation = () -> new Lotto(validLottoNumbers);

        // Then
        assertDoesNotThrow(creation);
    }

    @DisplayName("로또 생성 숫자 개수 부족 예외 테스트")
    @Test
    public void testLottoCreationThrowsExceptionWithInvalidNumbers() {
        // Given
        List<Integer> invalidLottoNumbers = Arrays.asList(1, 2, 3, 4, 5); // Invalid list, too short

        // When & Then
        assertThatThrownBy(() -> new Lotto(invalidLottoNumbers))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_NUMBER_COUNT_ERROR.getMessage());
    }

    @DisplayName("로또 숫자 반환 컬렉션 값 변경 예외 테스트")
    @Test
    public void testGetNumbersReturnsUnmodifiableList() {
        // Given
        List<Integer> validLottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(validLottoNumbers);

        // When
        List<Integer> numbers = lotto.getNumbers();

        // Then
        assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> numbers.add(7))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
