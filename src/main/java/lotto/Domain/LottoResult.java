package lotto.Domain;

import lotto.Util.PrintLottoResult;
import static lotto.Constant.LottoMatchResult.*;

import java.util.List;
import java.util.function.Predicate;

public class LottoResult {
    private final LottoStats lottoStats = new LottoStats();
    private final PrintLottoResult printLottoResult = new PrintLottoResult();

    private final LottoWinningNumber lottoWinningNumber;

    public LottoResult(LottoWinningNumber lottoWinningNumber){
        this.lottoWinningNumber = lottoWinningNumber;
    }

    public double getTotalWinningReward(){
        return (double) lottoStats.getMatchCountThree() * MATCH_THREE.getLottoReward() +
                (double) lottoStats.getMatchCountFour() * MATCH_FOUR.getLottoReward() +
                (double) lottoStats.getMatchCountFive() * MATCH_FIVE.getLottoReward() +
                (double) lottoStats.getMatchCountSix() * MATCH_SIX.getLottoReward() +
                (double) lottoStats.getMatchCountFiveWithBonus() * MATCH_FIVE_WITH_BONUS.getLottoReward();
    }
    public void printLottoMatchResult(int userLottoAmount){
        printLottoResult.printWinningResult(MATCH_THREE.getMatchCount(), MATCH_THREE.getLottoReward(), lottoStats.getMatchCountThree());
        printLottoResult.printWinningResult(MATCH_FOUR.getMatchCount(), MATCH_FOUR.getLottoReward(), lottoStats.getMatchCountFour());
        printLottoResult.printWinningResult(MATCH_FIVE.getMatchCount(), MATCH_FIVE.getLottoReward(), lottoStats.getMatchCountFive());
        printLottoResult.printWinningResult(MATCH_SIX.getMatchCount(), MATCH_SIX.getLottoReward(), lottoStats.getMatchCountSix());
        printLottoResult.printWinningResult(MATCH_FIVE_WITH_BONUS.getMatchCount(), MATCH_FIVE_WITH_BONUS.getLottoReward(), lottoStats.getMatchCountFiveWithBonus());

        double userTotalReward = getTotalWinningReward();
        double userTotalRateReward = Double.parseDouble(userReturn(userLottoAmount, userTotalReward));
        printLottoResult.printTotalWinningReward(userTotalRateReward);
    }

    private void addMatchCount(int matchCount){
        if(matchCount == MATCH_THREE.getMatchCount()){
            lottoStats.addMatchCountThree();
        }
        if(matchCount == MATCH_FOUR.getMatchCount()){
            lottoStats.addMatchCountFour();
        }
        if(matchCount == MATCH_FIVE.getMatchCount()){
            lottoStats.addMatchCountFive();
        }
        if(matchCount == MATCH_SIX.getMatchCount()){
            lottoStats.addMatchCountSix();
        }
        if(matchCount == MATCH_FIVE_WITH_BONUS.getMatchCount()){
            lottoStats.addMatchCountFiveWithBonus();
        }
    }

    private int getMatchCount(List<Integer> userLottoNumber){
        return Long.valueOf(lottoWinningNumber.getUserWinningNumber().stream().filter(lottonumber -> userLottoNumber.stream().anyMatch(Predicate.isEqual(lottonumber))).count()).intValue();
    }

    public void getLottoList(List<Lotto> userLotto, int userLottoAmount){
        printLottoResult.printWinningMessage();

        for(Lotto userlotto : userLotto){
            List<Integer> userLottoNumber = userlotto.getLottoNumber();
            int matchCount = getMatchCount(userLottoNumber);
            addMatchCount(includeBonusNumber(userLottoNumber, matchCount));
        }

        printLottoMatchResult(userLottoAmount);
    }

    private int includeBonusNumber(List<Integer> userLottoNumber, int matchCount){
        if(matchCount == MATCH_FIVE.getMatchCount() && userLottoNumber.contains(lottoWinningNumber.getUserBonusNumber())){
            return MATCH_FIVE_WITH_BONUS.getMatchCount();
        }
        return matchCount;
    }

    private String userReturn(int userLottoAmount, double lottoWinningCount){
        if(lottoWinningCount == 0){
            return "0";
        }
        double profit = getTotalWinningReward() - Double.parseDouble(String.valueOf(userLottoAmount));
        double userReturnValue = (lottoWinningCount / Double.parseDouble(String.valueOf(userLottoAmount)) / 10);
        return String.format("%.1f", userReturnValue);

    }

}
