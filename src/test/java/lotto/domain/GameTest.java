package lotto.domain;

import static lotto.domain.Constraints.MAX;
import static lotto.domain.Constraints.MIN;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {

    Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
        game.setWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        game.setBonusNumber(7);
    }

    @DisplayName("당첨 번호에 최소값보다 작은 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumbersByLessThanMinimum() {
        assertThatThrownBy(() -> game.setWinningNumbers(List.of(1, 2, 3, 4, 5, MIN - 1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 최대값보다 큰 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumbersByLessThanMax() {
        assertThatThrownBy(() -> game.setWinningNumbers(List.of(1, 2, 3, 4, 5, MAX + 1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 값이 있으면 예외가 발생한다.")
    @Test
    void createWinningNumbersByDuplicatedNumber() {
        assertThatThrownBy(() -> game.setWinningNumbers(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 최소값보다 작으면 예외가 발생한다.")
    @Test
    void createBonusNumberByLessThanMinimum() {
        assertThatThrownBy(() -> game.setBonusNumber(MIN - 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 최대값보다 크면 예외가 발생한다.")
    @Test
    void createBonusNumberByGreaterThanMax() {
        assertThatThrownBy(() -> game.setBonusNumber(MAX + 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void createBonusNumberByDuplicatedNumber() {
        assertThatThrownBy(() -> game.setBonusNumber(1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 6개 번호가 일치하면 1등")
    @Test
    void updateLottoStatusByFirstPrize() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        game.addLotto(lotto);
        assertThat(game.calculate()).isEqualTo(Map.of(ResultCode.FIRST, 1));
    }

    @DisplayName("당첨 번호와 5개 번호가 일치하고, 보너스 번호가 일치하면 2등")
    @Test
    void updateLottoStatusBySecondPrize() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        game.addLotto(lotto);
        assertThat(game.calculate()).isEqualTo(Map.of(ResultCode.SECOND, 1));
    }

    @DisplayName("당첨 번호와 5개 번호가 일치하면 3등")
    @Test
    void updateLottoStatusByThirdPrize() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        game.addLotto(lotto);
        assertThat(game.calculate()).isEqualTo(Map.of(ResultCode.THIRD, 1));
    }

    @DisplayName("당첨 번호와 4개 번호가 일치하면 4등")
    @Test
    void updateLottoStatusByFourthPrize() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 8, 9));
        game.addLotto(lotto);
        assertThat(game.calculate()).isEqualTo(Map.of(ResultCode.FOURTH, 1));
    }

    @DisplayName("당첨 번호와 3개 번호가 일치하면 5등")
    @Test
    void updateLottoStatusByFifthPrize() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));
        game.addLotto(lotto);
        assertThat(game.calculate()).isEqualTo(Map.of(ResultCode.FIFTH, 1));
    }

    @DisplayName("당첨 번호와 2개 번호가 일치하면 해당 사항 없음")
    @Test
    void updateLottoStatusByNonePrize() {
        Lotto lotto = new Lotto(List.of(1, 2, 8, 9, 10, 11));
        game.addLotto(lotto);
        assertThat(game.calculate()).isEqualTo(Map.of());
    }

    @DisplayName("수익률 계산 테스트 - 3개 일치, 62.5%의 수익률")
    @Test
    void calculateProfitability() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));
        game.addLotto(lotto);
        assertThat(game.calculateProfitability(game.calculate(), 8000)).isEqualTo(62.5);
    }
}