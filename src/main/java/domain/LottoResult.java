package domain;

import java.math.BigDecimal;
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
            lottoResult.setLottoResultStatistic(winningCount,isBonusLotto);
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

    private void setLottoResultStatistic(int winningCount, boolean isBonusLotto){
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

    private BigDecimal createTotalProfit(LottoResult lottoResult){
        BigDecimal threePrice = new BigDecimal("5000");
        BigDecimal fourPrice = new BigDecimal("50000");
        BigDecimal fivePrice = new BigDecimal("1500000");
        BigDecimal fiveBonusPrice = new BigDecimal("30000000");
        BigDecimal sixPrice = new BigDecimal("2000000000");

        BigDecimal threePriceResult = threePrice.multiply(
                new BigDecimal(lottoResult.getThreeLottoWinning()));
        BigDecimal fourPriceResult = fourPrice.multiply(
                new BigDecimal(lottoResult.getFourLottoWinning()));
        BigDecimal fivePriceResult = fivePrice.multiply(
                new BigDecimal(lottoResult.getFiveLottoWinning()));
        BigDecimal fiveBonusPriceResult = fiveBonusPrice.multiply(
                new BigDecimal(lottoResult.getFiveBonusLottoWinning()));
        BigDecimal sixPriceResult = sixPrice.multiply(
                new BigDecimal(lottoResult.getSixLottoWinning()));

        return threePriceResult.add(fourPriceResult)
                .add(fivePriceResult)
                .add(fiveBonusPriceResult)
                .add(sixPriceResult);
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
