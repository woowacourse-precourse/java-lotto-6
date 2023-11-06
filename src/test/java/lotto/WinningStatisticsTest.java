package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WinningStatisticsTest {

    private final List<Integer> matchingNumber = new ArrayList<>(Collections.nCopies(7, 0));
    private WinningStatistics winningStatistics;
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        winningStatistics = new WinningStatistics();
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        matchingNumber.set(0, 0);
        matchingNumber.set(3, 0);
        matchingNumber.set(4, 0);
        matchingNumber.set(5, 0);
        matchingNumber.set(6, 0);
    }

    @Test
    @DisplayName("티켓 수가 1,000원단위로 나뉘어 지는지 테스트")
    void canChangedLottoTicketsTest() {
        long ticket = winningStatistics.purchaseLottoTickets(5000);
        assertThat(ticket).isEqualTo(5);
        ticket = winningStatistics.purchaseLottoTickets(3000);
        assertThat(ticket).isEqualTo(3);
        ticket = winningStatistics.purchaseLottoTickets(12000);
        assertThat(ticket).isEqualTo(12);
    }

    @Test
    @DisplayName("숫자 일치 테스트")
    void matchingNumbersTest() {
        List<Integer> winningNumber = List.of(1, 2, 3, 7, 8, 9);
        int bonusNumber = 10;

        assertMatchingNumbers(winningNumber, bonusNumber, 3);
        winningNumber = List.of(1, 2, 3, 4, 8, 9);
        assertMatchingNumbers(winningNumber, bonusNumber, 4);
        winningNumber = List.of(1, 2, 3, 4, 5, 9);
        assertMatchingNumbers(winningNumber, bonusNumber, 5);
        winningNumber = List.of(1, 2, 3, 4, 5, 10);
        assertMatchingNumbers(winningNumber, bonusNumber, 5);
        winningNumber = List.of(1, 2, 3, 4, 5, 6);
        assertMatchingNumbers(winningNumber, bonusNumber, 6);
    }

    private void assertMatchingNumbers(List<Integer> winningNumber, int bonusNumber, int expectedCount) {
        int count = winningStatistics.calculateMatchingNumbers(lotto, winningNumber, bonusNumber);
        assertThat(expectedCount).isEqualTo(count);
    }

    @Test
    @DisplayName("로또 번호와 당첨 번호가 일치하는 갯수 테스트")
    void calculateMatchingNumbersTest() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 10, 20, 30);
        int bonusNumber = 45;

        int actual = winningStatistics.calculateMatchingNumbers(lotto, winningNumbers, bonusNumber);
        int expected = 3;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("3개가 일치하는 경우 테스트")
    void matchingNumberSetTest() {
        // 3개가 일치하는 경우
        List<Integer> numbers = List.of(0, 0, 0, 1, 0, 0, 0);
        int bonus = 10;
        int count = 3;
        List<Integer> actual = winningStatistics.matchingNumberSet(lotto, bonus, count);
        assertThat(actual).isEqualTo(numbers);
    }

    @Test
    @DisplayName("5개와 보너스 번호 일치 테스트")
    void matchingNumberSetBonusTest() {
        //
        List<Integer> numbers = List.of(1, 0, 0, 0, 0, 0, 0);
        int bonus = 6;
        int count = 5;
        List<Integer> actual = winningStatistics.matchingNumberSet(lotto, bonus, count);
        assertThat(actual).isEqualTo(numbers);
    }

    @Test
    @DisplayName("번호가 일치하지 않는 경우 테스트")
    void matchingNumberSet6Test() {
        List<Integer> numbers = List.of(0, 0, 0, 0, 0, 0, 0);
        int bonus = 7;
        int count = 2;
        List<Integer> actual = winningStatistics.matchingNumberSet(lotto, bonus, count);
        assertThat(actual).isEqualTo(numbers);
    }


    @Test
    @DisplayName("당첨 개수에 따른 수익률 테스트")
    void matchingTotalTest() {
        long userCost = 20000;
        double actual = winningStatistics.matchingTotal(userCost, matchingNumber);
        double expected = matchingNumber.get(3) * 5_000 +
                matchingNumber.get(4) * 50_000 +
                matchingNumber.get(5) * 1_500_000 +
                matchingNumber.get(6) * 2_000_000_000 +
                matchingNumber.get(0) * 30_000_000;
        expected = expected / userCost * 100;

        assertEquals(expected, actual);
    }
}