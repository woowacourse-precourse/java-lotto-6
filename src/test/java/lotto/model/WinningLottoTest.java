package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.constant.LottoGrade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    //Error case
    @Test
    @DisplayName("보너스의 번호가 45를 넘어가면 에러 발생")
    void createWinningLottoByOverBonusNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6)).setBonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스의 번호가 로또번호랑 중복되면 에러")
    void createWinningLottoByDuplicatedBonusNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6)).setBonusNumber(5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 46보다 크면 예외가 발생한다.")
    @Test
    void createLottoByOverNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1보다 작으면 예외가 발생한다.")
    @Test
    void createLottoByUnderNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // Normal case
    @DisplayName("Grade 별 반환")
    @Test
    void determineLottoGradeTest() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
        winningLotto.setBonusNumber(7);

        Lotto lottoSixMatch = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(winningLotto.determineLottoGrade(lottoSixMatch))
                .isEqualTo(LottoGrade.SIX_MATCH);

        Lotto lottoFiveAndBonusMatch = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        assertThat(winningLotto.determineLottoGrade(lottoFiveAndBonusMatch))
                .isEqualTo(LottoGrade.FIVE_AND_BONUS_MATCH);

        Lotto lottoFiveMatch = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        assertThat(winningLotto.determineLottoGrade(lottoFiveMatch))
                .isEqualTo(LottoGrade.FIVE_MATCH);

        Lotto lottoFourMatch = new Lotto(List.of(1, 2, 3, 4, 9, 10));
        assertThat(winningLotto.determineLottoGrade(lottoFourMatch))
                .isEqualTo(LottoGrade.FOUR_MATCH);

        Lotto lottoThreeMatch = new Lotto(List.of(1, 2, 3, 10, 11, 12));
        assertThat(winningLotto.determineLottoGrade(lottoThreeMatch))
                .isEqualTo(LottoGrade.THREE_MATCH);

        Lotto lottoNoGrade = new Lotto(List.of(1, 2, 7, 10, 11, 12));
        assertThat(winningLotto.determineLottoGrade(lottoNoGrade))
                .isEqualTo(LottoGrade.NO_GRADE);

    }
}
