package lotto.domain;

import lotto.utils.LottoPlace;

import java.util.HashMap;
import java.util.Map;

public class WinningScores {
    Map<LottoPlace, Integer> scores;
    private final String RESULT_PER_WINNING_SCORES = "%s - %d개";

    public WinningScores() {
        scores = new HashMap<>();

        for (LottoPlace lottoPlace : LottoPlace.values()) {
            scores.put(lottoPlace, 0);
        }
    }

    public void increaseScore(LottoPlace lottoPlace) {
        int scoreCount = scores.get(lottoPlace);

        scores.put(lottoPlace, scoreCount + 1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (LottoPlace lottoPlace : LottoPlace.values()) {
            if (lottoPlace == LottoPlace.NONE) {
                continue;
            }

            sb.append(String.format(RESULT_PER_WINNING_SCORES, lottoPlace.getDescription(), scores.get(lottoPlace))).append("\n");
        }

        return sb.toString();
    }
}
