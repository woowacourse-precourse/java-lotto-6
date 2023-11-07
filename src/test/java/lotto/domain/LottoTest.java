package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    @DisplayName("로또 생성 테스트")
    void newLotto() {
        new Lotto();
        new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("중복된 수가 있는 로또 예외 처리")
    void Given_DuplicatedNumberLotto_When_Then_ThrowsIllegalArgumentException() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 1, 1, 1, 1, 1))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("6개의 수로 이루어진 로또가 아님에 대한 예외 처리")
    void Given_InvalidLengthLotto_When_Then_ThrowsIllegalArgumentException() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 1, 1))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("유효 범위의 수를 갖는 로또에 대한 예외 처리")
    void Given_InvalidRangeLotto_When_Then_ThrowsIllegalArgumentException() {
        assertThatThrownBy(() -> new Lotto(List.of(-1, 46, 3, 4, 5, 6))).isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void compare() {
    }

    @Test
    void getNumbers() {
    }

    @Test
    void contains() {
    }

    @Test
    void toLotto() {
    }
}