package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.view.OutputView;

public enum ScoreBoard {
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원)"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원)"),
    FOURTH(4, 50_000, "4개 일치 (50,000원)"),
    FIFTH(3, 5_000, "3개 일치 (5,000원)");
    private final int countOfMatch;
    private final int winningMoney;
    private final String situation;

    private ScoreBoard(int countOfMatch, int winningMoney, String situation) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.situation = situation;
    }

    public static ScoreBoard getScoreBoardResultByMatchResult(Integer countOfMatch, boolean matchBonusNumber) {
        List<ScoreBoard> scoreBoards = Arrays.asList(SECOND, FIFTH, FOURTH, THIRD, FIRST);
        if (matchBonusNumber && (countOfMatch == SECOND.countOfMatch)) {
            return SECOND;
        }
        if (countOfMatch >= FIFTH.countOfMatch) {
            return scoreBoards.get(countOfMatch - 2);
        }
        return null;
    }

    public static void showResultBoard(Map<ScoreBoard, Integer> scoreResult, int matchDefault) {
        List<ScoreBoard> scoreBoards = Arrays.asList(FIFTH, FOURTH, THIRD, SECOND, FIRST);

        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        for (ScoreBoard scoreBoard : scoreBoards) {
            int count = scoreResult.getOrDefault(scoreBoard, matchDefault);
            OutputView.showResultOfBoard(scoreBoard.situation, count);
        }
    }
}
