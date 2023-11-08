package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.Map;
import lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningTest {
    Winning winning;

    @BeforeEach
    void setUp() {
        winning = new Winning();
        winning.setNumbers(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("당첨 번호를 저장한다.")
    @Test
    void saveWinningNumbers() {
        //Given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        //When
        winning.setNumbers(numbers);
        //Then
        assertThat(winning.getNumbers()).isEqualTo(numbers);
    }

    @DisplayName("당첨 번호가 6자리 보다 크다면 예외가 발생한다.")
    @Test
    void saveWinningNumbersByOverCount() {
        assertThatThrownBy(() -> winning.setNumbers(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호의 길이는 6자리 입니다.");
    }

    @DisplayName("당첨 번호가 6자리 보다 작다면 예외가 발생한다.")
    @Test
    void saveWinningNumbersByUnderCount() {
        assertThatThrownBy(() -> winning.setNumbers(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호의 길이는 6자리 입니다.");
    }

    @DisplayName("당첨 번호가 중복된다면 예외가 발생한다.")
    @Test
    void saveWinningNumbersByDuplicate() {
        assertThatThrownBy(() -> winning.setNumbers(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 중복될 수 없습니다.");
    }

    @DisplayName("보너스 번호를 저장한다.")
    @Test
    void saveBonusNumber() {
        //When
        winning.setBonusNumber(7);
        //Then
        assertThat(winning.getBonusNumber()).isEqualTo(7);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복된다면 예외가 발생한다.")
    @Test
    void saveBonusNumberByDuplicate() {
        assertThatThrownBy(() -> winning.setBonusNumber(1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @DisplayName("보너스 번호가 45보다 크면 예외가 발생한다.")
    @Test
    void saveBonusNumberByOverRange() {
        assertThatThrownBy(() -> winning.setBonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1~45 사이 숫자 입니다.");
    }

    @DisplayName("보너스 번호가 1보다 작으면 예외가 발생한다.")
    @Test
    void saveBonusNumberBByUnderRange() {
        assertThatThrownBy(() -> winning.setBonusNumber(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1~45 사이 숫자 입니다.");
    }

    @DisplayName("당첨 통계를 계산한다.")
    @Test
    void calcTotalPrize() {
        //Given
        List<Lotto> lottos = List.of(
                new Lotto(List.of(2, 3, 4, 5, 6, 7)),   //5개 적중
                new Lotto(List.of(2, 3, 4, 5, 6, 8))    //5개 + 보너스 적중
        );
        winning.setBonusNumber(8);
        //When
        Map<Prize, Integer> totalPrize = winning.calcTotalPrize(lottos);
        //Then
        assertThat(totalPrize.get(Prize.FIVE_MATCH)).isEqualTo(1);
        assertThat(totalPrize.get(Prize.FIVE_MATCH_BONUS)).isEqualTo(1);
    }

    @DisplayName("로또 번호가 당첨 번호와 일치하는 개수를 반환한다.")
    @Test
    void getMatchNumberCount() {
        //Given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        //When
        int matchCount = winning.getMatchNumberCount(lotto);
        //Then
        assertThat(matchCount).isEqualTo(6);
    }

    @DisplayName("로또 번호 중 보너스 번호와 일치하는 숫자가 있다면 true를 반환한다.")
    @Test
    void bonusCheckByContain() {
        //Given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        winning.setBonusNumber(7);
        //When
        boolean isMatched = winning.isContainBonusNumber(lotto);
        //Then
        assertThat(isMatched).isTrue();
    }

    @DisplayName("로또 번호 중 보너스 번호와 일치하는 숫자가 없다면 false를 반환한다.")
    @Test
    void bonusCheckByNotContain() {
        //Given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        winning.setBonusNumber(7);
        //When
        boolean isMatched = winning.isContainBonusNumber(lotto);
        //Then
        assertThat(isMatched).isFalse();
    }

    @DisplayName("일치하는 로또 번호와 보너스 여부에 따른 상금 결과를 반환한다.")
    @Test
    void getPrizeByWinning() {
        //Given
        int matchCount = 5;
        boolean isMatchBonus = true;
        //When
        Prize prize = winning.getPrize(matchCount, isMatchBonus);
        //Then
        assertThat(prize).isEqualTo(Prize.FIVE_MATCH_BONUS);
    }

    @DisplayName("당첨 통게에서 해당하는 상금의 카운트를 증가시킨다.")
    @Test
    void addPrizeCount() {
        //Given
        Map<Prize, Integer> totalPrize = Prize.initTotalPrizeMap();
        Prize prize = Prize.SIX_MATCH;
        //When
        winning.addPrizeCount(totalPrize, prize);
        //Then
        assertThat(totalPrize.get(prize)).isEqualTo(1);
    }

    @DisplayName("수익률을 계산한다.")
    @Test
    void calcRevenueRate() {
        //Given
        int purchaseAmount = 3000;
        Map<Prize, Integer> totalPrize = Prize.initTotalPrizeMap();
        totalPrize.put(Prize.FOUR_MATCH, 1);
        //When
        double revenueRate = winning.calcRevenueRate(totalPrize, purchaseAmount);
        //Then
        assertThat(revenueRate).isEqualTo(1666.7);
    }

}