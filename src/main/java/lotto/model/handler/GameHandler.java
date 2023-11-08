package lotto.model.handler;


import static lotto.model.domain.Rank.FIFTH_RANK;
import static lotto.model.domain.Rank.FIRST_RANK;
import static lotto.model.domain.Rank.FOURTH_RANK;
import static lotto.model.domain.Rank.SECOND_RANK;
import static lotto.model.domain.Rank.THIRD_RANK;

import java.util.EnumMap;
import java.util.List;
import lotto.model.domain.Lotto;
import lotto.model.domain.Rank;
import lotto.model.domain.WinningTicket;

public class GameHandler {

    public WinningTicket createWinningTicket(List<Integer> winningNum, int bonumNum) {
        return new WinningTicket(winningNum, bonumNum);

    }

    public EnumMap<Rank, Integer> checkWinningResult(List<Lotto> lottos,
        WinningTicket winningTicket) {
        EnumMap<Rank, Integer> winningStatics = new EnumMap<>(Rank.class);

        for (Lotto lotto : lottos) {
            List<Integer> lottoNum = lotto.getNumbers();

            winningStatics = calculateRank(lottoNum, winningTicket);
        }
        return winningStatics;
    }

    public EnumMap<Rank, Integer> calculateRank(List<Integer> lottoNums,
        WinningTicket winningTicket) {
        EnumMap<Rank, Integer> winningStatics = new EnumMap<>(Rank.class);

        for (Rank rank : Rank.values()) {
            winningStatics.put(rank, 0);
        }

        List<Integer> winningNums = winningTicket.getWinningNumbers();
        boolean bonusMatching = lottoNums.contains(winningTicket.getBonusNumber());

        long matchingNum = lottoNums.stream()
            .filter(winningNums::contains)
            .count();

        if (matchingNum == FIRST_RANK.getMatchingNum()) {
            winningStatics.put(FIRST_RANK, winningStatics.get(FIRST_RANK) + 1);
        }
        if (matchingNum == SECOND_RANK.getMatchingNum() && bonusMatching) {
            winningStatics.put(SECOND_RANK, winningStatics.get(SECOND_RANK) + 1);
        }
        if (matchingNum == THIRD_RANK.getMatchingNum() && !bonusMatching) {
            winningStatics.put(THIRD_RANK, winningStatics.get(THIRD_RANK) + 1);
        }
        if (matchingNum == FOURTH_RANK.getMatchingNum()) {
            winningStatics.put(FOURTH_RANK, winningStatics.get(FOURTH_RANK) + 1);
        }
        if (matchingNum == FIFTH_RANK.getMatchingNum()) {
            winningStatics.put(FIFTH_RANK, winningStatics.get(FIFTH_RANK) + 1);
        }

        return winningStatics;
    }

    public float calculatePrizes(int purchaseAmount, EnumMap<Rank, Integer> winningStatics) {
        int winningPrize = 0;

        for (Rank rank : Rank.values()) {
            winningPrize += winningStatics.get(rank) * rank.getPrize();
        }

        float rateOfReturn = ((float) winningPrize / purchaseAmount) * 100;

        return rateOfReturn;
    }
}
