package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.constant.ExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    // 로또 번호 개수 관련 테스트
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.WINNING_NUMBERS_COUNT_EXCEPTION.getMessage());
    }

    @DisplayName("로또 번호의 개수가 6개가 안되면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.WINNING_NUMBERS_COUNT_EXCEPTION.getMessage());

        assertThatThrownBy(() -> new Lotto(List.of(1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.WINNING_NUMBERS_COUNT_EXCEPTION.getMessage());
    }

    @DisplayName("로또 번호의 개수가 6개이면 로또가 생성된다.")
    @Test
    void createLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Assertions.assertThat(lotto).isNotNull();
    }

    // 로또 번호 범위 관련 테스트
    @DisplayName("로또 번호가 1 ~ 45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.OUT_OF_RANGE_NUMBER_EXCEPTION.getMessage());

        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.OUT_OF_RANGE_NUMBER_EXCEPTION.getMessage());
    }

    @DisplayName("로또 번호가 1 ~ 45 사이의 숫자이면 로또가 생성된다.")
    @Test
    void createLottoByInRange() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Assertions.assertThat(lotto).isNotNull();

        lotto = new Lotto(List.of(45, 44, 43, 42, 41, 40));
        Assertions.assertThat(lotto).isNotNull();
    }

    // 로또 번호 중복 관련 테스트
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.DUPLICATE_NUMBER_EXCEPTION.getMessage());

        assertThatThrownBy(() -> new Lotto(List.of(45, 2, 3, 4, 5, 45)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.DUPLICATE_NUMBER_EXCEPTION.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 없으면 로또가 생성된다.")
    @Test
    void createLottoByNotDuplicatedNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Assertions.assertThat(lotto).isNotNull();

        lotto = new Lotto(List.of(45, 44, 43, 42, 41, 40));
        Assertions.assertThat(lotto).isNotNull();
    }
}
