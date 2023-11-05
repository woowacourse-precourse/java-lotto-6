package lotto.util;

import static lotto.view.constants.ConstantMessage.*;

import java.util.List;
import java.util.stream.Collectors;
import lotto.view.constants.ConstantMessage;

/*
    TODO : 당첨 통계 메시지 숫자, 세 자리 단위로 ,로 구분하여 포맷팅 필요
    TODO : 당첨 통계 메시지 순서, 3~6 일치순으로 정렬하여 메시지 빌드 필요
    TODO : 수익률 로직 수정

 */


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

    public static String buildGenerateLotteriesResultMessage(final List<List<Integer>> lotteriesNumbers) {
        return lotteriesNumbers.stream()
                .map(lottoNumbers -> "[" +
                        lottoNumbers.stream()
                                .map(Object::toString)
                                .collect(Collectors.joining(", "))
                        + "]")
                .collect(Collectors.joining("\n"));
    }

    public static String buildLottoResultMessage(Long matchCount, Integer prize, Integer winning) {
        return buildMessage(LOTTO_RESULT, matchCount, prize, winning);
    }

    public static String buildLottoResultWithBonusMessage(Long matchCount, Integer prize, Integer winning) {
        return buildMessage(LOTTO_RESULT_WITH_BONUS, matchCount, prize, winning);
    }

    public static String buildTotalReturnRateMessage(Double totalReturnRate) {
        return buildMessage(TOTAL_RETURN_RATE, totalReturnRate);
    }
}
