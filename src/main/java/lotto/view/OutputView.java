package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import lotto.model.ResultDto;
import lotto.model.LottoResult;
import lotto.message.OutputMessage;
import lotto.model.Lotto;

/**
 * 출력을 담당하는 뷰 클래스
 */
public class OutputView {

    public void printTotalPriceAsk() {
        System.out.println(OutputMessage.TOTAL_PRICE);
    }

    public void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + OutputMessage.LOTTO_COUNT.toString());
    }

    /**
     * 로또 리스트를 입력받아 출력
     * @param lottoList {@link Lotto} 리스트
     */
    public void printLottoList(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.toString());
        }
    }

    public void printWinningNumberAsk() {
        System.out.println(OutputMessage.WINNING_NUMBER);
    }

    public void printBonusNumberAsk() {
        System.out.println(OutputMessage.BONUS_NUMBER);
    }

    /**
     * 전체 결과를 출력하는 메서드
     * @param totalResult {@link ResultDto}
     */
    public void printResult(ResultDto totalResult) {
        LottoResult[] values = LottoResult.values();
        Map<LottoResult, Integer> resultMap = totalResult.resultMap();

        System.out.println(OutputMessage.RESULT_SUMMARY);

        for (LottoResult result : values) {
            if (result.isWin()) {
                System.out.println(result.getDescription() + " - " + resultMap.getOrDefault(result, 0) + "개");
            }
        }

        DecimalFormat decimalFormat = new DecimalFormat("0.#");

        System.out.println("총 수익률은 " + decimalFormat.format(totalResult.yield()) + "%입니다.");
    }
}
