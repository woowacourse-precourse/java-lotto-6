package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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

    @DisplayName("6개의 숫자가 일치하면 1등상을 탄다.")
    @Test
    void getFirstWinning() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Winning winning = lotto.getWinning(List.of(1, 2, 3, 4, 5, 6), 1);
        assertThat(winning).isEqualTo(Winning.FIRST);
    }

    @DisplayName("5개의 숫자가 일치하고, 보너스 숫자가 맞으면 2등상을 탄다.")
    @Test
    void getSecondWinning() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Winning winning = lotto.getWinning(List.of(1, 2, 3, 4, 5, 9), 6);
        assertThat(winning).isEqualTo(Winning.SECOND);
    }

    @DisplayName("5개의 숫자가 일치하고, 보너스 숫자가 맞지 않으면 3등상을 탄다.")
    @Test
    void getThirdWinning() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Winning winning = lotto.getWinning(List.of(1, 2, 3, 4, 5, 9), 8);
        assertThat(winning).isEqualTo(Winning.THIRD);
    }

    @DisplayName("4개의 숫자가 일치하면 4등상을 탄다.")
    @Test
    void getFourthWinning() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Winning winning = lotto.getWinning(List.of(1, 2, 3, 4, 7, 8), 1);
        assertThat(winning).isEqualTo(Winning.FOURTH);
    }

    @DisplayName("3개의 숫자가 일치하면 5등상을 탄다.")
    @Test
    void getFifthWinning() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Winning winning = lotto.getWinning(List.of(9, 2, 3, 7, 8, 1), 1);
        assertThat(winning).isEqualTo(Winning.FIFTH);
    }

    @DisplayName("2개 이하 숫자가 일치하면 상을 타지 못한다.")
    @Test
    void getWinningFail() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Winning winning = lotto.getWinning(List.of(9, 8, 7, 11, 5, 6), 1);
        assertThat(winning).isEqualTo(Winning.FAIL);
    }

}