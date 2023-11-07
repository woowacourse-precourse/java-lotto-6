package lotto.view;

import lotto.model.Lottos;
import lotto.model.FinalResult;
import lotto.view.common.CommonView;
import static lotto.view.constant.LottoMessage.*;
import static lotto.view.constant.LottoGradeMessage.*;
import java.util.List;


public class LottoOutputView extends CommonView {
    private static final Integer PERCENT = 100;

    public static void printResponsePurchaseAmount(int lottoCount){
        printWhiteSpace();
        printVariableMessage(lottoCount + RESPONSE_PURCHASE_AMOUNT.getMessage());
    }
    public static void printRandomLottos(Lottos randomLottos){
        printVariableMessage(randomLottos.toString());
    }
    public static void printResultMessages(){
        printWhiteSpace();
        printConstantMessage(SHOW_STATISTICS);
        printConstantMessage(SHOW_STATISTICS_DELIMITER);
    }
    public static void printResultMessage(FinalResult finalResult, int price){
        printResult(finalResult);
        printProfitRate(finalResult,price);
    }
    public static void printResult(FinalResult finalResult) {
        List<Integer> countList = finalResult.lottoResult().lottoMatchCount().getCountList();
        printVariableMessage(THREE_GRADE.getComment(countList.get(THREE_GRADE.getIndex())));
        printVariableMessage(FOUR_GRADE.getComment(countList.get(FOUR_GRADE.getIndex())));
        printVariableMessage(FIVE_GRADE.getComment(countList.get(FIVE_GRADE.getIndex())));
        printVariableMessage(FIVE_GRADE_AND_BONUS.getComment(countList.get(FIVE_GRADE_AND_BONUS.getIndex())));
        printVariableMessage(SIX_GRADE.getComment(countList.get(SIX_GRADE.getIndex())));
    }
    public static void printProfitRate(FinalResult finalResult, Integer price) {
        List<Integer> countList = finalResult.lottoResult().lottoMatchCount().getCountList();
        int sum = countList.get(THREE_GRADE.getIndex()) * THREE_GRADE.getPrize()
                + countList.get(FOUR_GRADE.getIndex()) * FOUR_GRADE.getPrize()
                + countList.get(FIVE_GRADE.getIndex()) * FIVE_GRADE.getPrize()
                + countList.get(FIVE_GRADE_AND_BONUS.getIndex()) * FIVE_GRADE_AND_BONUS.getPrize()
                + countList.get(SIX_GRADE.getIndex()) * SIX_GRADE.getPrize();
        printVariableMessage(SHOW_STATISTICS_YIELD.getMessage() + (float)sum / price * PERCENT + SHOW_STATISTICS_YIELD_SUFFIX.getMessage());
    }


}
