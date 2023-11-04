package lotto.util;

import static lotto.view.constants.ConstantMessage.*;

import java.util.List;
import java.util.stream.Collectors;
import lotto.view.constants.ConstantMessage;

public class ConstantMessageBuilder {
    private ConstantMessageBuilder() {
    }

    private static String buildMessage(ConstantMessage messageEnum, Object... args) {
        return String.format(messageEnum.getMessage(), args);
    }

    public static String buildPurchaseAmountMessage() {
        return buildMessage(ENTERING_PURCHASE_AMOUNT);
    }

    public static String buildPurchaseQuantityMessage(Integer quantity) {
        return buildMessage(GUIDANCE_FOR_PURCHASE_QUANTITY, quantity);
    }

    public static String buildWinningNumberMessage() {
        return buildMessage(ENTERING_WINNING_NUMBER);
    }

    public static String buildBonusNumberMessage() {
        return buildMessage(ENTERING_BONUS_NUMBER);
    }

    public static String buildWinningStatisticsMessage() {
        return buildMessage(WINNING_STATISTICS_NOTICE);
    }

    public static String buildDividerMessage() {
        return buildMessage(DIVIDER);
    }

    public static String buildLottoResultMessage(Integer matchCount, Integer prize, Integer winning) {
        return buildMessage(LOTTO_RESULT, matchCount, prize, winning);
    }

    public static String buildLottoResultWithBonusMessage(Integer matchCount, Integer prize, Integer winning) {
        return buildMessage(LOTTO_RESULT_WITH_BONUS, matchCount, prize, winning);
    }

    public static String buildTotalReturnRateMessage(Float totalReturnRate) {
        return buildMessage(TOTAL_RETURN_RATE, totalReturnRate);
    }

    public static String buildLottoNumberMessage(final List<List<Integer>> lottoNumberList) {
        return lottoNumberList.stream()
                .map(lottoNumbers -> "[" +
                        lottoNumbers.stream()
                                .map(Object::toString)
                                .collect(Collectors.joining(", "))
                        + "]")
                .collect(Collectors.joining("\n"));
    }
}
