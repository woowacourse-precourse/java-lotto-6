package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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

    @DisplayName("로또 번호가 1보다 작은 수를 포함하면 예외가 발생한다.")
    @Test
    void createLottoByContainingLessThanOne() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 45보다 큰 수를 포함하면 예외가 발생한다.")
    @Test
    void createLottoByContainingMoreThanFortyFive() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개 미만이면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유효한 로또 번호를 입력하면 객체가 성공적으로 생성된다.")
    @Test
    void createLottoWithValidNumbers() {
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6))).isInstanceOf(Lotto.class);
    }

    @DisplayName("로또 번호 입력이 null이면 예외가 발생한다.")
    @Test
    void createLottoWithNullInput() {
        assertThatThrownBy(() -> new Lotto(null))
                .isInstanceOf(NullPointerException.class);
    }

    @DisplayName("로또 번호 입력이 비어있으면 예외가 발생한다.")
    @Test
    void createLottoWithEmptyInput() {
        assertThatThrownBy(() -> new Lotto(List.of()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유효한 범위의 번호를 다른 순서로 입력해도 객체가 성공적으로 생성된다.")
    @Test
    void createLottoWithNumbersInDifferentOrder() {
        assertThat(new Lotto(List.of(6, 5, 4, 3, 2, 1))).isInstanceOf(Lotto.class);
    }

    @DisplayName("로또 번호가 정렬된 리스트를 포함하면 객체가 성공적으로 생성된다.")
    @Test
    void createLottoWithSortedNumbers() {
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6))).isInstanceOf(Lotto.class);
    }

    @DisplayName("로또 번호에 음수가 포함되면 예외가 발생한다.")
    @Test
    void createLottoWithNegativeNumbers() {
        assertThatThrownBy(() -> new Lotto(List.of(-1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 45보다 큰 숫자가 포함되면 예외가 발생한다.")
    @Test
    void createLottoWithNumbersGreaterThanFortyFive() {
        assertThatThrownBy(() -> new Lotto(List.of(10, 20, 30, 40, 46, 47)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 정수가 아닌 값을 포함하면 예외가 발생한다.")
    @Test
    void createLottoWithNonIntegerValues() {
        List rawListWithStrings = Arrays.asList(1, 2, 3, 4, 5, "a");
        assertThatThrownBy(() -> new Lotto(rawListWithStrings))
                .isInstanceOf(ClassCastException.class);
    }

}