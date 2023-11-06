package lotto.parser;

import lotto.model.LottoResult;
import lotto.view.constant.LottoGrade.*;
import lotto.view.constant.LottoMessage.*;

import java.util.List;

import static lotto.view.constant.LottoGrade.*;
import static lotto.view.constant.LottoMessage.SHOW_STATISTICS_YIELD;
import static lotto.view.constant.LottoMessage.SHOW_STATISTICS_YIELD_SUFFIX;

public class FinalResult {
    private final Integer PERCENT = 100;
    private final LottoResult lottoResult;
    public FinalResult(final LottoResult lottoResult) {
        this.lottoResult = lottoResult;
        sumOfResult();
    }
    private void sumOfResult() {
        this.lottoResult.countingMatchCount();
        this.lottoResult.matchingCount(3);
        this.lottoResult.matchingCount(4);
        this.lottoResult.matchingCount(5);
        this.lottoResult.matchingCount(6);
    }
    // 당첨 금액 출력
    public void printResult() {
        List<Integer> countList = this.lottoResult.getCountList();
        System.out.println(THREE_GRADE.getComment(countList.get(0)));
        System.out.println(FOUR_GRADE.getComment(countList.get(1)));
        System.out.println(FIVE_GRADE.getComment(countList.get(2)));
        System.out.println(FIVE_GRADE_AND_BONUS.getComment(countList.get(3)));
        System.out.println(SIX_GRADE.getComment(countList.get(4)));
    }

    public void printProfitRate(Integer price) {
        Integer sum = this.lottoResult.getCountList().get(0) * THREE_GRADE.getPrize()
                + this.lottoResult.getCountList().get(1) * FOUR_GRADE.getPrize()
                + this.lottoResult.getCountList().get(2) * FIVE_GRADE.getPrize()
                + this.lottoResult.getCountList().get(3) * FIVE_GRADE_AND_BONUS.getPrize()
                + this.lottoResult.getCountList().get(4) * SIX_GRADE.getPrize();
        System.out.println(SHOW_STATISTICS_YIELD.getMessage() + (float)sum / price * PERCENT + SHOW_STATISTICS_YIELD_SUFFIX.getMessage());
    }
}
