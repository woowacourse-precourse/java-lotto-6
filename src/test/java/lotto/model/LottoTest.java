package lotto.model;

import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.enums.ErrorMessage;
import lotto.model.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {

    @DisplayName("로또 번호가 잘 생성되는지 확인한다.")
    @Test
    void createBasicLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));;
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessage.INVALID_NUMBERS_COUNT_ERROR.getMessage());
    }

    @DisplayName("로또 번호의 개수가 6개보다 작으면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
            .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessage.INVALID_NUMBERS_COUNT_ERROR.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessage.DUPLICATE_NUMBER_ERROR.getMessage());
    }

    @DisplayName("로또 번호가 1부터 45 사이가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({
        "1, 2, 3, 4, 5, 0",
        "1, 2, 3, 4, 5, 100",
        "1, 2, 3, 4, 5 ,-6"
    })
    void createExceedRangeNumber(int num1, int num2, int num3, int num4, int num5, int num6) {
        // given
        List<Integer> numbers = List.of(num1, num2, num3, num4, num5, num6);
        // when, then
        assertThatThrownBy(() -> new Lotto(numbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.EXCEED_LOTTO_RANGE_ERROR.getMessage());
    }

    @DisplayName("로또 번호가 양식에 맞게 출력되는지 확인한다.")
    @Test
    void lottoNumberFormatTest() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        String expectedFormat = "[1, 2, 3, 4, 5, 6]";
        String actualFormat = lotto.toString();

        // then
        assertEquals(expectedFormat, actualFormat);
    }
}