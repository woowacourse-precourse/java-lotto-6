package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.view.OutputView;

public enum ScoreBoard {
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원)"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원)"),
    FOURTH(4, 50_000, "4개 일치 (50,000원)"),
    FIFTH(3, 5_000, "3개 일치 (5,000원)"),
    MISS(0, 0, "일치 없음");
    private final int countOfMatch;
    private final int winningMoney;
    private final String situation;

    private ScoreBoard(int countOfMatch, int winningMoney, String situation) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.situation = situation;
    }

    public static ScoreBoard getScoreBoardResultByMatchResult(Integer countOfMatch, boolean matchBonusNumber) {
        List<ScoreBoard> scoreBoards = Arrays.asList(MISS, SECOND, FIFTH, FOURTH, THIRD, FIRST);
        if (matchBonusNumber && (countOfMatch == SECOND.countOfMatch)) {
            return SECOND;
        }
        if (countOfMatch >= FIFTH.countOfMatch) {
            return scoreBoards.get(countOfMatch - 1);
        }
        return MISS;
    }

    public static int calculatePrize(Map<ScoreBoard, Integer> scoreResult) {
        int totalPrize = 0;
        for (Map.Entry<ScoreBoard, Integer> entry : scoreResult.entrySet()) {
            ScoreBoard scoreBoard = entry.getKey();
            int count = entry.getValue();
            int prize = count * scoreBoard.winningMoney;
            totalPrize += prize;
        }
        return totalPrize;
    }

    public static void showResultBoard(Map<ScoreBoard, Integer> scoreResult, int matchDefault) {
        List<ScoreBoard> scoreBoards = Arrays.asList(FIRST, SECOND, THIRD, FOURTH, FIFTH);
        for (ScoreBoard scoreBoard : scoreBoards) {
            int count = scoreResult.getOrDefault(scoreBoard, matchDefault);
            OutputView.showResultOfBoard(scoreBoard.situation, count);
        }
    }
}
