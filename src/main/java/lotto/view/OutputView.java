package lotto.view;

import lotto.domain.Rank;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import static lotto.domain.Rank.*;

public class OutputView {

    private static final String DECIMAL_PATTERN = "###,###";
    private static final String LOTTO_COUNT_POSTFIX_MESSAGE = "개를 구매했습니다.";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.";
    private static final String LOTTO_NUMBERS_PREFIX_MESSAGE = "[";
    private static final String LOTTO_NUMBERS_POSTFIX_MESSAGE = "]";
    private static final String SEPARATION = ", ";

    DecimalFormat decimalFormat = new DecimalFormat(DECIMAL_PATTERN);

    public void printLottoCount(long lottoCount) {
        System.out.println(lottoCount + LOTTO_COUNT_POSTFIX_MESSAGE);
    }

    public void printLottoNumbers(List<Integer> lottoNumbers) {
        System.out.println(makeLottoNumberMessage(lottoNumbers));
    }

    public void printLottosResult(Map<Rank, Integer> results){
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (" + decimalFormat.format(FIFTH.getPrize()) + "원) - " + results.get(FIFTH) + "개");
        System.out.println("4개 일치 (" + decimalFormat.format(FOURTH.getPrize()) + "원) - " + results.get(FOURTH) + "개");
        System.out.println("5개 일치 (" + decimalFormat.format(THIRD.getPrize()) + "원) - " + results.get(THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (" + decimalFormat.format(SECOND.getPrize()) + "원) - " + results.get(SECOND) + "개");
        System.out.println("6개 일치 (" + decimalFormat.format(FIRST.getPrize()) + "원) - " + results.get(FIRST) + "개");
    }

    public void printRateOfReturn(double rateOfReturn){
        System.out.printf(RATE_OF_RETURN_MESSAGE, rateOfReturn);
    }


    private String makeLottoNumberMessage(List<Integer> lottoNumbers) {
        StringBuilder sb = new StringBuilder(LOTTO_NUMBERS_PREFIX_MESSAGE);
        lottoNumbers.forEach(n -> sb.append(n).append(SEPARATION));
        sb.delete(sb.length()-2, sb.length());
        sb.append(LOTTO_NUMBERS_POSTFIX_MESSAGE);
        return sb.toString();
    }


}
