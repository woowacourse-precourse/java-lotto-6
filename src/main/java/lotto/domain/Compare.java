package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class Compare {
    private Map<Score, Integer> scoreResult;

    public Compare() {
        scoreResult = new EnumMap<Score, Integer>(Score.class);
        Score[] scores = Score.values();
        for(Score score : scores) {
            scoreResult.put(score, 0);
        }
    }

    private void updateScoreResult(Score score) {
        scoreResult.put(score, scoreResult.get(score)+1);
    }

    public Integer getScoreResult(Score score) {
        return scoreResult.get(score);
    }

    public void scoringResult(WinningLotto win, Lottos lottos) {
        for(Lotto lotto : lottos.getLottos()) {
            Score score = Score.getScore(lotto.sameNumberCount(win), lotto.isContain(win.getBonusNumber()));
            updateScoreResult(score);
        }
    }

}
