package lotto.model.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.model.domain.vo.Lotto;
import lotto.model.domain.vo.Lottos;
import lotto.model.domain.vo.Rank;

public class RankingBoard {

    private LottoWinNumber lottoWinNumber;
    private Map<Rank, Integer> rankCount;

    private RankingBoard(LottoWinNumber lottoWinNumber) {
        this.lottoWinNumber = lottoWinNumber;
        rankCount = new EnumMap<>(Rank.class);
        Arrays.stream(Rank.values())
                .forEach(rank -> rankCount.put(rank, 0));
    }

    public static RankingBoard from(LottoWinNumber lottoWinNumber) {
        return new RankingBoard(lottoWinNumber);
    }

    public void drawWinner(Lottos playerLottos) {
        List<Lotto> lottos = playerLottos.getLottos();
        for (Lotto lotto : lottos) {
            int winCount = compareWinNumber(lotto, lottoWinNumber.getWinNumber());
            int bonusCount = compareBonusNumber(lotto, lottoWinNumber.getBonusNumber());

            registerRanking(winCount, bonusCount);
        }
    }

    private int compareWinNumber(Lotto lotto, List<Integer> winNumber) {
        int winCount = 0;
        for (int winNum : winNumber) {
            if (lotto.getNumbers().stream().anyMatch(l -> l.equals(winNum))) {
                winCount++;
            }
        }
        return winCount;
    }

    private int compareBonusNumber(Lotto lotto, int bonusNumber) {
        int bonusCount = 0;
        if (lotto.getNumbers().stream().anyMatch(l -> l.equals(bonusNumber))) {
            bonusCount++;
        }
        return bonusCount;
    }

    private void registerRanking(int winCount, int bonusCount) {
        Rank winner = Rank.winner(winCount, bonusCount);
        Integer i = rankCount.get(winner);
        rankCount.put(winner, ++i);
    }

    public Map<Rank, Integer> getRankCount() {
        return rankCount;
    }
}
