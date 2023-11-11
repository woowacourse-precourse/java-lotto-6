package domain;

import constants.LottoWinningPrize;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoResult {

    private int threeLottoWinning;
    private int fourLottoWinning;
    private int fiveLottoWinning;
    private int fiveBonusLottoWinning;
    private int sixLottoWinning;
    private boolean isBonusLotto;

    private BigDecimal totalProfit;
    private BigDecimal profitRate;


    public int getEqualsLottoCount(List<Integer> lottoNumbers, UserLotto userLotto){
        Set<Integer> lottoSet = new HashSet<>(lottoNumbers);
        int winningCount= 0;

        for (Integer userNumber : userLotto.getLottoNumbers()) {
            if (lottoSet.contains(userNumber)) {
                winningCount++;
            }
        }

        if(lottoSet.contains(userLotto.getBonusNumber())){
            this.isBonusLotto = true;
            winningCount++;
        }

        return winningCount;
    }


    public void setLottoWinning(int winningCount, boolean isBonusLotto){
        if(winningCount == 3){
            this.threeLottoWinning++;
            return;
        }
        if(winningCount == 4){
            this.fourLottoWinning++;
            return;
        }
        if(winningCount == 5){
            setWinningFiveCount(isBonusLotto);
            return;
        }
        if(winningCount == 6){
            this.sixLottoWinning++;
        }
    }

    private void setWinningFiveCount(boolean isBonusLotto){
        if(isBonusLotto){
            this.fiveBonusLottoWinning++;
            return;
        }
        this.fiveLottoWinning++;
    }


    public BigDecimal createTotalProfit(LottoResult lottoResult){
        BigDecimal[] lottoPrizes = getBigDecimalLottoPrizes();
        BigDecimal[] prizeCounts = getBigDecimalPrizeCounts(lottoResult);
        BigDecimal totalProfit = BigDecimal.ZERO;

        for(int i=0; i<prizeCounts.length; i++){
            BigDecimal calculatedPrize = lottoPrizes[i].multiply(prizeCounts[i]);
            totalProfit = totalProfit.add(calculatedPrize);
        }

        return totalProfit;
    }


    public BigDecimal createProfitRate(BigDecimal totalProfit, int amount){
        BigDecimal ratio = totalProfit.divide(new BigDecimal(amount), 3, BigDecimal.ROUND_HALF_UP);
        BigDecimal profitRate = ratio.multiply(new BigDecimal(100));

        return profitRate.stripTrailingZeros();
    }


    private BigDecimal[] getBigDecimalLottoPrizes(){
        return Arrays.stream(LottoWinningPrize.values())
                .map(lottoPrize -> new BigDecimal(lottoPrize.getPrize()))
                .toArray(BigDecimal[]::new);
    }

    private BigDecimal[] getBigDecimalPrizeCounts(LottoResult lottoResult){
        return new BigDecimal[] {
                new BigDecimal(lottoResult.getThreeLottoWinning())
                ,new BigDecimal(lottoResult.getFourLottoWinning())
                ,new BigDecimal(lottoResult.getFiveLottoWinning())
                ,new BigDecimal(lottoResult.getFiveBonusLottoWinning())
                ,new BigDecimal(lottoResult.getSixLottoWinning())};
    }


    public int getThreeLottoWinning() {
        return threeLottoWinning;
    }

    public int getFourLottoWinning() {
        return fourLottoWinning;
    }

    public int getFiveLottoWinning() {
        return fiveLottoWinning;
    }

    public int getFiveBonusLottoWinning() {
        return fiveBonusLottoWinning;
    }

    public int getSixLottoWinning() {
        return sixLottoWinning;
    }

    public boolean isBonusLotto() {
        return isBonusLotto;
    }

    public BigDecimal getProfitRate() {
        return profitRate;
    }

    public void setTotalProfitAndProfitRate(BigDecimal totalProfit, BigDecimal profitRate) {
        this.totalProfit = totalProfit;
        this.profitRate = profitRate;
    }
}
