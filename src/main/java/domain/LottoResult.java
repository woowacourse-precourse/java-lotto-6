package domain;

import constants.LottoWinningPrice;
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

    private BigDecimal totalProfit;
    private Double profitRate;

    public LottoResult getLottoResultStatistic(List<Lotto> lottoList, UserLotto lottoGame){
        LottoResult lottoResult = new LottoResult();

        for(Lotto lotto : lottoList){
            Set<Integer> lottoSet = new HashSet<>(lotto.getNumbers());
            int winningCount = getContainsLottoCount(lottoSet,lottoGame.getLottoNumbers());

            boolean isBonusLotto = false;
            if(lottoSet.contains(lottoGame.getBonusNumber())){
                isBonusLotto = true;
                winningCount++;
            }
            lottoResult.setLottoResultCount(winningCount,isBonusLotto);
        }
        BigDecimal totalProfit = lottoResult.createTotalProfit(lottoResult);
        lottoResult.setProfitRate(totalProfit ,lottoGame.getAmount());
        return lottoResult;
    }


    private int getContainsLottoCount(Set<Integer> lottoSet, List<Integer> lottoNumbers){
        int winningCount= 0;

        for (Integer userNumber : lottoNumbers) {
            if (lottoSet.contains(userNumber)) {
                winningCount++;
            }
        }
        return winningCount;
    }


    public void setLottoResultCount(int winningCount, boolean isBonusLotto){
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


    public void setProfitRate(BigDecimal totalProfit, int amount){
        BigDecimal ratio = totalProfit.divide(new BigDecimal(amount), 3, BigDecimal.ROUND_HALF_UP);
        BigDecimal profitRate = ratio.multiply(new BigDecimal(100));

        this.profitRate = profitRate.doubleValue();
    }


    public BigDecimal createTotalProfit(LottoResult lottoResult){
        BigDecimal[] lottoPrices = getBigDecimalLottoPrices();
        BigDecimal[] priceCounts = getBigDecimalPriceCounts(lottoResult);
        BigDecimal totalProfit = BigDecimal.ZERO;

        for(int i=0; i<priceCounts.length; i++){
            BigDecimal calculatedPrice = lottoPrices[i].multiply(priceCounts[i]);
            totalProfit = totalProfit.add(calculatedPrice);
        }

        return totalProfit;
    }

    private BigDecimal[] getBigDecimalLottoPrices(){
        return Arrays.stream(LottoWinningPrice.values())
                .map(lottoPrice -> new BigDecimal(lottoPrice.getPrice()))
                .toArray(BigDecimal[]::new);
    }

    private BigDecimal[] getBigDecimalPriceCounts(LottoResult lottoResult){
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

    public Double getProfitRate() {
        return profitRate;
    }
}
