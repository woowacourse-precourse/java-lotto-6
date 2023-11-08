package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.constant.ExceptionMessage;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.UNVALID_LENGTH.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.IS_DUPLICATED.getMessage());
    }

    @DisplayName("로또 번호에 음수가 있으면 예외가 발생한다.")
    @Test
    void createLottoByNegativeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(-1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.WRONG_TYPE.getMessage());
    }

    @DisplayName("로또 번호에 정수가 아닌 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByNonIntegerNumber() {
        assertThatThrownBy(() -> new Lotto("1.1,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.WRONG_TYPE.getMessage());
    }

    @DisplayName("로또 번호에 범위 밖 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOutRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(100, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.OUT_OF_RANGE.getMessage());
    }

    @DisplayName("로또 번호에 숫자가 아닌 문자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByNonNumber() {
        assertThatThrownBy(() -> new Lotto("d,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.WRONG_TYPE.getMessage());
    }

    @DisplayName("로또 번호에 공백이 있으면 예외가 발생한다.")
    @Test
    void createLottoByBlank() {
        assertThatThrownBy(() -> new Lotto("1, ,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.HAS_BLANK.getMessage());
    }
}