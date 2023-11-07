package lotto.view.result;

import static lotto.view.constant.CharacterSymbol.BLANK;
import static lotto.view.constant.CharacterSymbol.HYPEN;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.prize.LottoPrizeType;
import lotto.domain.profit.LottoProfitRate;
import lotto.domain.result.LottoPrizeResult;
import lotto.view.constant.CharacterSymbol;

public class ResultViewFormatter {

    private static final String LOTTO_PURCHASE_QUANTITY_FORMAT = "%d개를 구매했습니다.";
    private static final String PROFIT_RATE_FORMAT = "총 수익률은 %s%%입니다.";

    public String toLottoNumberPrintFormat(List<Lotto> lottos) {
        return lottos.stream()
                .map(Lotto::getNumbers)
                .map(numbers -> numbers.stream()
                        .sorted(Integer::compareTo)
                        .toList())
                .map(numbers -> Arrays.toString(numbers.toArray()))
                .collect(Collectors.joining(BLANK.getLiteral() + System.lineSeparator()));
    }

    public String toLottoPurchaseQuantityFormat(int quantity) {
        return LOTTO_PURCHASE_QUANTITY_FORMAT.formatted(quantity);
    }

    public String toProfitRateFormat(LottoProfitRate profitRate) {
        return PROFIT_RATE_FORMAT.formatted(String.valueOf(profitRate.getRate().doubleValue()));
    }

    public String toPrizeResultFormat(LottoPrizeResult prizeResult) {
        return Arrays.stream(LottoPrizeType.values())
                .sorted(Collections.reverseOrder())
                .map(type -> toSpecificPrizeResultFormat(type, prizeResult.getWinningCountByPrizeType()))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String toSpecificPrizeResultFormat(LottoPrizeType type, Map<LottoPrizeType, Integer> countByType) {
        return new StringBuilder()
                .append("%d개 일치".formatted(type.getWinningNumberCountCriterion()))
                .append(toBonusBallMatchCriterion(type))
                .append(BLANK.getLiteral())
                .append("(%s원)".formatted("%,d".formatted(type.getAmount().intValue())))
                .append(BLANK.getLiteral())
                .append(HYPEN.getLiteral())
                .append(BLANK.getLiteral())
                .append("%d개".formatted(countByType.getOrDefault(type, 0)))
                .toString();
    }

    private String toBonusBallMatchCriterion(LottoPrizeType type) {
        if (type.needToMatchBonusNumber()) {
            return ", 보너스 볼 일치";
        }
        return CharacterSymbol.EMPTY.getLiteral();
    }

}
