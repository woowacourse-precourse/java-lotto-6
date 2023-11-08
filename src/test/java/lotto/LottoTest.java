package lotto;

import lotto.domain.Lotto;
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

    @DisplayName("로또 6자리를 입력하지 않으면 예외가 발생한다.")
    @Test
    void createLottoBySizeIsSix() {
        assertThatThrownBy(() -> new Lotto(List.of(1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또의 범위가 1~45를 벗어나면 예외가 발생한다..")
    @Test
    void createLottoByRangeOneToFortyFive() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 49, 50)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 숫자가 아닌 문자를 입력하면 예외가 발생한다.")
    @Test
    void createLottoByNotDigit() {
        String input = "1, 2, 3, a, a, 6";

        assertThatThrownBy(() -> {
            List<Integer> numbers = Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            new Lotto(numbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}