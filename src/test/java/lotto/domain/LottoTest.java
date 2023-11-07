package lotto.domain;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @DisplayName("로또 번호가 1과 45 사이 숫자가 아닐 때")
    @Test
    void createLottoByNoTNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, -1, 47)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("isContain 함수가 잘 동작하는 지 확인")
    @Test
    void testIsContain() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertAll(
                () -> assertTrue(lotto.isContain(1)),
                () -> assertTrue(lotto.isContain(2)),
                () -> assertTrue(lotto.isContain(3)),
                () -> assertTrue(lotto.isContain(4)),
                () -> assertTrue(lotto.isContain(5)),
                () -> assertTrue(lotto.isContain(6))
        );
    }

    @DisplayName("getNumber 정상 작동 확인")
    @Test
    void testGetNumber() {
        List<Integer> inputNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(inputNumbers);

        List<Integer> resultNumbers = lotto.getNumbers();

        assertEquals(inputNumbers, resultNumbers);
    }

    @DisplayName("로또 번호 정렬 확인")
    @Test
    void sortedLottoNumber() {
        List<Integer> numbers = List.of(6, 5, 4, 3, 2, 1);
        List<Integer> expectedLotto = List.of(1, 2, 3, 4, 5, 6);

        Lotto autualLotto = new Lotto(numbers);

        assertEquals(autualLotto.getNumbers(), expectedLotto);
    }
}