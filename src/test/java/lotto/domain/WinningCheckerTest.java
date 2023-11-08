package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WinningCheckerTest {
    @Test
    @DisplayName("로또 1등")
    void checkFirstRankTest() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        ArrayList<List<Integer>> purchaseLottoNumbers = new ArrayList<>();
        purchaseLottoNumbers.add(List.of(1, 2, 3, 4, 5, 6));

        WinningChecker winningChecker = new WinningChecker(purchaseLottoNumbers, winningNumbers, bonusNumber);
        Map<Rank, Integer> matchCount = winningChecker.getMatchCount();

        int expectedFirstRankCount = 1;
        int expectedSecondRankCount = 0;
        int expectedThirdRankCount = 0;
        int expectedForthRankCount = 0;
        int expectedFifthRankCount = 0;

        assertEquals(expectedFirstRankCount, matchCount.get(Rank.FIRST));
        assertEquals(expectedSecondRankCount, matchCount.get(Rank.SECOND));
        assertEquals(expectedThirdRankCount, matchCount.get(Rank.THIRD));
        assertEquals(expectedForthRankCount, matchCount.get(Rank.FOURTH));
        assertEquals(expectedFifthRankCount, matchCount.get(Rank.FIFTH));
    }
    @Test
    @DisplayName("로또 2등")
    void checkSecondRankTest() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        ArrayList<List<Integer>> purchaseLottoNumbers = new ArrayList<>();
        purchaseLottoNumbers.add(List.of(1, 2, 3, 4, 5, 7));

        WinningChecker winningChecker = new WinningChecker(purchaseLottoNumbers, winningNumbers, bonusNumber);
        Map<Rank, Integer> matchCount = winningChecker.getMatchCount();

        int expectedFirstRankCount = 0;
        int expectedSecondRankCount = 1;
        int expectedThirdRankCount = 0;
        int expectedForthRankCount = 0;
        int expectedFifthRankCount = 0;

        assertEquals(expectedFirstRankCount, matchCount.get(Rank.FIRST));
        assertEquals(expectedSecondRankCount, matchCount.get(Rank.SECOND));
        assertEquals(expectedThirdRankCount, matchCount.get(Rank.THIRD));
        assertEquals(expectedForthRankCount, matchCount.get(Rank.FOURTH));
        assertEquals(expectedFifthRankCount, matchCount.get(Rank.FIFTH));
    }
    @Test
    @DisplayName("로또 3등")
    void checkThirdRankTest() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        ArrayList<List<Integer>> purchaseLottoNumbers = new ArrayList<>();
        purchaseLottoNumbers.add(List.of(1, 2, 3, 4, 5, 8));

        WinningChecker winningChecker = new WinningChecker(purchaseLottoNumbers, winningNumbers, bonusNumber);
        Map<Rank, Integer> matchCount = winningChecker.getMatchCount();

        int expectedFirstRankCount = 0;
        int expectedSecondRankCount = 0;
        int expectedThirdRankCount = 1;
        int expectedForthRankCount = 0;
        int expectedFifthRankCount = 0;

        assertEquals(expectedFirstRankCount, matchCount.get(Rank.FIRST));
        assertEquals(expectedSecondRankCount, matchCount.get(Rank.SECOND));
        assertEquals(expectedThirdRankCount, matchCount.get(Rank.THIRD));
        assertEquals(expectedForthRankCount, matchCount.get(Rank.FOURTH));
        assertEquals(expectedFifthRankCount, matchCount.get(Rank.FIFTH));
    }
    @Test
    @DisplayName("로또 4등")
    void checkForthRankTest() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        ArrayList<List<Integer>> purchaseLottoNumbers = new ArrayList<>();
        purchaseLottoNumbers.add(List.of(1, 2, 3, 4, 9, 10));

        WinningChecker winningChecker = new WinningChecker(purchaseLottoNumbers, winningNumbers, bonusNumber);
        Map<Rank, Integer> matchCount = winningChecker.getMatchCount();

        int expectedFirstRankCount = 0;
        int expectedSecondRankCount = 0;
        int expectedThirdRankCount = 0;
        int expectedForthRankCount = 1;
        int expectedFifthRankCount = 0;

        assertEquals(expectedFirstRankCount, matchCount.get(Rank.FIRST));
        assertEquals(expectedSecondRankCount, matchCount.get(Rank.SECOND));
        assertEquals(expectedThirdRankCount, matchCount.get(Rank.THIRD));
        assertEquals(expectedForthRankCount, matchCount.get(Rank.FOURTH));
        assertEquals(expectedFifthRankCount, matchCount.get(Rank.FIFTH));
    }
    @Test
    @DisplayName("로또 5등")
    void checkFifthRankTest() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        ArrayList<List<Integer>> purchaseLottoNumbers = new ArrayList<>();
        purchaseLottoNumbers.add(List.of(1, 2, 3, 11, 12, 13));

        WinningChecker winningChecker = new WinningChecker(purchaseLottoNumbers, winningNumbers, bonusNumber);
        Map<Rank, Integer> matchCount = winningChecker.getMatchCount();

        int expectedFirstRankCount = 0;
        int expectedSecondRankCount = 0;
        int expectedThirdRankCount = 0;
        int expectedForthRankCount = 0;
        int expectedFifthRankCount = 1;

        assertEquals(expectedFirstRankCount, matchCount.get(Rank.FIRST));
        assertEquals(expectedSecondRankCount, matchCount.get(Rank.SECOND));
        assertEquals(expectedThirdRankCount, matchCount.get(Rank.THIRD));
        assertEquals(expectedForthRankCount, matchCount.get(Rank.FOURTH));
        assertEquals(expectedFifthRankCount, matchCount.get(Rank.FIFTH));
    }
    @Test
    @DisplayName("로또 등수 밖")
    void checkOutOfRankTest() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        ArrayList<List<Integer>> purchaseLottoNumbers = new ArrayList<>();
        purchaseLottoNumbers.add(List.of(1, 2, 14, 15, 16, 17));

        WinningChecker winningChecker = new WinningChecker(purchaseLottoNumbers, winningNumbers, bonusNumber);
        Map<Rank, Integer> matchCount = winningChecker.getMatchCount();

        int expectedFirstRankCount = 0;
        int expectedSecondRankCount = 0;
        int expectedThirdRankCount = 0;
        int expectedForthRankCount = 0;
        int expectedFifthRankCount = 0;

        assertEquals(expectedFirstRankCount, matchCount.get(Rank.FIRST));
        assertEquals(expectedSecondRankCount, matchCount.get(Rank.SECOND));
        assertEquals(expectedThirdRankCount, matchCount.get(Rank.THIRD));
        assertEquals(expectedForthRankCount, matchCount.get(Rank.FOURTH));
        assertEquals(expectedFifthRankCount, matchCount.get(Rank.FIFTH));
    }
    @Test
    @DisplayName("로또의 등수 별 count")
    void checkWinningRankTest() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        ArrayList<List<Integer>> purchaseLottoNumbers = new ArrayList<>();
        purchaseLottoNumbers.add(List.of(1, 2, 3, 4, 5, 6));
        purchaseLottoNumbers.add(List.of(1, 2, 3, 4, 5, 7));
        purchaseLottoNumbers.add(List.of(1, 2, 3, 4, 5, 8));
        purchaseLottoNumbers.add(List.of(1, 2, 3, 4, 9, 10));
        purchaseLottoNumbers.add(List.of(1, 2, 3, 11, 12, 13));
        purchaseLottoNumbers.add(List.of(1, 2, 14, 15, 16, 17));

        WinningChecker winningChecker = new WinningChecker(purchaseLottoNumbers, winningNumbers, bonusNumber);
        Map<Rank, Integer> matchCount = winningChecker.getMatchCount();

        int expectedFirstRankCount = 1;
        int expectedSecondRankCount = 1;
        int expectedThirdRankCount = 1;
        int expectedForthRankCount = 1;
        int expectedFifthRankCount = 1;

        assertEquals(expectedFirstRankCount, matchCount.get(Rank.FIRST));
        assertEquals(expectedSecondRankCount, matchCount.get(Rank.SECOND));
        assertEquals(expectedThirdRankCount, matchCount.get(Rank.THIRD));
        assertEquals(expectedForthRankCount, matchCount.get(Rank.FOURTH));
        assertEquals(expectedFifthRankCount, matchCount.get(Rank.FIFTH));
    }
}
