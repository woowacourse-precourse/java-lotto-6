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
        numbers.makeWinningNumber(List.of(4, 12, 39, 43, 1, 17));
        numbers.makeBonusNumber(33);
        LottoCalculator calculator = new LottoCalculator(numbers);
        Lotto lotto = new Lotto(List.of(2, 3, 4, 12, 43, 45));

        assertThat(calculator.countMatchNumbers(lotto)).isEqualTo(3);
    }

    @DisplayName("2등 당첨이라면 매치 개수는 7을 반환한다")
    @Test
    void countMatchBonusNumbers() {
        numbers.makeWinningNumber(List.of(4, 12, 39, 43, 1, 17));
        numbers.makeBonusNumber(3);
        LottoCalculator calculator = new LottoCalculator(numbers);
        Lotto lotto = new Lotto(List.of(3, 4, 12, 17, 39, 43));

        assertThat(calculator.countMatchNumbers(lotto)).isEqualTo(7);
    }

    @DisplayName("2등, 3등 당첨 시 해당 등수만 결과에 기록하는 기능 테스트")
    @Test
    void makePrizeResult() {
        //given
        numbers.makeWinningNumber(List.of(4, 12, 39, 43, 1, 17));
        numbers.makeBonusNumber(3);
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
        numbers.makeWinningNumber(List.of(4, 12, 39, 43, 1, 17));
        numbers.makeBonusNumber(3);
        Lotto firstLotto = new Lotto(List.of(1, 4, 12, 17, 39, 43)); // 1등
        Lotto fourthLotto = new Lotto(List.of(1, 4, 12, 17, 18, 45)); // 4등
        Lotto secondLotto = new Lotto(List.of(3, 4, 12, 17, 39, 43)); // 2등
        LottoCalculator calculator = new LottoCalculator(numbers);
        //when
        calculator.makePrizeResult(List.of(firstLotto, secondLotto, fourthLotto));
        long totalPrize = calculator.calculateTotalPrize();

        assertThat(totalPrize).isEqualTo(2030050000);
    }

    @DisplayName("4,000원을 넣고 50,000원 당첨 시 수익률 반환 테스트")
    @Test
    public void calculateProfitRate() {
        //given
        numbers.makeWinningNumber(List.of(4, 12, 39, 43, 1, 17));
        numbers.makeBonusNumber(3);
        Lotto fourthLotto = new Lotto(List.of(1, 4, 12, 17, 18, 45)); // 4등
        LottoCalculator calculator = new LottoCalculator(numbers);
        calculator.makePrizeResult(List.of(fourthLotto));
        int money = 4000;
        //when
        String profitRateFromCalculator = calculator.calculateProfitRate(money);
        //then
        assertThat(profitRateFromCalculator).isEqualTo("1250.0");
    }

    @DisplayName("46000원을 넣고 5,000원 당첨 시 수익률 반환 테스트")
    @Test
    public void calculateLossPercentage() {
        //given
        numbers.makeWinningNumber(List.of(4, 12, 39, 43, 1, 17));
        numbers.makeBonusNumber(3);
        Lotto fifthLotto = new Lotto(List.of(1, 4, 12, 18, 22, 45)); // 5등
        LottoCalculator calculator = new LottoCalculator(numbers);
        calculator.makePrizeResult(List.of(fifthLotto));
        int money = 46000;
        //when
        String profitRateFromCalculator = calculator.calculateProfitRate(money);
        //then
        assertThat(profitRateFromCalculator).isEqualTo("10.9");
    }
}