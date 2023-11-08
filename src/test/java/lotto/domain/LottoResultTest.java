package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.common.enums.LottoRank;
import lotto.common.utils.NumberUtil;

public class LottoResultTest {

  private List<Integer> winningNumbers;
  private int bonusNumber;
  private List<Lotto> userLottos;
  private LottoResult lottoResult;

  @BeforeEach
  void setUp() {
    winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    bonusNumber = 45;
    userLottos = Arrays.asList(
        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 45)),
        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
        new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8)),
        new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)));
    lottoResult = new LottoResult(userLottos, winningNumbers, bonusNumber);
  }

  @DisplayName("6개가 일치하면 1등 결과를 반환한다.")
  @Test
  void lottoRankIfMatchNumberSix() {
    int matchNumber = 6;
    boolean isBonus = false;
    LottoRank lottoRank = LottoRank.valueOf(matchNumber, isBonus);
    assertEquals(LottoRank.FIRST, lottoRank);
  }

  @DisplayName("5개가 일치하고 보너스가 일치하면 2등 결과를 반환한다.")
  @Test
  void lottoRankIfMatchNumberfiveAndBonusOne() {
    int matchNumber = 5;
    boolean isBonus = true;
    LottoRank lottoRank = LottoRank.valueOf(matchNumber, isBonus);
    assertEquals(LottoRank.SECOND, lottoRank);
  }

  @DisplayName("5개가 일치하고 보너스가 일치하지 않으면 3등 결과를 반환한다.")
  @Test
  void lottoRankIfMatchNumberFive() {
    int matchNumber = 5;
    boolean isBonus = false;
    LottoRank lottoRank = LottoRank.valueOf(matchNumber, isBonus);
    assertEquals(LottoRank.THIRD, lottoRank);
  }

  @DisplayName("4개가 일치하고 보너스가 일치하지 않으면 4등 결과를 반환한다.")
  @Test
  void lottoRankIfMatchNumberFour() {
    int matchNumber = 4;
    boolean isBonus = false;
    LottoRank lottoRank = LottoRank.valueOf(matchNumber, isBonus);
    assertEquals(LottoRank.FOURTH, lottoRank);
  }

  @DisplayName("3개가 일치하고 보너스가 일치하지 않으면 5등 결과를 반환한다.")
  @Test
  void lottoRankIfMatchNumberThree() {
    int matchNumber = 3;
    boolean isBonus = false;
    LottoRank lottoRank = LottoRank.valueOf(matchNumber, isBonus);
    assertEquals(LottoRank.FIFTH, lottoRank);
  }

  @DisplayName("2개가 일치하면 NONE을 반환한다.")
  @Test
  void lottoRankIfMatchNumberTwo() {
    int matchNumber = 2;
    boolean isBonus = false;
    LottoRank lottoRank = LottoRank.valueOf(matchNumber, isBonus);
    assertEquals(LottoRank.NONE, lottoRank);
  }

  @DisplayName("1개가 일치하면 NONE을 반환한다.")
  @Test
  void lottoRankIfMatchNumberOne() {
    int matchNumber = 1;
    boolean isBonus = false;
    LottoRank lottoRank = LottoRank.valueOf(matchNumber, isBonus);
    assertEquals(LottoRank.NONE, lottoRank);
  }

  @DisplayName("일치하는 개수가 없으면 NONE을 반환한다.")
  @Test
  void lottoRankIfMatchNumberZero() {
    int matchNumber = 0;
    boolean isBonus = false;
    LottoRank lottoRank = LottoRank.valueOf(matchNumber, isBonus);
    assertEquals(LottoRank.NONE, lottoRank);
  }

  @Test
  @DisplayName("당첨금을 이용해서 수익률을 계산한다.")
  void calculateRateOfReturn() {
    double purchaseAmount = userLottos.size() * NumberUtil.LOTTO_PRICE;

    double rateOfReturn = lottoResult.getTotalRate();
    assertThat(rateOfReturn).isEqualTo(12345000 / purchaseAmount);
  }

}
