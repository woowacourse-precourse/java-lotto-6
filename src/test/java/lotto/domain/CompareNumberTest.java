package lotto.domain;

import static lotto.constant.WinPriceMessage.First;
import static lotto.constant.WinPriceMessage.Fourth;
import static lotto.constant.WinPriceMessage.Third;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import lotto.constant.WinPriceMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CompareNumberTest {

    @DisplayName("티켓 수 만큼 구매한 랜덤번호 전체 테스트")
    @Test
    void 여러_리스트_테스트() {

        List<List<Integer>> testAllRandomNumbers = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(7, 8, 9, 10, 11, 12),
                Arrays.asList(1, 2, 3, 4, 8, 9)
        );
        List<Integer> testNumbers = Arrays.asList(1, 2, 3, 4, 8, 9);
        int testBonusNumber = 10;

        List<LottoResultCalculator> compareNumbers = LottoResultCalculator.generateResultCalculators(testNumbers,
                testBonusNumber, testAllRandomNumbers);

        assertThat(compareNumbers.get(0).getMoneySum()).isEqualTo(Fourth.getPrize());
        assertThat(compareNumbers.get(0).getWinCount()).containsExactly(0, 0, 0, 1, 0); //

        assertThat(compareNumbers.get(1).getMoneySum()).isEqualTo(0);
        assertThat(compareNumbers.get(1).getWinCount()).containsExactly(0, 0, 0, 0, 0);

        assertThat(compareNumbers.get(2).getMoneySum()).isEqualTo(First.getPrize());
        assertThat(compareNumbers.get(2).getWinCount()).containsExactly(1, 0, 0, 0, 0);
    }


    @DisplayName("6개의 숫자가 전부 같은 경우")
    @Test
    void 일등_당첨() {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> randomNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        LottoResultCalculator comPareNumber = new LottoResultCalculator(numbers, randomNumbers, bonusNumber);
        comPareNumber.calculateResult();

        assertEquals(WinPriceMessage.First.getPrize(), comPareNumber.getMoneySum());
        assertEquals(1, (int) comPareNumber.getWinCount().get(0));
    }

    @DisplayName("5개의 숫자가 같고, 보너스 번호까지 같은 경우")
    @Test
    void 이등_당첨() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 7);
        List<Integer> randomNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        LottoResultCalculator comPareNumber = new LottoResultCalculator(numbers, randomNumbers, bonusNumber);
        comPareNumber.calculateResult();

        assertEquals(WinPriceMessage.Second.getPrize(), comPareNumber.getMoneySum());
        assertEquals(1, (int) comPareNumber.getWinCount().get(1));

    }

    @DisplayName("5개의 숫자가 같고, 보너스 번호가 다른 경우")
    @Test
    void 삼등_당첨() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 7);
        List<Integer> randomNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 8;

        LottoResultCalculator comPareNumber = new LottoResultCalculator(numbers, randomNumbers, bonusNumber);
        comPareNumber.calculateResult();

        assertEquals(Third.getPrize(), comPareNumber.getMoneySum());
        assertEquals(1, (int) comPareNumber.getWinCount().get(2));

    }

    @DisplayName("4개의 숫자가 같은 경우")
    @Test
    void 사등_당첨() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 10, 11);
        List<Integer> randomNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 5;

        LottoResultCalculator comPareNumber = new LottoResultCalculator(numbers, randomNumbers, bonusNumber);
        comPareNumber.calculateResult();

        assertEquals(WinPriceMessage.Fourth.getPrize(), comPareNumber.getMoneySum());
        assertEquals(1, (int) comPareNumber.getWinCount().get(3));

    }

    @DisplayName("3개의 숫자가 같은 경우")
    @Test
    void 오등_당첨() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 9, 10, 11);
        List<Integer> randomNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 5;

        LottoResultCalculator comPareNumber = new LottoResultCalculator(numbers, randomNumbers, bonusNumber);
        comPareNumber.calculateResult();

        assertEquals(WinPriceMessage.Fifth.getPrize(), comPareNumber.getMoneySum());
        assertEquals(1, (int) comPareNumber.getWinCount().get(4));

    }


}

