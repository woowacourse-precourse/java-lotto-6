package lotto.service;

import lotto.domain.LottoRank;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

import static lotto.consts.ConstsString.ZERO;
import static lotto.consts.ConstsString.MATCH_FORMAT;
import static lotto.consts.ConstsString.BONUS_CHECK;
import static lotto.consts.ConstsString.MISS;
import static lotto.consts.ConstsString.EMPTY;
import static lotto.consts.ConstsString.PRIZE_FORMAT;
import static lotto.domain.LottoRank.SECOND;

public class GameResultFormat {

    public String generateWinningStatistics(LinkedHashMap<LottoRank, Integer> winnerCount) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> !rank.name().equals(MISS))
                .map(rank -> generateRankMessage(rank, winnerCount.getOrDefault(rank, ZERO)))
                .collect(Collectors.joining());
    }

    private String generateRankMessage(LottoRank rank, int count) {
        String bonusPart = EMPTY;
        if (rank.getCheckBonus() && rank.getMatch() == SECOND.getMatch()) {
            bonusPart = BONUS_CHECK;
        }
        return String.format(MATCH_FORMAT,
                rank.getMatch(),
                bonusPart,
                String.format(PRIZE_FORMAT, rank.getPrize()),
                count);
    }
}
