package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoWinningCheckerTest {

    private LottoWinningChecker checker;

    @BeforeEach
    void createLottoChecker() {
        checker = new LottoWinningChecker(List.of(1, 2, 3, 4, 5, 6), 7);
    }
    @DisplayName("당첨 번호와 보너스 번호가 중복인 경우")
    @Test
    void createLottoWinningCheckerByDuplicateBonusNumber(){
        assertThatThrownBy(() -> new LottoWinningChecker(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("당첨 번호 중복인 경우")
    @Test
    void createLottoWinningCheckerByDuplicateNumber(){
        assertThatThrownBy(() -> new LottoWinningChecker(List.of(1, 2, 3, 4, 5, 5), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("당첨 번호 갯수 6개 아닐 때")
    @Test
    void createLottoWinningCheckerByOverSize() {
        assertThatThrownBy(() -> new LottoWinningChecker(List.of(1, 2, 3, 4, 5), 7))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new LottoWinningChecker(List.of(1, 2, 3, 4, 5, 6, 8), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1등 로또 확인")
    @Test
    void createFirstPrizeLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(checker.check(lotto)).isEqualTo(LottoResult.FIRST_PRIZE);
    }

    @DisplayName("2등 로또 확인")
    @Test
    void createSecondPrizeLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        assertThat(checker.check(lotto)).isEqualTo(LottoResult.SECOND_PRIZE);
    }

    @DisplayName("3등 로또 확인")
    @Test
    void createThirdPrizeLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        assertThat(checker.check(lotto)).isEqualTo(LottoResult.THIRD_PRIZE);
    }

    @DisplayName("4등 로또 확인")
    @Test
    void createFourthPrizeLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 9, 8));
        assertThat(checker.check(lotto)).isEqualTo(LottoResult.FOURTH_PRIZE);
    }

    @DisplayName("5등 로또 확인")
    @Test
    void createFifthPrizeLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 7, 9, 8));
        assertThat(checker.check(lotto)).isEqualTo(LottoResult.FIFTH_PRIZE);
    }

    @DisplayName("미당첨 로또 확인")
    @Test
    void createNothingLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 10, 7, 9, 8));
        assertThat(checker.check(lotto)).isEqualTo(LottoResult.NOTING);
    }
}
