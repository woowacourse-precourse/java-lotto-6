package lotto.domain;

import java.util.List;
import lotto.util.MessageUtil;

import static lotto.enums.LottoWinningResult.*;

public class LottoStatistics {

    private final MessageUtil messageUtil = new MessageUtil();
    private LottoWinCheck lottoWinCheck = new LottoWinCheck(); // playingNums 에 관한 데이터가 없음
    private final LottoWinResult lottoWinResult = new LottoWinResult();
    public LottoStatistics(LottoWinCheck lottoWinCheck){
        this.lottoWinCheck = lottoWinCheck;
    }
    public LottoStatistics(){}
    public void getLottoStatistics(List<Lotto> userLottos, int amount){
        for(Lotto lotto : userLottos){
            List<Integer> lottoNums = lotto.getNumbers();
            int matchCount = getMatchCount(lottoNums);
            addLottoResult(getBonusNumber(lottoNums, matchCount));
        }
        messageUtil.printWinningStat();
        printResult(amount);
    }
    private void printResult(int amount){
        messageUtil.printWinningStatResult(THREE_WIN.getNumber(), THREE_WIN.getPrice(), lottoWinResult.getThreeWin());
        messageUtil.printWinningStatResult(FOUR_WIN.getNumber(), FOUR_WIN.getPrice(), lottoWinResult.getFourWin());
        messageUtil.printWinningStatResult(FIVE_WIN.getNumber(), FIVE_WIN.getPrice(), lottoWinResult.getFiveWin());
        messageUtil.printWinningStatResult(FIVE_WITH_BONUS.getNumber(), FIVE_WITH_BONUS.getPrice(), lottoWinResult.getFiveWithBonus());
        messageUtil.printWinningStatResult(SIX_WIN.getNumber(), SIX_WIN.getPrice(), lottoWinResult.getSixWin());

        long totalWinningAmount = totalWinningAmount();
        double earnRate = Double.parseDouble(calculateRate(amount, totalWinningAmount));
        messageUtil.printEarnRate(earnRate);
    }
    private void addLottoResult(int matchCount){
        System.out.println(matchCount);
        if(matchCount == THREE_WIN.getNumber()){
            lottoWinResult.addThreeWinCount();
        }
        if(matchCount == FOUR_WIN.getNumber()){
            lottoWinResult.addFourWinCount();
        }
        if(matchCount == FIVE_WIN.getNumber()){
            lottoWinResult.addFiveWinCount();
        }
        if(matchCount == FIVE_WITH_BONUS.getNumber()){
            lottoWinResult.addFiveWithBonusWinCount();
        }
        if(matchCount == SIX_WIN.getNumber()){
            lottoWinResult.addSixWinCount();
        }
    }
    public int getMatchCount(List<Integer> winningNums){
        return lottoWinCheck.winningCheck(winningNums);
    }
    public int getBonusNumber(List<Integer> userNums, int matchCount){
        if(matchCount == FIVE_WIN.getNumber() && userNums.contains(lottoWinCheck.getBonusNum())){
            return matchCount * 10;
        }
        return matchCount;
    }
    private long totalWinningAmount(){
        return (long) lottoWinResult.getThreeWin() * THREE_WIN.getPrice()
                + (long) lottoWinResult.getFourWin() * FOUR_WIN.getPrice()
                + (long) lottoWinResult.getFiveWin() * FIVE_WIN.getPrice()
                + (long) lottoWinResult.getFiveWithBonus() * FIVE_WITH_BONUS.getPrice()
                + (long) lottoWinResult.getSixWin() * SIX_WIN.getPrice();
    }
    private String calculateRate(int amount, long winningAmount){
        if(winningAmount == 0){
            return "0";
        }
        double earnRate = (double) winningAmount / (double) amount * 100;
        return String.format("%.1f", earnRate);
    }
}
