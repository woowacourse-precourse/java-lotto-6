package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoWinningNumbersTest {

    @DisplayName("로또의 당첨 번호 개수를 셀 수 있다.")
    @Test
    void calculateWinningNumberCount() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoWinningNumbers winningNumbers = LottoWinningNumbers.of(List.of(1, 2, 3, 4, 5, 6), 7);

        // when
        int result = winningNumbers.calculateWinningNumberCount(lotto);

        // then
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("보너스 번호가 일치할 경우 보너스 번호 확인 결과는 true 이다..")
    @Test
    void matchesBonusNumber_true() {
        // given
        int bonusNumber = 7;

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, bonusNumber));
        LottoWinningNumbers winningNumbers = LottoWinningNumbers.of(List.of(1, 2, 3, 4, 5, 6), bonusNumber);

        // when
        boolean result = winningNumbers.matchesBonusNumber(lotto);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("보너스 번호가 일치하지 않을 경우 보너스 번호 확인 결과는 false 이다.")
    @Test
    void matchesBonusNumber_false() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        int bonusNumber = 7;
        LottoWinningNumbers winningNumbers = LottoWinningNumbers.of(List.of(1, 2, 3, 4, 5, 6), bonusNumber);

        // when
        boolean result = winningNumbers.matchesBonusNumber(lotto);

        // then
        assertThat(result).isFalse();
    }

}