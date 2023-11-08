package domain;

import util.MessageUtil;

import java.util.List;

import static constant.ResultMessage.*;

public class LottoResultCompute {
    private final MessageUtil messageUtil = new MessageUtil();
    private final LottoWinningNumber lottoWinningNumberInfo;
    private final LottoBonusNumber lottoBonusNumberInfo;
    private final LottoMatchCount lottoMatchCount = new LottoMatchCount();
    public LottoResultCompute(LottoWinningNumber lottoWinningNumber, LottoBonusNumber lottoBonusNumber){
        this.lottoWinningNumberInfo = lottoWinningNumber;
        this.lottoBonusNumberInfo = lottoBonusNumber;
    }
    public void getLottoResultComputeInfo(List<Lotto> userLottos, int lottoAmount){
        messageUtil.printWinningStatistic();

        for(Lotto userLotto : userLottos){
            List<Integer> userLottoNumbers = userLotto.getLottoNumbers();
            int matchCount = getMatchNumbers(userLottoNumbers);
//            System.out.println(matchCount);
            int matchCountWithBonus = checkBonusNumber(matchCount, userLottoNumbers);
            addMatchNumbers(matchCountWithBonus, userLottoNumbers);
        }
        printLottoResults(lottoAmount);
    }
    private int getMatchNumbers(List<Integer> userLottoNumbers){
        long count = userLottoNumbers.stream()
                .filter(lottoWinningNumberInfo.getLottoWinningNum()::contains)
                .count();
        return (int)count;
    }
    private void addMatchNumbers(int matchCount, List<Integer> userLottoNumbers){
//        System.out.println(matchCount);
        if(matchCount == THREE.getMatchNumber()){
            lottoMatchCount.addThreeCount();
        }
        if(matchCount == FOUR.getMatchNumber()){
            lottoMatchCount.addFourCount();
        }
        if(matchCount == FIVE.getMatchNumber()){
            lottoMatchCount.addFiveCount();
        }
        if(matchCount == FIVE_WITH_BONUS.getMatchNumber()){
            lottoMatchCount.addFiveWithBonusCount();
        }
        if(matchCount == SIX.getMatchNumber()){
            lottoMatchCount.addSixCount();
        }
    }
    private void printLottoResults(int lottoAmount){
        messageUtil.printWinningResult(THREE.getMatchNumber(), THREE.getPrice(), lottoMatchCount.getThreeCount());
        messageUtil.printWinningResult(FOUR.getMatchNumber(), FOUR.getPrice(), lottoMatchCount.getFourCount());
        messageUtil.printWinningResult(FIVE.getMatchNumber(), FIVE.getPrice(), lottoMatchCount.getFiveCount());
        messageUtil.printWinningResult(FIVE_WITH_BONUS.getMatchNumber(), FIVE_WITH_BONUS.getPrice(), lottoMatchCount.getFiveWithBonusCount());
        messageUtil.printWinningResult(SIX.getMatchNumber(), SIX.getPrice(), lottoMatchCount.getSixCount());

        long totalAmount = getTotalWinningAmount();
        double totalWinningRate = getTotalWinningRate(lottoAmount, totalAmount);
        messageUtil.printWinningRate(totalWinningRate);
    }
    private int checkBonusNumber(int matchCount, List<Integer> userLottoNumbers){
        if(userLottoNumbers.contains(lottoBonusNumberInfo.getLottoBonusNum())){
            matchCount *= 100;
        }
        return matchCount;
    }

    private long getTotalWinningAmount(){
        long totalAmount = (long) lottoMatchCount.getThreeCount() * THREE.getPrice()
                + (long) lottoMatchCount.getFourCount() * FOUR.getPrice()
                + (long) lottoMatchCount.getFiveCount() * FIVE.getPrice()
                + (long) lottoMatchCount.getFiveWithBonusCount() * FIVE_WITH_BONUS.getPrice()
                + (long) lottoMatchCount.getSixCount() * SIX.getPrice();
        return totalAmount;
    }
    private double getTotalWinningRate(int lottoAmount, long totalAmount){
        return ((double) totalAmount / (double) (lottoAmount * 1000)) * 100;
    }
}
