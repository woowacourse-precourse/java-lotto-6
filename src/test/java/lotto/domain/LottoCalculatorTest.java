package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;
import java.util.Map;
import lotto.constant.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCalculatorTest {
    WinningNumbers numbers = new WinningNumbers();

    @DisplayName("로또와 당첨 번호의 개수를 비교하는 기능")
    @Test
    void countMatchNumbers() {
        numbers.makeWinningNumber("4,12,39,43,1,17");
        numbers.makeBonusNumber("33");
        LottoCalculator calculator = new LottoCalculator(numbers);
        Lotto lotto = new Lotto(List.of(2, 3, 4, 12, 43, 45));

        assertThat(calculator.countMatchNumbers(lotto)).isEqualTo(3);
    }

    @DisplayName("2등 당첨이라면 매치 개수는 7을 반환한다")
    @Test
    void countMatchBonusNumbers() {
        numbers.makeWinningNumber("4,12,39,43,1,17");
        numbers.makeBonusNumber("3");
        LottoCalculator calculator = new LottoCalculator(numbers);
        Lotto lotto = new Lotto(List.of(3, 4, 12, 17, 39, 43));

        assertThat(calculator.countMatchNumbers(lotto)).isEqualTo(7);
    }

    @DisplayName("모든 로또의 등수를 판별하는 기능")
    @Test
    void makePrizeResult() {
        //given
        numbers.makeWinningNumber("4,12,39,43,1,17");
        numbers.makeBonusNumber("3");
        Lotto secondLotto = new Lotto(List.of(3, 4, 12, 17, 39, 43)); // 2등
        Lotto thirdLotto = new Lotto(List.of(1, 4, 12, 17, 43, 45)); // 3등
        LottoCalculator calculator = new LottoCalculator(numbers);
        //when
        calculator.makePrizeResult(List.of(secondLotto, thirdLotto));
        Map<Prize, Integer> result = calculator.getResult();
        //then
        assertEquals(1, result.get(Prize.SECOND));
        assertEquals(1, result.get(Prize.THIRD));
        assertNotEquals(1, result.get(Prize.FIRST));
        assertNotEquals(1, result.get(Prize.FOURTH));
        assertNotEquals(1, result.get(Prize.FIFTH));
        assertNotEquals(1, result.get(Prize.NONE));
    }

    @DisplayName("1등, 2등, 4등 당첨 시 총 상금 확인")
    @Test
    void calculateTotalPrize() {
        //given
        numbers.makeWinningNumber("4,12,39,43,1,17");
        numbers.makeBonusNumber("3");
        Lotto firstLotto = new Lotto(List.of(1, 4, 12, 17, 39, 43)); // 1등
        Lotto fourthLotto = new Lotto(List.of(1, 4, 12, 17, 18, 45)); // 4등
        Lotto secondLotto = new Lotto(List.of(3, 4, 12, 17, 39, 43)); // 2등
        LottoCalculator calculator = new LottoCalculator(numbers);
        //when
        calculator.makePrizeResult(List.of(firstLotto, secondLotto, fourthLotto));
        long totalPrize = calculator.calculateTotalPrize();

        assertThat(totalPrize).isEqualTo(2030050000);
    }
}