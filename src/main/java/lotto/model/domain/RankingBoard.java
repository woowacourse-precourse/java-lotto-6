package lotto.model.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.model.domain.vo.Lotto;
import lotto.model.domain.vo.Lottos;
import lotto.model.domain.vo.Money;
import lotto.model.domain.vo.Rank;

public class RankingBoard {

    private LottoWinNumber lottoWinNumber;
    private List<Rank> ranks;

    private RankingBoard(LottoWinNumber lottoWinNumber, List<Rank> ranks) {
        this.lottoWinNumber = lottoWinNumber;
        this.ranks = ranks;
    }

    public static RankingBoard from(LottoWinNumber lottoWinNumber) {
        List<Rank> ranks = new ArrayList<>();
        ranks.add(Rank.from("1등", new Money("2000000000")));
        ranks.add(Rank.from("2등", new Money("30000000")));
        ranks.add(Rank.from("3등", new Money("1500000")));
        ranks.add(Rank.from("4등", new Money("50000")));
        ranks.add(Rank.from("5등", new Money("5000")));
        return new RankingBoard(lottoWinNumber, ranks);
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
        if (winCount == 6) {
            ranks.get(0).addWinner();
        }
        if (winCount == 5 && bonusCount == 1) {
            ranks.get(1).addWinner();
        }
        if (winCount == 4) {
            ranks.get(2).addWinner();
        }
        if (winCount == 3) {
            ranks.get(3).addWinner();
        }
        if (winCount == 4) {
            ranks.get(4).addWinner();
        }
    }
}
