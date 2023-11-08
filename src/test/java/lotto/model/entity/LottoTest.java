package lotto.model.entity;

import java.util.List;
import lotto.model.entity.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.view.ExceptionMessage;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    private Lotto lotto;
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

    @BeforeEach
    void setUp() {
        lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("로또에는 여섯 개의 번호가 있다")
    @Test
    void lotto_HasSixNumbers() {
        assertThat(lotto.getNumbers()).hasSize(6);
    }

    @DisplayName("로또 번호는 고유하다")
    @Test
    void lotto_NumbersAreUnique() {
        assertThat(lotto.getNumbers()).doesNotHaveDuplicates();
    }

    @DisplayName("번호에 중복이 있을 경우 예외 발생")
    @Test
    void lotto_ThrowsException_WhenDuplicateNumbers() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 3, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.DUPLICATE_NUMBER_ERROR.getMessage());
    }

    @DisplayName("여섯 개의 번호가 아닐 경우 예외 발생")
    @Test
    void lotto_ThrowsException_WhenNotSixNumbers() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_NUMBER_COUNT.getMessage());
    }

    @DisplayName("여섯 개 이상의 번호가 있을 경우 예외 발생")
    @Test
    void lotto_ThrowsException_WhenMoreThanSixNumbers() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_NUMBER_COUNT.getMessage());
    }

    @DisplayName("로또의 toString이 올바른 형식을 반환한다")
    @Test
    void lotto_ToString_ReturnsCorrectFormat() {
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
    // 아래에 추가 테스트 작성 가능
}