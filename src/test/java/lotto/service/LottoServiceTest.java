package lotto.service;

import lotto.domain.Lotto;
import lotto.util.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
        Lotto lotto1 = new Lotto(Utils.convertToLottoIntegerList("1,2,3,4,5,6"));
        Lotto lotto2 = new Lotto(Utils.convertToLottoIntegerList("1,2,3,4,5,6"));
        List<Integer> winLotto1 = lotto1.getLotto();
        List<Integer> myLotto1 = lotto2.getLotto();
        Lotto lotto3 = new Lotto(Utils.convertToLottoIntegerList("1,2,3,4,7,8"));
        Lotto lotto4 = new Lotto(Utils.convertToLottoIntegerList("1,2,3,4,5,6"));
        List<Integer> winLotto2 = lotto3.getLotto();
        List<Integer> myLotto2 = lotto4.getLotto();
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

    @Test
    void getResultScoreBoard() {
    }

    @Test
    void calculateLottoScore() {
    }
}