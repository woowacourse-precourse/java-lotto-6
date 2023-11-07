package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import lotto.dto.ResultDto;
import lotto.embedded.LottoResult;
import lotto.message.OutputMessage;
import lotto.model.Lotto;

public class OutputView {

    public void printTotalPriceAsk() {
        System.out.println(OutputMessage.TOTAL_PRICE);
    }

    public void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + OutputMessage.LOTTO_COUNT.toString());
    }

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

    public void printResult(ResultDto totalResult) {
        LottoResult[] values = LottoResult.values();
        Map<LottoResult, Integer> resultMap = totalResult.resultMap();

        System.out.println(OutputMessage.RESULT_SUMMARY);

        for (LottoResult result : values) {
            if(result.isWin()){
                System.out.println(result.getDescription() + " - " + resultMap.getOrDefault(result, 0) + "개");
            }
        }

        DecimalFormat decimalFormat = new DecimalFormat("0.#");

        System.out.println("총 수익률은 " + decimalFormat.format(totalResult.yield()) + "%입니다.");
    }
}
