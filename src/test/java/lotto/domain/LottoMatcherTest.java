package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LottoMatcherTest {

    @DisplayName("로또 번호 하나와 당첨 번호 간 일치하는 번호의 갯수가 0개인지 검증한다.")
    @Test
    void calculateOneCorrectWinning() {
        //given
        Lotto userNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningNumbers = new Lotto(List.of(7, 8, 9, 10, 11, 12));

        //when
        LottoMatcher lottoMatcher = new LottoMatcher(userNumbers, winningNumbers);
        long allCorrectCount = lottoMatcher.getCorrectWinningCount();

        //then
        Assertions.assertThat(allCorrectCount).isEqualTo(0);
    }

    @DisplayName("로또 번호 하나와 당첨 번호 간 일치하는 번호의 갯수가 1개인지 검증한다.")
    @Test
    void calculateTwoCorrectWinning() {
        //given
        Lotto userNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningNumbers = new Lotto(List.of(1, 7, 8, 9, 10, 11));

        //when
        LottoMatcher lottoMatcher = new LottoMatcher(userNumbers, winningNumbers);
        long allCorrectCount = lottoMatcher.getCorrectWinningCount();

        //then
        Assertions.assertThat(allCorrectCount).isEqualTo(1);
    }

    @DisplayName("로또 번호 하나와 당첨 번호 간 일치하는 번호의 갯수가 2개인지 검증한다.")
    @Test
    void calculateThreeCorrectWinning() {
        //given
        Lotto userNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningNumbers = new Lotto(List.of(1, 2, 7, 8, 9, 10));

        //when
        LottoMatcher lottoMatcher = new LottoMatcher(userNumbers, winningNumbers);
        long allCorrectCount = lottoMatcher.getCorrectWinningCount();

        //then
        Assertions.assertThat(allCorrectCount).isEqualTo(2);
    }

    @DisplayName("로또 번호 하나와 당첨 번호 간 일치하는 번호의 갯수가 3개인지 검증한다.")
    @Test
    void calculateFourCorrectWinning() {
        //given
        Lotto userNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 7, 8, 9));

        //when
        LottoMatcher lottoMatcher = new LottoMatcher(userNumbers, winningNumbers);
        long allCorrectCount = lottoMatcher.getCorrectWinningCount();

        //then
        Assertions.assertThat(allCorrectCount).isEqualTo(3);
    }

    @DisplayName("로또 번호 하나와 당첨 번호 간 일치하는 번호의 갯수가 4개인지 검증한다.")
    @Test
    void calculateFiveCorrectWinning() {
        //given
        Lotto userNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 7, 8));

        //when
        LottoMatcher lottoMatcher = new LottoMatcher(userNumbers, winningNumbers);
        long allCorrectCount = lottoMatcher.getCorrectWinningCount();

        //then
        Assertions.assertThat(allCorrectCount).isEqualTo(4);
    }

    @DisplayName("로또 번호 하나와 당첨 번호 간 일치하는 번호의 갯수가 5개인지 검증한다.")
    @Test
    void calculateSixCorrectWinning() {
        //given
        Lotto userNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        //when
        LottoMatcher lottoMatcher = new LottoMatcher(userNumbers, winningNumbers);
        long allCorrectCount = lottoMatcher.getCorrectWinningCount();

        //then
        Assertions.assertThat(allCorrectCount).isEqualTo(5);
    }

    @DisplayName("로또 번호 하나와 보너스 번호를 포함한 당첨 번호 간 일치하는 번호의 갯수가 0개인지 검증한다.")
    @Test
    void calculateNotAllCorrectWinning() {
        //given
        Lotto userNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningNumbers = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        int bonusNumber = 6;

        //when
        LottoMatcher lottoMatcher = new LottoMatcher(userNumbers, winningNumbers, bonusNumber);
        long allCorrectCount = lottoMatcher.getAllCorrectCount();

        //then
        Assertions.assertThat(allCorrectCount).isEqualTo(1);
    }

    @DisplayName("로또 번호 하나와 보너스 번호를 포함한 당첨 번호 간 일치하는 번호의 갯수가 1개인지 검증한다.")
    @Test
    void calculateAllCorrectWinning() {
        //given
        Lotto userNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningNumbers = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        int bonusNumber = 13;

        //when
        LottoMatcher lottoMatcher = new LottoMatcher(userNumbers, winningNumbers, bonusNumber);
        long allCorrectCount = lottoMatcher.getAllCorrectCount();

        //then
        Assertions.assertThat(allCorrectCount).isEqualTo(0);
    }

    @DisplayName("로또 번호 하나와 보너스 번호를 포함한 당첨 번호 간 일치하는 번호의 갯수가 2개인지 검증한다.")
    @Test
    void calculateAllCorrectWinningWithBonusNumber() {
        //given
        Lotto userNumbers = new Lotto(List.of(1, 2, 3, 4, 7, 13));
        Lotto winningNumbers = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        int bonusNumber = 13;

        //when
        LottoMatcher lottoMatcher = new LottoMatcher(userNumbers, winningNumbers, bonusNumber);
        long allCorrectCount = lottoMatcher.getAllCorrectCount();
        boolean correctBonus = lottoMatcher.isCorrectBonus();

        //then
        Assertions.assertThat(allCorrectCount).isEqualTo(2);
        Assertions.assertThat(correctBonus).isEqualTo(true);
    }

    @DisplayName("로또 번호 하나와 보너스 번호를 포함한 당첨 번호 간 일치하는 번호의 갯수가 1개인지 검증한다.")
    @Test
    void calculateAllCorrectWinningByUser() {
        //given
        List<Lotto> userNumbers = new ArrayList<>();
        Lotto firstUserNumber = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto secondUserNumber = new Lotto(List.of(1, 2, 3, 4, 7, 13));
        userNumbers.add(firstUserNumber);
        userNumbers.add(secondUserNumber);

        Lotto winningNumbers = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        int bonusNumber = 13;

        //when
        LottoMatcher lottoMatcher = new LottoMatcher(userNumbers, winningNumbers, bonusNumber);
        List<Long> correctWinningsCount = lottoMatcher.getCorrectWinningsCount();
        List<Boolean> correctBonuses = lottoMatcher.getCorrectBonuses();

        //then
        Assertions.assertThat(correctWinningsCount.get(0)).isEqualTo(1);
        Assertions.assertThat(correctWinningsCount.get(1)).isEqualTo(2);
        Assertions.assertThat(correctBonuses.get(0)).isEqualTo(false);
        Assertions.assertThat(correctBonuses.get(1)).isEqualTo(true);
    }

}
