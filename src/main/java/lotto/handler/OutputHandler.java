package lotto.handler;

import static lotto.message.SystemMessage.*;
import static lotto.util.OutputUtil.*;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import lotto.domain.GameResult;
import lotto.domain.Lotto;
import lotto.globar.LottoResultInfo;
import lotto.view.OutputView;

public class OutputHandler {
    private OutputHandler() {
    }

    public static void outputLottosInfo(List<Lotto> lottos){
        OutputView.printMessageBlankLine();
        printLottosAmount(lottos);
        OutputView.printMessagesWithBlankLine(lottos);
    }

    private static void printLottosAmount(List<Lotto> lottos) {
        OutputView.print(formatSystemMessageWithNumber(OUTPUT_PURCHASE_LOTTO_AMOUNT, lottos.size()));
    }

    public static void outputGameResult(GameResult gameResult) {
        Map<LottoResultInfo, Integer> finalResult = gameResult.getFinalResult();
        Map<LottoResultInfo, Integer> sortedResultMap = new TreeMap<>(finalResult);

        printFinalResult(sortedResultMap);
    }

    private static void printFinalResult(Map<LottoResultInfo, Integer> sortedResultMap) {
        OutputView.printMessage(OUTPUT_WINNING_STATISTICS);

        for (Entry<LottoResultInfo, Integer> entry : sortedResultMap.entrySet()) {
            LottoResultInfo lottoResultInfo = entry.getKey();
            int count = entry.getValue();

            OutputView.print(String.format(OUTPUT_LOTTO_RESULT.getMessage(),
                    lottoResultInfo.getMatchingInfo()
                    , lottoResultInfo.getPrize()
                    , count));
        }
    }

    public static void outputRateOfReturn(GameResult gameResult) {
        OutputView.print(String.format(OUTPUT_GAME_RETURN.getMessage(), gameResult.getRateOfReturn()));
    }
}
