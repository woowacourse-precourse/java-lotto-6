package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GraderTest {

  Grader grader;

  @BeforeEach
  void generatedGrader() {
    grader = new Grader();
  }


  @DisplayName("로또 번호화 당첨 번호를 비교한다.")
  @Test
  void compareNumber() {
    Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(5, 1, 20, 30, 6, 40)));
    WinningLotto winningLotto = new WinningLotto(new ArrayList<>(Arrays.asList(5, 1, 30, 20, 6, 27)), 40);
    Integer rank = grader.compareNumber(lotto, winningLotto);
    assertThat(rank).isEqualTo(2);
  }

  @DisplayName("로또들의 통계를 계산한다.")
  @Test
  void compareLottoWinningLotto() {
    // given
    Lotto lotto1 = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 10, 11)));
    Lotto lotto2 = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7)));
    Lotto lotto3 = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 8)));
    WinningLotto winningLotto = new WinningLotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)), 8);
    List<Lotto> lottos = new ArrayList<>();
    lottos.add(lotto1);
    lottos.add(lotto2);
    lottos.add(lotto3);

    // when
    List<Integer> ranks = grader.compareLottoWinningLotto(lottos, winningLotto);

    // then
    List<Integer> expected = new ArrayList<>(Arrays.asList(0, 0, 1, 1, 1, 0));
    assertThat(ranks).isEqualTo(expected);


  }

}