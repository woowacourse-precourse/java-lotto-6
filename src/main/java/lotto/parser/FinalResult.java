package lotto.parser;

import lotto.model.LottoResult;

public class FinalResult {
    private final Integer THREE_MATCH = 5000;
    private final Integer FOUR_MATCH = 50000;
    private final Integer FIVE_MATCH = 1500000;
    private final Integer FIVE_MATCH_AND_BONUS = 30000000;
    private final Integer SIX_MATCH = 2000000000;
    private LottoResult lottoResult;
    public FinalResult(final LottoResult lottoResult) {
        this.lottoResult = lottoResult;
        sumOfResult();
    }
    private void sumOfResult() {
        this.lottoResult.countingMatchCount();
        this.lottoResult.matchingCount(3,false);
        this.lottoResult.matchingCount(4,false);
        this.lottoResult.matchingCount(5,false);
        this.lottoResult.matchingCount(6,false);
        this.lottoResult.matchingCount(6,true);
    }
    // 당첨 금액 출력
    public void printResult() {
        System.out.println("3개 일치 (5,000원) - " + this.lottoResult.getCountList().get(0) + "개");
        System.out.println("4개 일치 (50,000원) - " + this.lottoResult.getCountList().get(1) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + this.lottoResult.getCountList().get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + this.lottoResult.getCountList().get(3) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + this.lottoResult.getCountList().get(4) + "개");
    }

    public void printProfitRate(Integer price) {
        Integer sum = this.lottoResult.getCountList().get(0) * THREE_MATCH + this.lottoResult.getCountList().get(1) * FOUR_MATCH + this.lottoResult.getCountList().get(2) * FIVE_MATCH + this.lottoResult.getCountList().get(3) * FIVE_MATCH_AND_BONUS + this.lottoResult.getCountList().get(4) * SIX_MATCH;
        System.out.println("총 수익률은 " + (double)sum / price * 100 + "%입니다.");
    }
}
