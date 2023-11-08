package lotto;

import java.util.List;

public class Rank{
    private RankType lottoRank;
    private List<Integer> winningNumbers;
    private Lotto lotto;
    private int bonusNumber;
    private int totalPrize;


    public Rank(List<Integer> winningNumbers, Lotto lotto, int bonusNumber){
        this.winningNumbers = winningNumbers;
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;

        int sameNumberCount = lotto.countSameNumber(winningNumbers);
        this.lottoRank = getRank(sameNumberCount, lotto.checkBounsNumber(bonusNumber));
    }


    private RankType getRank(int sameNumberCount, boolean sameBonusNumber){
        switch(sameNumberCount){
            case 6:
                return RankType.FIRST;
            case 5:
                if(sameBonusNumber){
                    return RankType.SECOND;
                }
                return RankType.THIRD;
            case 4:
                return RankType.FOURTH;
            case 3:
                return RankType.FIFTH;
            default:
                return RankType.NOTHING;

        }
    }

    @Override
    public String toString() {
        return String.valueOf(this.lottoRank);
    }
}