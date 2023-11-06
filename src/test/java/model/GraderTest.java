package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GraderTest {


  @DisplayName("로또 번호화 당첨 번호를 비교한다.")
  @Test
  void compareNumber() {
    Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(5, 1, 20, 30, 6, 40)));
    WinningLotto winningLotto = new WinningLotto(new ArrayList<>(Arrays.asList(5, 1, 30, 20, 6, 27)), 40);
    Grader grader = new Grader();
    Map<String, Integer> result = grader.compareNumber(lotto, winningLotto);
    assertThat(result.get("sameNumberCount")).isEqualTo(5);
    assertThat(result.get("sameBonusNumber")).isEqualTo(1);
  }

}