package lotto.domain;

import lotto.domain.enums.LottoPrize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.Numbers.createNumbersList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Lotto 클래스")
class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(createNumbersList(List.of(1, 2, 3, 4, 5, 6, 7))))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(createNumbersList(List.of(1, 2, 3, 4, 5, 5))))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 null 이라면 예외가 발생한다.")
    @Test
    void createLottoByNull() {
        assertThatThrownBy(() -> new Lotto(null))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호와 당첨 번호를 비교하여 당첨 여부를 판단한다.")
    @Test
    void compareLottoNumbersToWinningNumbers() {
        Lotto lotto = new Lotto(Numbers.createNumbersList(List.of(1, 2, 3, 4, 5, 6)));
        WinningLotto winningLotto = new WinningLotto(
            Numbers.createNumbersList(List.of(1, 2, 3, 4, 5, 6)), new Number(7));

        assertThat(lotto.matches(winningLotto)).isEqualTo(LottoPrize.FIRST);
    }
}