package lotto;

import lotto.lottocompany.Lotto;
import lotto.lottocompany.Reward;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.lottocompany.Reward.*;
import static org.assertj.core.api.Assertions.*;
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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 1~45의 숫자가 아닌 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46, 99})
    void createLottoByNotLottoNumber(int lottoNumber) {
        //given
        List<Integer> lottoNumbers = List.of(lottoNumber, 1, 2, 3, 4, 5);
        // when //then
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또의 당첨을 확인한다.(1등)")
    @Test
    void checkFirstWinning() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 10;

        //when
        Reward reward = lotto.checkWinning(winningNumbers, bonusNumber);

        //then
        assertThat(reward).isEqualTo(FIRST);
    }

    @DisplayName("로또의 당첨을 확인한다.(2등)")
    @Test
    void checkSecondWinning() {
        //given
        int bonusNumber = 6;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, bonusNumber));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 7);

        //when
        Reward reward = lotto.checkWinning(winningNumbers, bonusNumber);

        //then
        assertThat(reward).isEqualTo(SECOND);
    }

    @DisplayName("로또의 당첨을 확인한다.(3등)")
    @Test
    void checkThirdWinning() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 10;

        //when
        Reward reward = lotto.checkWinning(winningNumbers, bonusNumber);

        //then
        assertThat(reward).isEqualTo(THIRD);
    }

    @DisplayName("로또의 당첨을 확인한다.(4등)")
    @Test
    void checkFourthWinning() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 8, 7));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 10;

        //when
        Reward reward = lotto.checkWinning(winningNumbers, bonusNumber);

        //then
        assertThat(reward).isEqualTo(FOURTH);
    }

    @DisplayName("로또의 당첨을 확인한다.(5등)")
    @Test
    void checkFifthWinning() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 9, 8, 7));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 10;

        //when
        Reward reward = lotto.checkWinning(winningNumbers, bonusNumber);

        //then
        assertThat(reward).isEqualTo(FIFTH);
    }
}
