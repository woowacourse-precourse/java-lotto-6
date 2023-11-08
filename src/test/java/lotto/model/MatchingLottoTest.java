package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MatchingLottoTest {

    @Test
    @DisplayName("일치하는 로또게임이 없을 경우 수익률은 0을 리턴")
    void calculateLottoReturnRateReturnZero() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(10, 11, 12, 13, 14, 15)),
                new Lotto(List.of(16, 17, 18, 19, 20, 12)));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        MatchingLotto matchingLotto = new MatchingLotto(lottos, winningNumbers, bonusNumber);

        double returnRate = matchingLotto.calculateLottoReturnRate();

        assertThat(returnRate).isZero();
    }

    @Test
    @DisplayName("로또 당첨금에 따른 올바른 수익률 리턴")
    void correctLottoReturnRate() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 10, 11, 12)),
                new Lotto(List.of(10, 11, 12, 13, 14, 15)),
                new Lotto(List.of(10, 11, 12, 13, 14, 15)),
                new Lotto(List.of(10, 11, 12, 13, 14, 15)),
                new Lotto(List.of(10, 11, 12, 13, 14, 15)));

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        MatchingLotto matchingLotto = new MatchingLotto(lottos, winningNumbers, bonusNumber);

        double returnRate = matchingLotto.calculateLottoReturnRate();

        assertThat(returnRate).isEqualTo(100.0);
    }

    @Test
    @DisplayName("일치하는 로또 번호 개수 구하기")
    void countMatchesIsCorrect() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 7, 8, 9)),
                new Lotto(List.of(1, 2, 3, 8, 9, 10)),
                new Lotto(List.of(1, 2, 3, 9, 10, 11)));

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        MatchingLotto matchingLotto = new MatchingLotto(lottos, winningNumbers, bonusNumber);

        assertThat(matchingLotto.getMatchedThree()).isEqualTo(3);
        assertThat(matchingLotto.getMatchedFour()).isEqualTo(0);
        assertThat(matchingLotto.getMatchedFive()).isEqualTo(1);
        assertThat(matchingLotto.getMatchedBonus()).isEqualTo(1);
        assertThat(matchingLotto.getMatchedSix()).isEqualTo(1);
    }
}