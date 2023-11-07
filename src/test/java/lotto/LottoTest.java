package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.vo.BonusNumber;
import lotto.vo.WinningNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        Assertions.assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        Assertions.assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 번호의 개수가 6개 미만이면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        Assertions.assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRangeNumber() {
        Assertions.assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유효한 로또 번호 리스트가 주어지면 Lotto 객체가 생성된다.")
    @Test
    void createLottoByValidNumbers() {
        Assertions.assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6))).isInstanceOf(Lotto.class);
    }

    @DisplayName("일치하는 번호가 없을 경우 Rank.NONE을 반환한다.")
    @Test
    void matchRankWithNoMatches() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = WinningNumbers.from(List.of(7, 8, 9, 10, 11, 12));
        BonusNumber bonusNumber = BonusNumber.from(13);

        Assertions.assertThat(lotto.matchRank(winningNumbers, bonusNumber)).isEqualTo(Rank.NONE);
    }

    @DisplayName("일치하는 번호가 3개일 경우 Rank.FIFTH를 반환한다.")
    @Test
    void matchRankWithThreeMatches() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 10, 11, 12));
        WinningNumbers winningNumbers = WinningNumbers.from(List.of(1, 2, 3, 7, 8, 9));
        BonusNumber bonusNumber = BonusNumber.from(45);

        Assertions.assertThat(lotto.matchRank(winningNumbers, bonusNumber)).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("일치하는 번호가 4개일 경우 Rank.FOURTH를 반환한다.")
    @Test
    void matchRankWithFourMatches() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 11, 12));
        WinningNumbers winningNumbers = WinningNumbers.from(List.of(1, 2, 3, 4, 8, 9));
        BonusNumber bonusNumber = BonusNumber.from(13);

        Assertions.assertThat(lotto.matchRank(winningNumbers, bonusNumber)).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("일치하는 번호가 5개일 경우 Rank.THIRD를 반환한다.")
    @Test
    void matchRankWithFiveMatches() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 12));
        WinningNumbers winningNumbers = WinningNumbers.from(List.of(1, 2, 3, 4, 5, 9));
        BonusNumber bonusNumber = BonusNumber.from(13);

        Assertions.assertThat(lotto.matchRank(winningNumbers, bonusNumber)).isEqualTo(Rank.THIRD);
    }

    @DisplayName("일치하는 번호가 5개이고 보너스 번호도 일치할 경우 Rank.SECOND를 반환한다.")
    @Test
    void matchRankWithFiveMatchesAndBonus() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 12));
        WinningNumbers winningNumbers = WinningNumbers.from(List.of(1, 2, 3, 4, 5, 9));
        BonusNumber bonusNumber = BonusNumber.from(12);

        Assertions.assertThat(lotto.matchRank(winningNumbers, bonusNumber)).isEqualTo(Rank.SECOND);
    }

    @DisplayName("일치하는 번호가 6개일 경우 Rank.FIRST를 반환한다.")
    @Test
    void matchRankWithSixMatches() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = WinningNumbers.from(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = BonusNumber.from(12);

        Assertions.assertThat(lotto.matchRank(winningNumbers, bonusNumber)).isEqualTo(Rank.FIRST);
    }
}
