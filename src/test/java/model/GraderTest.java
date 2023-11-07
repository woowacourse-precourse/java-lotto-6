package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.in;
import static org.junit.jupiter.api.Assertions.*;

class GraderTest {

  Grader grader;
  WinningLotto winningLotto;

  // 테스트 코드 마다 실행 : grader, WinningLotto 생성 
  @BeforeEach
  void generatedGrader() {
    grader = new Grader();
    winningLotto = new WinningLotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)), 45);
  }



  @DisplayName("로또들의 통계를 계산한다.")
  @Test
  void compareLottoWinningLotto() {
    // given
    Lotto lotto1 = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))); // 1등
    Lotto lotto2 = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 45))); // 2등
    Lotto lotto3 = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7))); // 3등
    Lotto lotto4 = new Lotto(new ArrayList<>(Arrays.asList(7, 8, 1, 2, 3, 4))); // 4등
    Lotto lotto5 = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 7, 8, 9))); // 5등
    Lotto lottoNothing = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 7, 10, 8, 9))); // 등수 없음

    List<Lotto> lottos = new ArrayList<>();
    lottos.add(lotto1);
    lottos.add(lotto2);
    lottos.add(lotto3);
    lottos.add(lotto4);
    lottos.add(lotto5);
    lottos.add(lottoNothing);

    // when
    List<Integer> ranks = grader.compareLottoWinningLotto(lottos, winningLotto);

    // then
    List<Integer> expected = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1));
    assertThat(ranks).isEqualTo(expected);
  }


  @DisplayName("로또와 당첨 번호와 보너스 번호를 비교하여 등수를 구한다 - 1등")
  @Test
  void compareNumberOne() {
    Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));  // 1등
    Integer rank1 = grader.compareNumber(lotto1, winningLotto);
    assertThat(rank1).isEqualTo(1);
  }

  @DisplayName("로또와 당첨 번호와 보너스 번호를 비교하여 등수를 구한다 - 2등")
  @Test
  void compareNumberTwo() {
    Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 45)); // 2등
    Integer rank2 = grader.compareNumber(lotto2, winningLotto);
    assertThat(rank2).isEqualTo(2);
  }

  @DisplayName("로또와 당첨 번호와 보너스 번호를 비교하여 등수를 구한다 - 3등")
  @Test
  void compareNumberThree() {
    Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 7));  // 3등
    Integer rank3 = grader.compareNumber(lotto3, winningLotto);
    assertThat(rank3).isEqualTo(3);
  }

  @DisplayName("로또와 당첨 번호와 보너스 번호를 비교하여 등수를 구한다 - 4등")
  @Test
  void compareNumberFour() {
    Lotto lotto4 = new Lotto(List.of(1, 2, 3, 4, 8, 7));  // 4등
    Integer rank4 = grader.compareNumber(lotto4, winningLotto);
    assertThat(rank4).isEqualTo(4);
  }

  @DisplayName("로또와 당첨 번호와 보너스 번호를 비교하여 등수를 구한다 - 5등")
  @Test
  void compareNumberFive() {
    Lotto lotto5 = new Lotto(List.of(1, 2, 3, 9, 8, 7));  // 5등
    Integer rank5 = grader.compareNumber(lotto5, winningLotto);
    assertThat(rank5).isEqualTo(5);
  }

  @DisplayName("로또와 당첨 번호와 보너스 번호를 비교하여 등수를 구한다 - 5등")
  @Test
  void compareNumberNothing() {
    Lotto lottoNothing = new Lotto(List.of(1, 2, 10, 9, 8, 7));  // 5등
    Integer rankNothing = grader.compareNumber(lottoNothing, winningLotto);
    assertThat(rankNothing).isEqualTo(0);
  }

  @DisplayName("일치한 번호 갯수와 보너스 번호 일치 여부를 받아 등수를 책정한다. - 1등")
  @Test
  void checkRankOne() {
    int sameNumberCount = 6;
    int sameBonusNumber1 = 1;
    int sameBonusNumber2 = 0;
    Integer rank1 = grader.checkRank(sameNumberCount, sameBonusNumber1);
    Integer rank2 = grader.checkRank(sameNumberCount, sameBonusNumber2);
    assertThat(rank1).isEqualTo(1);
    assertThat(rank2).isEqualTo(1);
  }

  @DisplayName("일치한 번호 갯수와 보너스 번호 일치 여부를 받아 등수를 책정한다. - 2등")
  @Test
  void checkRankTwo() {
    int sameNumberCount = 5;
    int sameBonusNumber = 1;
    Integer rank = grader.checkRank(sameNumberCount, sameBonusNumber);
    assertThat(rank).isEqualTo(2);
  }

  @DisplayName("일치한 번호 갯수와 보너스 번호 일치 여부를 받아 등수를 책정한다. - 3등")
  @Test
  void checkRankThree() {
    int sameNumberCount = 5;
    int sameBonusNumber = 0;
    Integer rank = grader.checkRank(sameNumberCount, sameBonusNumber);
    assertThat(rank).isEqualTo(3);
  }

  @DisplayName("일치한 번호 갯수와 보너스 번호 일치 여부를 받아 등수를 책정한다. - 4등")
  @Test
  void checkRankFour() {
    int sameNumberCount = 4;
    int sameBonusNumber1 = 0;
    int sameBonusNumber2 = 1;
    Integer rank1 = grader.checkRank(sameNumberCount, sameBonusNumber1);
    Integer rank2 = grader.checkRank(sameNumberCount, sameBonusNumber2);
    assertThat(rank1).isEqualTo(4);
    assertThat(rank2).isEqualTo(4);
  }

  @DisplayName("일치한 번호 갯수와 보너스 번호 일치 여부를 받아 등수를 책정한다. - 5등")
  @Test
  void checkRankFive() {
    int sameNumberCount = 3;
    int sameBonusNumber1 = 0;
    int sameBonusNumber2 = 1;
    Integer rank1 = grader.checkRank(sameNumberCount, sameBonusNumber1);
    Integer rank2 = grader.checkRank(sameNumberCount, sameBonusNumber2);
    assertThat(rank1).isEqualTo(5);
    assertThat(rank2).isEqualTo(5);
  }

  @DisplayName("일치한 번호 갯수와 보너스 번호 일치 여부를 받아 등수를 책정한다. - 등수 없음")
  @Test
  void checkRankNothing() {
    int sameNumberCount = 2;
    int sameBonusNumber1 = 0;
    int sameBonusNumber2 = 1;
    Integer rank1 = grader.checkRank(sameNumberCount, sameBonusNumber1);
    Integer rank2 = grader.checkRank(sameNumberCount, sameBonusNumber2);
    assertThat(rank1).isEqualTo(0);
    assertThat(rank2).isEqualTo(0);
  }


  @DisplayName("구입 금액과 당첨 내역을 비교하여 수익률을 계산한다")
  @Test
  void calculateEarningRatio() {
    Integer inputMoney = 3000;
    List<Integer> winningDetails = new ArrayList<>(List.of(1,1,1,1,1,1));

    // 2,031,555,000
    // 67718500

    BigDecimal earningRatio = grader.calculateEarningRatio(inputMoney, winningDetails);
    assertThat(earningRatio).isEqualTo(new BigDecimal(67718500.0).setScale(1));
  }

}