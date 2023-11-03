package lotto;

import lotto.domain.Lotto;
import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

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
    @DisplayName("유효한 로또 번호 목록으로 Lotto 객체 생성")
    void givenValidNumbers_whenLottoCreated_thenSucceeds() {
        List<Integer> validNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertDoesNotThrow(() -> new Lotto(validNumbers));
    }

    @Test
    @DisplayName("Lotto 객체에서 번호 목록을 가져오면 변경 불가능한 목록이 반환됨")
    void whenGetNumbers_thenReturnsUnmodifiableList() {
        List<Integer> validNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(validNumbers);
        List<Integer> numbersFromLotto = lotto.getNumbers();

        assertThrows(UnsupportedOperationException.class, () -> {
            numbersFromLotto.add(7);
        });

        assertEquals(validNumbers, numbersFromLotto, "로또 번호 목록이 예상과 일치해야 함");
    }

    @Test
    @DisplayName("번호 목록 크기가 유효하지 않으면 예외 발생")
    void givenInvalidSizeNumbers_whenLottoCreated_thenThrowsException() {
        List<Integer> invalidSizeNumbers = Arrays.asList(1, 2, 3, 4, 5);
        assertThrows(LottoException.class, () -> new Lotto(invalidSizeNumbers));
    }

    @Test
    @DisplayName("번호 목록에 중복된 숫자가 있으면 예외 발생")
    void givenDuplicateNumbers_whenLottoCreated_thenThrowsException() {
        List<Integer> duplicateNumbers = Arrays.asList(1, 2, 3, 3, 4, 5);
        assertThrows(LottoException.class, () -> new Lotto(duplicateNumbers));
    }

    @Test
    @DisplayName("번호 목록에 범위를 벗어난 숫자가 있으면 예외 발생")
    void givenNumbersOutsideRange_whenLottoCreated_thenThrowsException() {
        List<Integer> numbersOutsideRange = Arrays.asList(0, 2, 3, 4, 5, 6);
        assertThrows(LottoException.class, () -> new Lotto(numbersOutsideRange));
    }
}