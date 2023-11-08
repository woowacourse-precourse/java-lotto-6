package lotto.domain;


import static lotto.domain.Rank.FIFTH_RANK;
import static lotto.domain.Rank.FIRST_RANK;
import static lotto.domain.Rank.FOURTH_RANK;
import static lotto.domain.Rank.SECOND_RANK;
import static lotto.domain.Rank.THIRD_RANK;

import java.util.EnumMap;
import java.util.List;

public class GameHandler {

    //당첨로또 발행기능
    public WinningTicket createWinningTicket(List<Integer> winningNum, int bonumNum) {
        return new WinningTicket(winningNum, bonumNum);

    }

    //당첨통계 계산기능
    public EnumMap<Rank, Integer> checkWinningResult(List<Lotto> lottos, WinningTicket winningTicket) {
        EnumMap<Rank, Integer> winningStatics = new EnumMap<>(Rank.class);

        for(Lotto lotto : lottos) {
            List<Integer> lottoNum = lotto.getNumbers();

            winningStatics = calculateRank(lottoNum, winningTicket);
        }

        return winningStatics;
    }

    public EnumMap<Rank, Integer> calculateRank(List<Integer> lottoNums, WinningTicket winningTicket) {
        EnumMap<Rank, Integer> winningStatics = new EnumMap<>(Rank.class);

        for (Rank rank : Rank.values()) {
            winningStatics.put(rank, 0);
        }

        List<Integer> winningNums = winningTicket.getWinningNumbers();
        boolean bonusMatching = lottoNums.contains(winningTicket.getBonusNumber());

        long matchingNum = lottoNums.stream()
            .filter(winningNums::contains)
            .count();

        if(matchingNum == FIRST_RANK.getMatchingNum() ) {
            winningStatics.put(FIRST_RANK, winningStatics.get(FIRST_RANK) + 1);
        }
        if(matchingNum == SECOND_RANK.getMatchingNum() && bonusMatching ) {
            winningStatics.put(SECOND_RANK, winningStatics.get(SECOND_RANK) + 1);
        }
        if(matchingNum == THIRD_RANK.getMatchingNum() && !bonusMatching ) {
            winningStatics.put(THIRD_RANK, winningStatics.get(THIRD_RANK) + 1);
        }
        if(matchingNum == FOURTH_RANK.getMatchingNum()) {
            winningStatics.put(FOURTH_RANK, winningStatics.get(FOURTH_RANK) + 1);
        }
        if(matchingNum == FIFTH_RANK.getMatchingNum()) {
            winningStatics.put(FIFTH_RANK, winningStatics.get(FIFTH_RANK) + 1);
        }

        return winningStatics;
    }

    //우승상금 수익률 계산하는 기능
    public float calculatePrizes(int purchaseQuantity, List<Integer> rankResult) {
        int purchaseAmount = purchaseQuantity * LOTTO_PRICE;
        int winningPrize = 0;

        for(int i=0; i<rankResult.size(); i++) {
            if(i == 0) {
                winningPrize += rankResult.get(i) * FIRST_PRIZE;
            }
            if(i == 1) {
                winningPrize += rankResult.get(i) * SECOND_PRIZE;
            }
            if(i == 2) {
                winningPrize += rankResult.get(i) * THIRD_PRIZE;
            }
            if(i == 3) {
                winningPrize += rankResult.get(i) * FOURTH_PRIZE;
            }
            if(i == 4) {
                winningPrize += rankResult.get(i) * FIFTH_PRIZE;
            }
        }

        float rateOfReturn1 =  (((float)(winningPrize - purchaseAmount) / purchaseAmount) * 100) + 100f;

        float rateOfReturn2 = (float) (Math.round(rateOfReturn1 * 100.0) / 100.0);





        return rateOfReturn2;
    }


}
