package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("로또 번호에 범위를 벗어나는 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 50)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 잘못된 쉼표 사용 시 예외가 발생한다.")
    @Test
    void createLottoByIncorrectDelimiter() {
        String input = "1,,2,3,4,5,6";

        assertThatThrownBy(() -> new Lotto(Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList())))
                .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("로또 번호에 문자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByString() {
        String input = "1,2,3,4,5,a";

        assertThatThrownBy(() -> new Lotto(Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList())))
                .isInstanceOf(NumberFormatException.class);
    }
}