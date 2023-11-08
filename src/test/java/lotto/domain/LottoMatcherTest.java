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
        List<Integer> userNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(7, 8, 9, 10, 11, 12);

        //when
        LottoMatcher lottoMatcher = new LottoMatcher();
        long allCorrectCount = lottoMatcher.calculateCorrectWinning(userNumbers, winningNumbers);

        //then
        Assertions.assertThat(allCorrectCount).isEqualTo(0);
    }

    @DisplayName("로또 번호 하나와 당첨 번호 간 일치하는 번호의 갯수가 1개인지 검증한다.")
    @Test
    void calculateTwoCorrectWinning() {
        //given
        List<Integer> userNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(1, 7, 8, 9, 10, 11);

        //when
        LottoMatcher lottoMatcher = new LottoMatcher();
        long allCorrectCount = lottoMatcher.calculateCorrectWinning(userNumbers, winningNumbers);

        //then
        Assertions.assertThat(allCorrectCount).isEqualTo(1);
    }

    @DisplayName("로또 번호 하나와 당첨 번호 간 일치하는 번호의 갯수가 2개인지 검증한다.")
    @Test
    void calculateThreeCorrectWinning() {
        //given
        List<Integer> userNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(1, 2, 7, 8, 9, 10);

        //when
        LottoMatcher lottoMatcher = new LottoMatcher();
        long allCorrectCount = lottoMatcher.calculateCorrectWinning(userNumbers, winningNumbers);

        //then
        Assertions.assertThat(allCorrectCount).isEqualTo(2);
    }

    @DisplayName("로또 번호 하나와 당첨 번호 간 일치하는 번호의 갯수가 3개인지 검증한다.")
    @Test
    void calculateFourCorrectWinning() {
        //given
        List<Integer> userNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(1, 2, 3, 7, 8, 9);

        //when
        LottoMatcher lottoMatcher = new LottoMatcher();
        long allCorrectCount = lottoMatcher.calculateCorrectWinning(userNumbers, winningNumbers);

        //then
        Assertions.assertThat(allCorrectCount).isEqualTo(3);
    }

    @DisplayName("로또 번호 하나와 당첨 번호 간 일치하는 번호의 갯수가 4개인지 검증한다.")
    @Test
    void calculateFiveCorrectWinning() {
        //given
        List<Integer> userNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 7, 8);

        //when
        LottoMatcher lottoMatcher = new LottoMatcher();
        long allCorrectCount = lottoMatcher.calculateCorrectWinning(userNumbers, winningNumbers);

        //then
        Assertions.assertThat(allCorrectCount).isEqualTo(4);
    }

    @DisplayName("로또 번호 하나와 당첨 번호 간 일치하는 번호의 갯수가 5개인지 검증한다.")
    @Test
    void calculateSixCorrectWinning() {
        //given
        List<Integer> userNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 7);

        //when
        LottoMatcher lottoMatcher = new LottoMatcher();
        long allCorrectCount = lottoMatcher.calculateCorrectWinning(userNumbers, winningNumbers);

        //then
        Assertions.assertThat(allCorrectCount).isEqualTo(5);
    }

    @DisplayName("로또 번호 하나와 당첨 번호 1개 일치지만, 보너스 번호 0개 일치를 검증한다.")
    @Test
    void calculateNotAllCorrectWinning() {
        //given
        List<Integer> userNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(7, 8, 9, 10, 11, 12);
        int bonusNumber = 6;

        //when
        LottoMatcher lottoMatcher = new LottoMatcher();
        long allCorrectCount = lottoMatcher.calculateCorrectWinning(userNumbers, winningNumbers);
        boolean correctBonus = lottoMatcher.calculateCorrectBonus(userNumbers, bonusNumber);

        //then
        Assertions.assertThat(allCorrectCount).isEqualTo(0);
        Assertions.assertThat(correctBonus).isEqualTo(true);
    }

    @DisplayName("로또 번호 하나와 당첨 번호 0개 일치지만, 보너스 번호 1개 일치를 검증한다.")
    @Test
    void calculateAllCorrectWinning() {
        //given
        List<Integer> userNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(7, 8, 9, 10, 11, 12);
        int bonusNumber = 13;

        //when
        LottoMatcher lottoMatcher = new LottoMatcher();
        long allCorrectCount = lottoMatcher.calculateCorrectWinning(userNumbers, winningNumbers);
        boolean correctBonus = lottoMatcher.calculateCorrectBonus(userNumbers, bonusNumber);

        //then
        Assertions.assertThat(allCorrectCount).isEqualTo(0);
        Assertions.assertThat(correctBonus).isEqualTo(false);
    }

    @DisplayName("로또 번호 하나와 당첨 번호 1개 일치이고, 보너스 번호 1개 일치를 검증한다.")
    @Test
    void calculateAllCorrectWinningWithBonusNumber() {
        //given
        List<Integer> userNumbers = List.of(1, 2, 3, 4, 7, 13);
        List<Integer> winningNumbers = List.of(7, 8, 9, 10, 11, 12);
        int bonusNumber = 13;

        //when
        LottoMatcher lottoMatcher = new LottoMatcher();
        long allCorrectCount = lottoMatcher.calculateCorrectWinning(userNumbers, winningNumbers);
        boolean correctBonus = lottoMatcher.calculateCorrectBonus(userNumbers, bonusNumber);

        //then
        Assertions.assertThat(allCorrectCount).isEqualTo(1);
        Assertions.assertThat(correctBonus).isEqualTo(true);
    }

    @DisplayName("로또 번호 하나와 보너스 번호를 포함한 당첨 번호 간 일치하는 번호의 갯수가 1개인지 검증한다.")
    @Test
    void calculateAllCorrectWinningByUser() {
        //given
        List<List<Integer>> userNumbers = new ArrayList<>();
        List<Integer> firstUserNumber = List.of(1, 2, 3, 4, 5, 7);
        List<Integer> secondUserNumber = List.of(1, 2, 3, 4, 7, 13);
        userNumbers.add(firstUserNumber);
        userNumbers.add(secondUserNumber);

        List<Integer> winningNumbers = List.of(7, 8, 9, 10, 11, 12);
        int bonusNumber = 13;

        //when
        LottoResult lottoResult = new LottoResult(userNumbers, winningNumbers, bonusNumber);
        List<Long> correctWinningsCount = lottoResult.toLongList();
        List<Boolean> correctBonuses = lottoResult.toBoolList();

        //then
        Assertions.assertThat(correctWinningsCount.get(0)).isEqualTo(1);
        Assertions.assertThat(correctWinningsCount.get(1)).isEqualTo(1);
        Assertions.assertThat(correctBonuses.get(0)).isEqualTo(false);
        Assertions.assertThat(correctBonuses.get(1)).isEqualTo(true);
    }

}
