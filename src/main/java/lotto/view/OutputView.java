package lotto.view;


import lotto.model.LottoNumberModel;
import lotto.model.LottoResultModel;


public class OutputView {

    private static final String LOTTO_THIRD_MATCH_MESSAGE = "3개 일치 (5,000원) - ";
    private static final String LOTTO_FOURTH_MATCH_MESSAGE = "4개 일치 (50,000원) - ";
    private static final String LOTTO_FIFTH_MATCH_MESSAGE = "5개 일치 (1,500,000원) - ";
    private static final String LOTTO_FIFTH_BONUS_MATCH_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String LOTTO_SIXTH_MATCH_MESSAGE = "6개 일치 (2,000,000,000원) - ";
    private static final String TOTAL_RETURN_RATE = "총 수익률은 ";
    private static final String COUNT_UNIT = "개";
    private static final String PERCENT = "%";
    private static final String SUFFIX_MESSAGE = "입니다.";
    private static final String DIVIDING_LINE = "---";
    private static final String LOTTO_WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String PURCHASE_LOTTO_MESSAGE = "개를 구매했습니다.";

    public void purchaseLottoNumbersDisplay(LottoNumberModel lottoNumberModel){
        System.out.println();
        System.out.println(lottoNumberModel.getLottoQuantity()+PURCHASE_LOTTO_MESSAGE);
        lottoNumberModel.lottoNumberDisplay();
        System.out.println();
    }

    public void lottoResultDisplay(LottoResultModel lottoResultModel){
        System.out.println();
        System.out.println(LOTTO_WINNING_STATISTICS_MESSAGE);
        System.out.println(DIVIDING_LINE);
        System.out.println(LOTTO_THIRD_MATCH_MESSAGE + lottoResultModel.getThreeMatch()+COUNT_UNIT);
        System.out.println(LOTTO_FOURTH_MATCH_MESSAGE + lottoResultModel.getFourMatch()+COUNT_UNIT);
        System.out.println(LOTTO_FIFTH_MATCH_MESSAGE + lottoResultModel.getFiveMatch()+COUNT_UNIT);
        System.out.println(LOTTO_FIFTH_BONUS_MATCH_MESSAGE + lottoResultModel.getFiveBonusMatch()+COUNT_UNIT);
        System.out.println(LOTTO_SIXTH_MATCH_MESSAGE + lottoResultModel.getSixMatch()+COUNT_UNIT);
        System.out.println(TOTAL_RETURN_RATE+  lottoResultModel.getTotalReturnRate() +PERCENT+SUFFIX_MESSAGE);
    }
}
