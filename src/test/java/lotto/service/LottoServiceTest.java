package lotto.service;

import lotto.configuration.ScoreBoard;
import lotto.configuration.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class LottoServiceTest {

    @DisplayName("산 로또의 개수는 구입 금액에서 1000을 나눈 몫이여야 한다.")
    @Test
    void generateRandomLottoNumbers() {
        //given
        final long money1 = 3000L;
        final long oneThousand = 1000L;
        LottoService lottoService = new LottoService();

        //when
        long result1 = lottoService.generateRandomLottoNumbers(money1 / oneThousand).size();

        //then
        org.assertj.core.api.Assertions.assertThat(result1).isEqualTo(money1 / oneThousand);

    }

    @DisplayName("당첨 로또와 내가 산 로또 번호 사이 일치하는 갯수 테스트")
    @Test
    void countMatchingWinningNumbers() {
        //given
        List<Integer> winLotto1 = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> myLotto1 = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winLotto2 = List.of(1, 2, 3, 4, 7, 8);
        List<Integer> myLotto2 = List.of(1, 2, 3, 4, 5, 6);
        LottoService lottoService = new LottoService();

        //when
        int result1 = lottoService.countMatchingWinningNumbers(winLotto1, myLotto1);
        int result2 = lottoService.countMatchingWinningNumbers(winLotto2, myLotto2);

        //then
        org.assertj.core.api.Assertions.assertThat(result1).isEqualTo(6);
        org.assertj.core.api.Assertions.assertThat(result2).isEqualTo(4);


    }

    @DisplayName("보너스 번호가 당첨번호에 포함되어 있으면 true 를 반환 그렇지 않으면 false 를 반환")
    @Test
    void countMatchingBonusNumbers() {
        //given
        List<Integer> winLotto1 = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winLotto2 = List.of(8, 2, 3, 4, 5, 6);
        int bonusNumber = 1;
        LottoService lottoService = new LottoService();

        //when
        boolean result1 = lottoService.countMatchingBonusNumbers(winLotto1, bonusNumber);
        boolean result2 = lottoService.countMatchingBonusNumbers(winLotto2, bonusNumber);
        //then
        org.assertj.core.api.Assertions.assertThat(result1).isEqualTo(true);
        org.assertj.core.api.Assertions.assertThat(result2).isEqualTo(false);

    }

    @Test
    void generateResultScoreBoard() {
        //given
        final String first = "1st";
        final String second = "2nd";
        final String third = "3rd";
        final String fourth = "4th";
        final String fifth = "5th";
        final String sixth = "6th";
        final String seventh = "7th";
        final String eighth = "8th";
        final long zero = 0L;
        LottoService lottoService = new LottoService();

        //when
        HashMap<String, Long> scoreBoard = lottoService.generateResultScoreBoard();

        //then
        org.assertj.core.api.Assertions.assertThat(scoreBoard).containsKey(first);
        org.assertj.core.api.Assertions.assertThat(scoreBoard).containsKey(second);
        org.assertj.core.api.Assertions.assertThat(scoreBoard).containsKey(third);
        org.assertj.core.api.Assertions.assertThat(scoreBoard).containsKey(fourth);
        org.assertj.core.api.Assertions.assertThat(scoreBoard).containsKey(fifth);
        org.assertj.core.api.Assertions.assertThat(scoreBoard).containsKey(sixth);
        org.assertj.core.api.Assertions.assertThat(scoreBoard).containsKey(seventh);
        org.assertj.core.api.Assertions.assertThat(scoreBoard).containsKey(eighth);
        org.assertj.core.api.Assertions.assertThat(scoreBoard).containsValues(zero);

    }

    @DisplayName("로또 수익 보드판 값 정확성 테스트")
    @Test
    void getResultScoreBoard() {
        //given
        List<List<Integer>> myLotto = new ArrayList<>();
        List<Integer> winLotto = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<Integer> case1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> case2 = new ArrayList<>(Arrays.asList(7, 8, 9, 10, 11, 12));
        List<Integer> case3 = new ArrayList<>(Arrays.asList(13, 14, 15, 16, 17, 18));
        myLotto.add(case1);
        myLotto.add(case2);
        myLotto.add(case3);
        LottoService lottoService = new LottoService();

        //when
        HashMap<String, Long> scoreBoard = lottoService.getResultScoreBoard(myLotto, winLotto, bonusNumber);

        //then
        Assertions.assertThat(scoreBoard.get(ScoreBoard.FIRST.getKey())).isEqualTo(2000000000L);
        Assertions.assertThat(scoreBoard.get(ScoreBoard.SECOND.getKey())).isEqualTo(0L);
        Assertions.assertThat(scoreBoard.get(ScoreBoard.THIRD.getKey())).isEqualTo(0L);
        Assertions.assertThat(scoreBoard.get(ScoreBoard.FOURTH.getKey())).isEqualTo(0L);
        Assertions.assertThat(scoreBoard.get(ScoreBoard.FIFTH.getKey())).isEqualTo(0L);
    }

    @DisplayName("로또 수익 보드판 값 정확성 테스트2")
    @Test
    void getResultScoreBoard2() {
        //given
        List<List<Integer>> myLotto = new ArrayList<>();
        List<Integer> winLotto = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<Integer> case1 = new ArrayList<>(Arrays.asList(3, 4, 5, 6, 7, 8));
        List<Integer> case2 = new ArrayList<>(Arrays.asList(7, 8, 9, 10, 11, 12));
        List<Integer> case3 = new ArrayList<>(Arrays.asList(13, 14, 15, 16, 17, 18));
        myLotto.add(case1);
        myLotto.add(case2);
        myLotto.add(case3);
        LottoService lottoService = new LottoService();

        //when
        HashMap<String, Long> scoreBoard = lottoService.getResultScoreBoard(myLotto, winLotto, bonusNumber);

        //then
        Assertions.assertThat(scoreBoard.get(ScoreBoard.FIRST.getKey())).isEqualTo(0L);
        Assertions.assertThat(scoreBoard.get(ScoreBoard.SECOND.getKey())).isEqualTo(0L);
        Assertions.assertThat(scoreBoard.get(ScoreBoard.THIRD.getKey())).isEqualTo(0L);
        Assertions.assertThat(scoreBoard.get(ScoreBoard.FOURTH.getKey())).isEqualTo(50000L);
        Assertions.assertThat(scoreBoard.get(ScoreBoard.FIFTH.getKey())).isEqualTo(0L);
    }

    @DisplayName("당첨 번호 보너스 번호에 따른 등수 결과 테스트")
    @Test
    void rankLottoResult() {
        //given
        int matchingWinningNumber1 = 6;
        int matchingWinningNumber2 = 5;
        int matchingWinningNumber3 = 4;
        int matchingWinningNumber4 = 3;
        boolean consistencyBonusNumber = true;
        boolean inconsistencyBonusNumber = false;
        LottoService lottoService = new LottoService();

        //when
        Rank result1 = lottoService.rankLottoResult(matchingWinningNumber1, consistencyBonusNumber);
        Rank result2 = lottoService.rankLottoResult(matchingWinningNumber1, inconsistencyBonusNumber);
        Rank result3 = lottoService.rankLottoResult(matchingWinningNumber2, consistencyBonusNumber);
        Rank result4 = lottoService.rankLottoResult(matchingWinningNumber2, inconsistencyBonusNumber);
        Rank result5 = lottoService.rankLottoResult(matchingWinningNumber3, inconsistencyBonusNumber);
        Rank result6 = lottoService.rankLottoResult(matchingWinningNumber3, consistencyBonusNumber);
        Rank result7 = lottoService.rankLottoResult(matchingWinningNumber4, inconsistencyBonusNumber);
        Rank result8 = lottoService.rankLottoResult(matchingWinningNumber4, consistencyBonusNumber);

        //then
        Assertions.assertThat(result1).isEqualTo(Rank.FIRST);
        Assertions.assertThat(result2).isEqualTo(Rank.FIRST);
        Assertions.assertThat(result3).isEqualTo(Rank.SECOND);
        Assertions.assertThat(result4).isEqualTo(Rank.THIRD);
        Assertions.assertThat(result5).isEqualTo(Rank.FOURTH);
        Assertions.assertThat(result6).isEqualTo(Rank.FOURTH);
        Assertions.assertThat(result7).isEqualTo(Rank.FIFTH);
        Assertions.assertThat(result8).isEqualTo(Rank.FIFTH);
    }
}