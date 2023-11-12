package lotto.util;

import static lotto.config.GameConfig.END_INCLUSIVE;
import static lotto.config.GameConfig.NUMBER_OF_LOTTO_NUMBERS;
import static lotto.config.GameConfig.START_INCLUSIVE;
import static lotto.exception.ExceptionMessage.INVALID_LOTTO_NUMBER_RANGE;
import static lotto.exception.ExceptionMessage.INVALID_WINNING_NUMBER_COUNT;
import static lotto.view.constants.ConstantMessage.DIVIDER;
import static lotto.view.constants.ConstantMessage.ENTERING_BONUS_NUMBER;
import static lotto.view.constants.ConstantMessage.ENTERING_PURCHASE_AMOUNT;
import static lotto.view.constants.ConstantMessage.ENTERING_WINNING_NUMBER;
import static lotto.view.constants.ConstantMessage.GUIDANCE_FOR_PURCHASE_QUANTITY;
import static lotto.view.constants.ConstantMessage.LOTTO_RESULT;
import static lotto.view.constants.ConstantMessage.LOTTO_RESULT_WITH_BONUS;
import static lotto.view.constants.ConstantMessage.TOTAL_RETURN_RATE;
import static lotto.view.constants.ConstantMessage.WINNING_STATISTICS_NOTICE;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.ExceptionMessage;
import lotto.view.constants.ConstantMessage;


public class MessageBuilder {

    private static DecimalFormat lottoPrizeFormatter = new DecimalFormat("#,###");
    private static DecimalFormat returnRateFormatter = new DecimalFormat("#,###.#");


    private MessageBuilder() {
    }

    private static String buildMessage(ConstantMessage constantMessage, Object... args) {
        return String.format(constantMessage.getMessage(), args);
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

    public static String buildGenerateLotteriesResultMessage(final List<List<Integer>> lotteriesNumbers) {
        return lotteriesNumbers.stream()
                .map(lottoNumbers -> "[" +
                        lottoNumbers.stream()
                                .map(Object::toString)
                                .collect(Collectors.joining(", "))
                        + "]")
                .collect(Collectors.joining("\n"));
    }

    private static String formatLottoPrize(Integer prize) {
        return lottoPrizeFormatter.format(prize);
    }

    public static String buildLottoResultMessage(Long matchCount, Integer prize, Integer winning) {
        return buildMessage(LOTTO_RESULT, matchCount, formatLottoPrize(prize), winning);
    }

    public static String buildLottoResultWithBonusMessage(Long matchCount, Integer prize, Integer winning) {
        return buildMessage(LOTTO_RESULT_WITH_BONUS, matchCount, formatLottoPrize(prize), winning);
    }

    private static String formatReturnRate(Double totalReturnRate) {
        return returnRateFormatter.format(totalReturnRate);
    }

    public static String buildTotalReturnRateMessage(Double totalReturnRate) {
        return buildMessage(TOTAL_RETURN_RATE, formatReturnRate(totalReturnRate));
    }

    private static String buildExceptionMessage(ExceptionMessage exceptionMessage, Object... args) {
        return String.format(exceptionMessage.getMessage(), args);
    }

    public static String buildInvalidWinningNumberMessage() {
        return buildExceptionMessage(INVALID_WINNING_NUMBER_COUNT, NUMBER_OF_LOTTO_NUMBERS);
    }

    public static String buildInvalidLottoNumberRangeMessage() {
        return buildExceptionMessage(INVALID_LOTTO_NUMBER_RANGE, START_INCLUSIVE, END_INCLUSIVE);
    }
}
