package lotto.view;

import lotto.domain.prize.constants.PrizeGrade;
import lotto.dto.FinalResultResponse;
import lotto.dto.LottoNumberResponse;
import lotto.dto.LottoNumberResponses;
import lotto.view.constants.PrintMessage;

import java.util.EnumMap;

import static lotto.domain.prize.constants.PrizeGrade.HIT_THREE;
import static lotto.view.constants.PrintMessage.*;

public class OutputView {
    public static void printMessage(final PrintMessage message) {
        println(message.getMessage());
    }

    public static void println(final Object data) {
        System.out.println(data);
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printPurchaseLottoNumbers(final LottoNumberResponses responses) {
        responses.lottoResponses()
                .stream()
                .map(LottoNumberResponse::numbers)
                .forEach(OutputView::println);

        printNewLine();
    }

    public static void printPurchaseCount(final LottoNumberResponses responses) {
        String formattedMessage = String.format(RESPONSE_PURCHASE_COUNT.getMessage(), responses.purchaseCount());
        println(formattedMessage);
    }

    public static void printFinalResult(final FinalResultResponse response) {
        printNewLine();
        printMessage(RESPONSE_PRIZE_STATISTICS);
        printMessage(RESPONSE_SEPARATOR);

        String formattedYieldMessage = String.format(
                RESPONSE_YIELD.getMessage(), response.getFormattedYield());
        printEachMatcingResult(response);
        println(formattedYieldMessage);
    }

    private static void printEachMatcingResult(FinalResultResponse response) {
        EnumMap<PrizeGrade, Integer> prizeGradeIntegerEnumMap = response.prizeResultCount();

        if (prizeGradeIntegerEnumMap.containsKey(HIT_THREE)) {
            String format = RESPONSE_MATCHING.getMessage();
            String formattedMessage = String.format(format, HIT_THREE.getPrizeMatchingCount(), HIT_THREE.getPrizeAmount(), prizeGradeIntegerEnumMap.get(HIT_THREE));
            OutputView.println(formattedMessage);
        }
    }
}
