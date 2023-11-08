package lotto.model.lotto;

import static lotto.exception.ExceptionMessage.LOTTO_NUMBER_OUT_OF_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 범위를 벗어나면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0,1,2,3,4,5", "1,2,3,4,5,46"})
    void creatLottoByNumberOutOfRange(String numbers) {
        // when
        List<Integer> numberList = Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .toList();

        // given, then
        assertThatThrownBy(() -> new Lotto(numberList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
    }
}