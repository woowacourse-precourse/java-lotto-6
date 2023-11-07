package lotto.domain;

import lotto.config.Rank;

import java.util.*;

import static lotto.util.MathUtil.getIntersectionSize;

public class WinningStatistics {
    private static final Map<Integer, Integer> RANKING_CONVERTER = makeRankingConverter();
    private List<Integer> statistics;

    private WinningStatistics(List<Integer> statistics) {
        this.statistics = statistics;
    }

    public List<Integer> getStatistics() {
        return statistics;
    }

    public static WinningStatistics calculateWinningConditions(UserLotto lottoTickets, WinningNumbers winningNumbers, BonusNumbers bonusNumbers) {
        List<Integer> emptyStatistics = makeEmptyStatistics();
        for (Lotto lotto : lottoTickets.getLottoTickets()) {
            updateStatistics(lotto, winningNumbers, bonusNumbers, emptyStatistics);
        }
        return new WinningStatistics(emptyStatistics);
    }

    private static Map<Integer, Integer> makeRankingConverter() {
        Map<Integer, Integer> rankingConverter = new HashMap<>();
        rankingConverter.put(3, 0);
        rankingConverter.put(4, 1);
        rankingConverter.put(5, 2);
        rankingConverter.put(-1, 3);
        rankingConverter.put(6, 4);

        return rankingConverter;
    }

    private static List<Integer> makeEmptyStatistics() {
        List<Integer> emptyList = new ArrayList<>();
        for (int i = 0; i < Rank.values().length; i++) {
            emptyList.add(0);
        }
        return emptyList;
    }

    private static void updateStatistics(Lotto lotto, WinningNumbers winningNumbers, BonusNumbers bonusNumbers, List<Integer> statistics) {
        HashSet<Integer> lottoNumber = new HashSet<>(lotto.getNumbers());
        int matchCnt = getIntersectionSize(lottoNumber, new HashSet<>(winningNumbers.getNumbers()));

        if (matchCnt >= 3) {
            if (matchCnt == 5 && getIntersectionSize(lottoNumber, new HashSet<>(bonusNumbers.getNumbers())) == 1) {
                matchCnt = -1;
            }
            statistics.set(RANKING_CONVERTER.get(matchCnt), statistics.get(RANKING_CONVERTER.get(matchCnt)) + 1);
        }
    }
}
