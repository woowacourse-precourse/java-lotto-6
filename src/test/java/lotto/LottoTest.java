package lotto;

import lotto.domain.Lotto;
import lotto.exception.LottoNumberOutOfRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @DisplayName("로또 번호 중 유효 범위를 넘는 값이 있으면 예외가 발생한다.")
    @Test
    void createLottoByNumbersOutOfRange() {
        assertThatThrownBy(() -> new Lotto(List.of(-1, 2, 3, 4, 5, 6)))
                .isInstanceOf(LottoNumberOutOfRangeException.class);
    }

    @DisplayName("올바르게 다른 로또와 일치하는 번호의 개수 계산")
    @Test
    void countMatchingNumbersWithOtherLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto other = new Lotto(List.of(1, 2, 4, 8, 6, 7));
        int expectedResult = 4;

        // When
        int matchingNumberCount = lotto.countMatchingNumbersWith(other);

        // Then
        assertEquals(expectedResult, matchingNumberCount);
    }
}