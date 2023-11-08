package lotto.domain;

import lotto.domain.Lotto;
import lotto.domain.LottoMatch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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

    @DisplayName("당첨 번호와 같은 숫자가 2개 이하일 때 NON_PLACE를 반환한다.")
    @Test
    void compareWinningNumbersTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(1, 20, 21, 23, 22, 33);
        int bonusNumber = 40;

        LottoMatch lottoMatch = lotto.compareWinningNumbers(winningNumbers, bonusNumber);

        assertThat(lottoMatch).isEqualTo(LottoMatch.NON_PLACE);
    }

    @DisplayName("당첨 번호와 같은 숫자가 3개일 때 FIFTH_PLACE를 반환한다.")
    @Test
    void compareWinningNumbersTest2() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(1, 20, 3, 23, 4, 33);
        int bonusNumber = 40;

        LottoMatch lottoMatch = lotto.compareWinningNumbers(winningNumbers, bonusNumber);

        assertThat(lottoMatch).isEqualTo(LottoMatch.FIFTH_PLACE);
    }

    @DisplayName("보너스 번호를 포함하지 않고 당첨 번호와 같은 숫자가 5개일 때 THIRD_PLACE를 반환한다.")
    @Test
    void compareWinningNumbersTest3() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(1, 2, 3, 5, 4, 33);
        int bonusNumber = 40;

        LottoMatch lottoMatch = lotto.compareWinningNumbers(winningNumbers, bonusNumber);

        assertThat(lottoMatch).isEqualTo(LottoMatch.THIRD_PLACE);
    }

    @DisplayName("보너스 번호를 포함해서 당첨 번호와 같은 숫자가 5개일 때 SECOND_PLACE를 반환한다.")
    @Test
    void compareWinningNumbersTest4() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(1, 2, 3, 21, 4, 33);
        int bonusNumber = 5;

        LottoMatch lottoMatch = lotto.compareWinningNumbers(winningNumbers, bonusNumber);

        assertThat(lottoMatch).isEqualTo(LottoMatch.SECOND_PLACE);
    }
}