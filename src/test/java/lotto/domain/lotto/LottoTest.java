package lotto.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

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

    @DisplayName("로또 번호 정상")
    @Test
    void createLotto() {
        assertDoesNotThrow(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("번호 일치 개수 비교")
    @Test
    void match() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //when
        Lotto other = new Lotto(List.of(4, 5, 6, 7, 8, 9));
        int matchCount = lotto.match(other);

        //then
        assertThat(matchCount).isEqualTo(3);
    }

    @DisplayName("보너스 번호 포함 여부")
    @Test
    void hasBonus() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //when
        int number1 = 1;
        boolean hasBonus1 = lotto.hasBonus(number1);
        int number2 = 7;
        boolean hasBonus2 = lotto.hasBonus(number2);

        //then
        assertThat(hasBonus1).isEqualTo(true);
        assertThat(hasBonus2).isEqualTo(false);
    }
}