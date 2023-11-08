package lotto.domain;

import static lotto.exception.Message.NUMBER_OUT_OF_RANGE_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest
    @DisplayName("로또의 각 숫자들이 1에서 45 사이의 숫자인지 확인한다.")
    @CsvSource(value = {
            "1, 4, 16, 14, 19, 46",
            "0, 1, 16, 14, 19, 45"
    })
    void valid_lotto_number(int first, int second, int third, int fourth, int fifth, int sixth) {

        // when  // then
        assertThatThrownBy(() -> new Lotto(Arrays.asList(first, second, third, fourth, fifth, sixth)))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(NUMBER_OUT_OF_RANGE_EXCEPTION);
    }
}