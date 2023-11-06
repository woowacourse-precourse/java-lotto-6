package lotto;

import static lotto.domain.enums.ErrorMessage.DUPLICATE_NUMBER_ERROR_MESSAGE;
import static lotto.domain.enums.ErrorMessage.EXCEED_LENGTH_ERROR_MESSAGE;
import static lotto.domain.enums.ErrorMessage.NUMBER_OUT_OF_RANGE_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EXCEED_LENGTH_ERROR_MESSAGE.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_NUMBER_ERROR_MESSAGE.getMessage());
    }

    @DisplayName("로또 번호는 중복 없는 6개의 숫자로 생성한다.")
    @Test
    void createLotto() {
        assertDoesNotThrow(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("로또 번호가 범위를 벗어나면 에러가 발생한다.")
    @Test
    void createLottoByOutOfRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NUMBER_OUT_OF_RANGE_ERROR_MESSAGE.getMessage());
    }

    @DisplayName("로또 번호가 포함한 숫자가 있는 경우 참을 반환한다.")
    @Test
    void containsNumberTest() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int number = 1;

        //when and then
        assertTrue(lotto.isContainNumber(number));
    }

    @DisplayName("두 개의 로또 번호가 일치한 개수를 반환한다.")
    @Test
    void matchLottoCountTest() {
        //given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(4, 5, 6, 10, 11, 1));
        int expectedCount = 4;

        //when
        int matchCount = lotto1.match(lotto2);

        //then
        assertThat(matchCount).isEqualTo(expectedCount);
    }
}