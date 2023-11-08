package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @Test
    @DisplayName("입력 받은 숫자중 범위가 넘어간 숫자가 있으면 예외를 던지는가")
    void is_out_of_number_range() {
        //given
        final List<Integer> inputs = Arrays.asList(0, 46, 47, 48, 49, 50);

        //when & then
        AssertionsForClassTypes.assertThatThrownBy(() -> new Lotto(inputs))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정상적으로 입력을 받으면 예외를 던지지 않는가")
    void no_exception() {
        //given
        final List<Integer> inputs = Arrays.asList(1, 2, 3, 4, 5, 6);

        //when & then
        assertThatNoException().isThrownBy(() -> new Lotto(inputs));
    }
}