package lotto.domain;

import lotto.domain.constant.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    @DisplayName("Lotto 생성 테스트")
    void createLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getNumbers()).
                containsAll(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("로또 번호가 6개 미만일 경우 예외처리")
    void validateLottoUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호가 6개 초과일 경우 예외처리")
    void validateLottoOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("로또 번호가 중복되었을 경우 예외처리")
    void validateDuplicate() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호가 1 미만일 경우 예외처리")
    void validateUnderRangeLotto() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호가 45 초과일 경우 예외처리")
    void validateOverRangeLotto() {
        assertThatThrownBy(() -> new Lotto(List.of(46, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또의 Rank 가져오기 테스트")
    void getRankFromLotto() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Rank rank = lotto.getRank(winningNumbers);
        assertThat(rank).isEqualTo(Rank.FIRST_RANK);

        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        rank = lotto.getRank(winningNumbers);
        assertThat(rank).isEqualTo(Rank.SECOND_RANK);

        lotto = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        rank = lotto.getRank(winningNumbers);
        assertThat(rank).isEqualTo(Rank.NOTHING);

    }
}