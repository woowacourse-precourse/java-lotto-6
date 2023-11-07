package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    @DisplayName("중복된 숫자가 있을 때 예외를 발생시킨다")
    public void testCheckForDuplicates_ThrowsException_WhenDuplicatesPresent() {
        // 중복된 숫자를 포함하는 리스트 생성
        List<Integer> numbersWithDuplicates = Arrays.asList(1, 2, 3, 4, 5, 5);

        // Lotto 생성자에서 중복을 체크하므로 생성 시 예외가 발생해야 한다
        assertThrows(IllegalArgumentException.class, () -> new Lotto(numbersWithDuplicates));
    }

    @Test
    @DisplayName("숫자 범위가 유효하지 않을 때 예외를 발생시킨다")
    public void testValidateRange_ThrowsException_WhenNumberOutOfRange() {
        // 범위 밖의 숫자를 포함하는 리스트 생성
        List<Integer> numbersOutOfRange = Arrays.asList(1, 2, 3, 4, 5, 49);

        // 범위 검사 메서드 호출 시 예외가 발생해야 한다
        assertThrows(IllegalArgumentException.class, () -> new Lotto(numbersOutOfRange));
    }

}