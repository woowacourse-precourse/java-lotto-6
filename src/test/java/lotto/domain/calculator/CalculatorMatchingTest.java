package lotto.domain.calculator;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorMatchingTest {
    @DisplayName("랭크 계산 테스트 - 1등 당첨")
    @Test
    void calculateRanks_FirstRank() {
        CalculatorMatching calculator = new CalculatorMatching();
        Lotto ticket = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6), 7);
        int bonusNumber = 7;

        List<Rank> ranks = calculator.calculateRanks(List.of(ticket), winningNumber, bonusNumber);

        assertThat(ranks).containsExactly(Rank.FIRST);
    }

    @DisplayName("랭크 계산 테스트 - 2등 당첨 (5개 일치 + 보너스 번호 일치)")
    @Test
    void calculateRanks_SecondRank() {
        CalculatorMatching calculator = new CalculatorMatching();
        Lotto ticket = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 7), 6);
        int bonusNumber = 6;

        List<Rank> ranks = calculator.calculateRanks(List.of(ticket), winningNumber, bonusNumber);

        assertThat(ranks).containsExactly(Rank.SECOND);
    }

    @DisplayName("랭크 계산 테스트 - 3등 당첨 (5개 일치)")
    @Test
    void calculateRanks_ThirdRank() {
        CalculatorMatching calculator = new CalculatorMatching();
        Lotto ticket = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 7), 8);
        int bonusNumber = 7;

        List<Rank> ranks = calculator.calculateRanks(List.of(ticket), winningNumber, bonusNumber);

        assertThat(ranks).containsExactly(Rank.THIRD);
    }

    @DisplayName("랭크 계산 테스트 - 4등 당첨 (4개 일치)")
    @Test
    void calculateRanks_FourthRank() {
        CalculatorMatching calculator = new CalculatorMatching();
        Lotto ticket = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 7, 8), 9);
        int bonusNumber = 10;

        List<Rank> ranks = calculator.calculateRanks(List.of(ticket), winningNumber, bonusNumber);

        assertThat(ranks).containsExactly(Rank.FOURTH);
    }

    @DisplayName("랭크 계산 테스트 - 5등 당첨 (3개 일치)")
    @Test
    void calculateRanks_FifthRank() {
        CalculatorMatching calculator = new CalculatorMatching();
        Lotto ticket = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 7, 8, 9), 10);
        int bonusNumber = 11;

        List<Rank> ranks = calculator.calculateRanks(List.of(ticket), winningNumber, bonusNumber);

        assertThat(ranks).containsExactly(Rank.FIFTH);
    }

    @DisplayName("랭크 계산 테스트 - 꽝 (아무 숫자 일치하지 않음)")
    @Test
    void calculateRanks_NoWinning() {
        CalculatorMatching calculator = new CalculatorMatching();
        Lotto ticket = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(List.of(7, 8, 9, 10, 11, 12), 13);
        int bonusNumber = 14;

        List<Rank> ranks = calculator.calculateRanks(List.of(ticket), winningNumber, bonusNumber);

        assertThat(ranks).containsExactly(Rank.NONE);
    }
}