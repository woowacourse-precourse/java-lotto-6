package lotto.Model.Util;

import java.util.List;
import System.Constant;
import lotto.Model.Domain.Lotto;
import lotto.Model.Domain.Raffle;
import lotto.Model.Domain.Statics;

public class StaticsUtil {

    private int totalPrize;
    private int fifthCount;
    private int fourthCount;
    private int thirdCount;
    private int secondCount;
    private int firstCount;

    public StaticsUtil() {
        this.totalPrize = 0;
        this.fifthCount = 0;
        this.fourthCount = 0;
        this.thirdCount = 0;
        this.secondCount = 0;
        this.firstCount = 0;
    }

    public Statics setResult(List<Lotto> lottos, Raffle raffle, int purchaseMoney) {
        checkResult(lottos, raffle);
        return new Statics(fifthCount, fourthCount, thirdCount, secondCount, firstCount, calculateRevenue(purchaseMoney, totalPrize));
    }

    public void checkResult(List<Lotto> lottos, Raffle raffle) {
        for(Lotto lotto: lottos) {
            int drawResult = drawResult(lotto, raffle);
            boolean bonusResult = drawBonusNumberResult(lotto, raffle.getBonusNumber());

            setGradeResult(drawResult, bonusResult);
        }
    }

    public float calculateRevenue(int purchaseMoney, int totalPrize) {
        return ((float) (totalPrize) / purchaseMoney)*100;
    }

    public void setGradeResult(int drawResult, boolean bonusResult) {
        if(drawResult == 3) { // 5등
            totalPrize += Constant.STATICS_FIFTH_PRIZE.getConstant();
            fifthCount ++;
        }

        if(drawResult == 4) { // 4등
            totalPrize += Constant.STATICS_FOURTH_PRIZE.getConstant();
            fourthCount ++;
        }

        if(drawResult == 5) { // 3등
            totalPrize += Constant.STATICS_THIRD_PRIZE.getConstant();
            thirdCount ++;
        }

        if(drawResult == 5 && bonusResult) {
            totalPrize += Constant.STATICS_SECOND_PRIZE.getConstant();
            secondCount ++;
        }

        if(drawResult == 6) {
            totalPrize += Constant.STATICS_FIRST_PRIZE.getConstant();
            firstCount ++;
        }
    }

    public int drawResult(Lotto lotto, Raffle raffle) {
        return (int) lotto.getNumbers().stream().filter(raffle.getWinningNumbers()::contains).count();
    }

    public boolean drawBonusNumberResult(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

}
