package lotto;


import java.util.List;

public class Prize {
    private int total = 0;
    private List<Integer> winningNumbers;
    private List<Lotto> lottos;
    private int bonusNumber;
    private int totalPrize;

    public Prize(List<Integer> winningNumbers, List<Lotto> lottos, int bonusNumber){
        this.winningNumbers = winningNumbers;
        this.lottos = lottos;
        this.bonusNumber = bonusNumber;
        this.totalPrize = getPrize();
    }

    private int getPrize(){
        int sameNumberCount = 0;
        for(Lotto lotto: lottos){
            sameNumberCount = lotto.countSameNumber(winningNumbers);


        }

    }

    private Rank getRank(int sameNumberCount, boolean sameBonusNumber){
        switch(sameNumberCount){
            case 6:
                return Rank.FIRST;
            case 5:
                if(sameBonusNumber){
                    return Rank.SECOND;
                }
                return Rank.THIRD;
            case 4:
                return Rank.FOURTH;
            case 3:
                return Rank.FIFTH;
            default:
                return Rank.NOTHING;

        }
    }
}
