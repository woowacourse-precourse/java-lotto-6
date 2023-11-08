package lotto.Domain;

import lotto.Domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    private final List<Integer> validNumber = List.of(1, 2, 3, 4, 5, 6);
    private final List<Integer> invalidNumber1 = List.of(1, 2, 3, 4, 5, 5);
    private final List<Integer> invalidNumber2 = List.of(1, 2, 3, 4, 5);
    private final List<Integer> invalidNumber3 = List.of(1, 2, 3, 4, 5, 6, 7);

    @DisplayName("로또 번호의 개수가 6개가 아니면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> Lotto.from(invalidNumber2))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Lotto.from(invalidNumber3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> Lotto.from(invalidNumber1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상수행시나리오")
    @Test
    void createLottoBySize() {
        //given

        //when
        Lotto lotto = Lotto.from(validNumber);

        //then
        assertThat(lotto).isNotNull();
    }
}